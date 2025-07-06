package com.app.quickconvo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.quickconvo.entity.UserCommunication;

public interface QuickConvoRepository extends MongoRepository<UserCommunication, String> {

	List<UserCommunication> findBySenderId(String userId);

}
