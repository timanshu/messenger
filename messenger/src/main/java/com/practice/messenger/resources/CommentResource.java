package com.practice.messenger.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.practice.messenger.database.DatabaseClass;
import com.practice.messenger.model.Comment;
import com.practice.messenger.model.Message;

@Path("/")
public class CommentResource 
{
	private Map<Integer, Message> messages = DatabaseClass.getMessages();
	
	@GET
	public List<Comment> getComments(@PathParam("messageId") int messageId)
	{
		if(!messages.isEmpty())
			return messages.get(messageId).getComments();
		
		return new ArrayList<Comment>();
	}
	
	@GET
	@Path("/commentId")
	public Comment getComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId)
	{
		return messages.get(messageId).getComments().get(commentId);
	}
}
