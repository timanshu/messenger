package com.practice.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.practice.messenger.MessageService;
import com.practice.messenger.beans.MessageFilterBean;
import com.practice.messenger.model.Message;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean)
	{
		if(messageFilterBean.getStart()>=0 && messageFilterBean.getSize() > 0)
			return messageService.getAllMessagePagination(messageFilterBean.getStart(), messageFilterBean.getSize());
		
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") int messageId)
	{
		return messageService.getMessage(messageId);
	}
	
	@POST 
	public Response addMessage(@Context UriInfo uriInfo, Message message) throws URISyntaxException
	{
		Message newMessage = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		
		return Response.created(uri)
		.entity(newMessage)
		.build();
		
		//messageService.addMessage(message);
		
	//	return messageService.getAllMessages();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> updateMessage(@PathParam("messageId") int messageId, Message message)
	{
		message.setId(messageId);
		messageService.updateMessage(message);

		return messageService.getAllMessages();
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> remove(@PathParam("messageId") int messageId)
	{
		messageService.removeMessage(messageId);
		return messageService.getAllMessages();
	}
	
	@Path("/{messageId}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
