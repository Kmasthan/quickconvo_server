package com.app.quickconvo.mongoTemplateServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.app.quickconvo.entity.UserCommunication;
import com.app.quickconvo.exception.QuickConvoException;
import com.app.quickconvo.mongoTemplateService.QuickConvoMongoTemplateService;

@Service
public class QuickConvoMongoTemplateServiceImpl implements QuickConvoMongoTemplateService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<UserCommunication> getConversationsOfUsersDataFromDB(String userId) {
		try {
			MatchOperation matchOperation = Aggregation.match(new Criteria()
					.orOperator(Criteria.where("senderId").is(userId), Criteria.where("receverId").is(userId)));

			ProjectionOperation projectionOperation = Aggregation.project()
					.and(ConditionalOperators.when(Criteria.where("senderId").is(userId)).thenValueOf("receverId")
							.otherwiseValueOf("senderId"))
					.as("id")
					.and(ConditionalOperators.when(Criteria.where("senderId").is(userId)).thenValueOf("receverName")
							.otherwiseValueOf("senderName"))
					.as("name")
					.and(ConditionalOperators.when(Criteria.where("senderId").is(userId)).thenValueOf("receverMobile")
							.otherwiseValueOf("senderMobile"))
					.as("mobile");

			GroupOperation groupOperation = Aggregation.group("id").first("id").as("receverId").first("name")
					.as("receverName").first("mobile").as("receverMobile");

			Aggregation aggregation = Aggregation.newAggregation(matchOperation, projectionOperation, groupOperation);

			AggregationResults<UserCommunication> aggregationResults = mongoTemplate.aggregate(aggregation,
					"user-communication", UserCommunication.class);

			if (!aggregationResults.getMappedResults().isEmpty()) {
				return aggregationResults.getMappedResults();
			} else {
				return new ArrayList<>();
			}
		} catch (Exception e) {
			throw new QuickConvoException(e.getMessage());
		}
	}

	@Override
	public List<UserCommunication> getAllChatsDataFromDB(String senderId, String receiverId) {
		try {
			MatchOperation matchOperation = Aggregation.match(
					new Criteria().orOperator(Criteria.where("senderId").is(senderId).and("receverId").is(receiverId),
							Criteria.where("senderId").is(receiverId).and("receverId").is(senderId)));

			ProjectionOperation projectionOperation = Aggregation.project("senderId", "message", "createdAt");

			SortOperation sortOperation = Aggregation.sort(Direction.ASC, "createdAt");

			Aggregation aggregation = Aggregation.newAggregation(matchOperation, projectionOperation, sortOperation);

			AggregationResults<UserCommunication> aggregationResults = mongoTemplate.aggregate(aggregation,
					"user-communication", UserCommunication.class);

			if (!aggregationResults.getMappedResults().isEmpty()) {
				return aggregationResults.getMappedResults();
			} else {
				return new ArrayList<>();
			}
		} catch (Exception e) {
			throw new QuickConvoException(e.getMessage());
		}
	}
}
