package org.dhwani.practice.Mobile_Application.messageservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dhwani.practice.Mobile_Application.database.Database;
import org.dhwani.practice.Mobile_Application.model.*;

public class CommentService {

	private HashMap<Long, Message> messages=Database.getMessages();
	int longestID=0;
	
	public List<Comment> getAllComments(long messageID){
		return new ArrayList<>(messages.get(messageID).getComments().values());
	}
	
	public Comment getComment(long messageID,long commentID){
		Message msg=messages.get(messageID);
		Response resp=Response.status(Status.NOT_FOUND).entity(new ErrorMessage(500,"NOT_FOUND","")).build();
		if(msg==null)					throw new WebApplicationException(resp);
		
		Comment cmt=msg.getComments().get(commentID);
		if(cmt==null)					throw new WebApplicationException();
		
		return cmt;
	}
	
	public Comment addComment(long messageID,Comment comment){
		HashMap<Long,Comment> comments=messages.get(messageID).getComments();
		comment.setId(++longestID);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(long messageID,Comment comment){
		HashMap<Long,Comment> comments=messages.get(messageID).getComments();
		if(comments.get(comment.getId())==null)				return null;
		comments.put(comment.getId(),comment);
		return comment;
	}
	public void removeComment(long messageID,long commentID){
		HashMap<Long,Comment> comments=messages.get(messageID).getComments();
		comments.remove(commentID);
	}
	
}
