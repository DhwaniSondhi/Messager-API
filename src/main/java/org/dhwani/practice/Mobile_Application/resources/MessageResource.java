package org.dhwani.practice.Mobile_Application.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import org.dhwani.practice.Mobile_Application.messageservice.MessageService;
import org.dhwani.practice.Mobile_Application.model.Comment;
import org.dhwani.practice.Mobile_Application.model.Message;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
MessageService messageService=new MessageService();
	
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size) {
		if(year>0)		return messageService.getAllMessagesForYear(year);
		else {
			if(start>=0  && size>0)			return messageService.getAllMessagesPaginate(start, size);
			else								return messageService.getAllMessages();
		}			
	}
	
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id); 
	}
	
	
	
	@POST
	public Response addMessage(Message msg,@Context UriInfo uriInfo){
		Message message=messageService.addMessage(msg); 
		/*
		 * This can be done but below code is favorable
		 * return Response.created(new URI(uriInfo.getAbsolutePath()+"/"+message.getId()))
				.entity(message)
				.build();*/
		URI uri=uriInfo.getAbsolutePathBuilder()
					   .path(String.valueOf(message.getId()))
					   .build();
		message.addLink(getSelfLink(message, uriInfo), "self");
		message.addLink(getAuthorLink(message, uriInfo), "author");
		message.addLink(getAllCommentsLink(message, uriInfo), "comments");
		
		
		return Response.created(uri)
				.entity(message)
				.build();
	}
	
	public String getAllCommentsLink(Message message,UriInfo uriInfo){
		return uriInfo.getBaseUriBuilder()
				 .path(MessageResource.class)
				 .path(MessageResource.class, "getCommentResouce")
				 .path(CommentResource.class)
				 .resolveTemplate("messageId", message.getId())
				 .build()
				 .toString();
	}
	
	public String getSelfLink(Message message,UriInfo uriInfo){
		return uriInfo.getBaseUriBuilder()
				 .path(MessageResource.class)
				 .path(String.valueOf(message.getId()))
				 .build()
				 .toString();
	}
	
	public String getAuthorLink(Message message,UriInfo uriInfo){
		return uriInfo.getBaseUriBuilder()
					  .path(ProfileResource.class)
					  .path(String.valueOf(message.getAuthor()))
					  .build()
					  .toString();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id, Message msg) {
		msg.setId(id);
		return messageService.updateMessage(msg); 
	}
	
	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id); 
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResouce() {
		return new CommentResource();
	}
	
	
}


   
