package com.app.quickconvo.service_impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.quickconvo.dto.APISuccessMessage;
import com.app.quickconvo.entity.UserCommunication;
import com.app.quickconvo.exception.QuickConvoException;
import com.app.quickconvo.mongoTemplateService.QuickConvoMongoTemplateService;
import com.app.quickconvo.repository.QuickConvoRepository;
import com.app.quickconvo.service.QuickConvoUserCommunicarionService;

@Service
public class QuickConvoUserCommunicarionServiceImpl implements QuickConvoUserCommunicarionService {

	@Autowired
	private QuickConvoRepository quickConvoRepository;

	@Autowired
	private QuickConvoMongoTemplateService quickConvoMongoTemplateService;

	@Override
	public APISuccessMessage saveUserCommunicationData(UserCommunication communication) {
		try {
			quickConvoRepository.save(communication);
			return new APISuccessMessage("User communication saved succesfully", "SUCCESS");
		} catch (Exception e) {
			throw new QuickConvoException(e.getMessage());
		}
	}

	@Override
	public List<UserCommunication> getConversationsOfUsersData(String userId) {
		try {
			return quickConvoMongoTemplateService.getConversationsOfUsersDataFromDB(userId);
		} catch (Exception e) {
			throw new QuickConvoException(e.getMessage());
		}
	}

	@Override
	public List<UserCommunication> getAllChatsData(String senderId, String receiverId) {
		try {
			return quickConvoMongoTemplateService.getAllChatsDataFromDB(senderId, receiverId);
		} catch (Exception e) {
			throw new QuickConvoException(e.getMessage());
		}
	}

}
