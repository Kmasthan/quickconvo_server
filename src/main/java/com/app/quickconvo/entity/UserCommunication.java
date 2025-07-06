package com.app.quickconvo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user-communication")
public class UserCommunication extends Auditable {

	@Id
	private String id;

	@Indexed
	private String senderId;
	private String senderName;
	private String senderMobile;
	
	@Indexed
	private String receverId;
	private String receverName;
	private String receverMobile;
	private String message;
	private boolean edited;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public String getReceverId() {
		return receverId;
	}

	public void setReceverId(String receverId) {
		this.receverId = receverId;
	}

	public String getReceverName() {
		return receverName;
	}

	public void setReceverName(String receverName) {
		this.receverName = receverName;
	}

	public String getReceverMobile() {
		return receverMobile;
	}

	public void setReceverMobile(String receverMobile) {
		this.receverMobile = receverMobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

}
