package com.app.quickconvo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.quickconvo.dto.APISuccessMessage;
import com.app.quickconvo.entity.UserCommunication;
import com.app.quickconvo.service.QuickConvoUserCommunicarionService;

@RestController
public class QuickConvoUserCommunicarionController {

	@GetMapping("welcome")
	public String welcomeToQuckConvo() {
		return "Welcome to Quick Convo";
	}

	@Autowired
	private QuickConvoUserCommunicarionService quickConvoUserCommunicarionService;

	@GetMapping("get-conversations-of-users/{userid}")
	public List<UserCommunication> getConversationsOfUsers(@PathVariable("userid") String userId) {
		return quickConvoUserCommunicarionService.getConversationsOfUsersData(userId);
	}

	@PostMapping("save-user-convo")
	public APISuccessMessage saveUserCommunicationData(@RequestBody UserCommunication communication) {
		return quickConvoUserCommunicarionService.saveUserCommunicationData(communication);
	}

	@GetMapping("get-all-chats/{senderid}/{receiverid}")
	public List<UserCommunication> getAllChats(@PathVariable("senderid") String senderId,
			@PathVariable("receiverid") String receiverId) {
		return quickConvoUserCommunicarionService.getAllChatsData(senderId, receiverId);
	}

}
