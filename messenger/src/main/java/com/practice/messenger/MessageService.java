package com.practice.messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.practice.messenger.database.DatabaseClass;
import com.practice.messenger.exception.DataNotFoundException;
import com.practice.messenger.model.Message;

public class MessageService {

	private Map<Integer, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1, new Message(1, "hello"));
		messages.put(2, new Message(2, "hello again"));
	}
	
	public List<Message> getAllMessages()
	{
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagePagination(int start, int size)
	{
		return (new ArrayList(messages.values()).subList(start, size));
	}
	
	public Message addMessage(Message message) 
	{
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(int id)
	{
		return messages.remove(id);
	}
	
	public Message getMessage(int id)
	{
		Message message =  messages.get(id);
		
		if(!Objects.nonNull(message))
			throw new DataNotFoundException("Message with message id "+id+"not found");
		
		return messages.get(id);
	}
}

