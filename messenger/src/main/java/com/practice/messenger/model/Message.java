package com.practice.messenger.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message 
{
	int id;
	String messageText;
	List<Comment> comments = new ArrayList<>();
	
	public Message(){}

	
	public Message(int id, String messageText) {
		super();
		this.id = id;
		this.messageText = messageText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	};
}
