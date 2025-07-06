package com.app.quickconvo.mongoTemplateService;

import java.util.List;

import com.app.quickconvo.entity.UserCommunication;

public interface QuickConvoMongoTemplateService {

	List<UserCommunication> getConversationsOfUsersDataFromDB(String userId);

	List<UserCommunication> getAllChatsDataFromDB(String senderId, String receiverId);

}
