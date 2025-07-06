package com.app.quickconvo.service;

import java.util.List;

import com.app.quickconvo.dto.APISuccessMessage;
import com.app.quickconvo.entity.UserCommunication;

public interface QuickConvoUserCommunicarionService {

	APISuccessMessage saveUserCommunicationData(UserCommunication communication);

	List<UserCommunication> getConversationsOfUsersData(String userId);

	List<UserCommunication> getAllChatsData(String senderId, String receiverId);

}
