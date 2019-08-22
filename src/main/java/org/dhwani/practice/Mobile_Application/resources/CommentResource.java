package org.dhwani.practice.Mobile_Application.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.dhwani.practice.Mobile_Application.messageservice.CommentService;
import org.dhwani.practice.Mobile_Application.messageservice.MessageService;
import org.dhwani.practice.Mobile_Application.model.Comment;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService=new CommentService();
	
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageID")long messageID) {
		return commentService.getAllComments(messageID);
	}
	
	@GET
	@Path("/{commentID}")
	public Comment getComment(@PathParam("messageID")long messageID,@PathParam("commentID")long commentID) {
		return commentService.getComment(messageID,commentID);
	}
	
	@POST
	public Comment addComment(@PathParam("messageID")long messageID,Comment comment) {
		return commentService.addComment(messageID,comment);
	}
	
	@PUT
	@Path("/{commentID}")
	public Comment updateComment(@PathParam("messageID")long messageID,@PathParam("commentID")long commentID,Comment comment) {
		comment.setId(commentID);
		return commentService.updateComment(messageID,comment);
	}
	
	@DELETE
	@Path("/{commentID}")
	public void removeComment(@PathParam("messageID")long messageID,@PathParam("commentID")long commentID) {
		commentService.removeComment(messageID,commentID);
	}
}
