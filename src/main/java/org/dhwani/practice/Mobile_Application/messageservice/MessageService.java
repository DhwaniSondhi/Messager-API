package org.dhwani.practice.Mobile_Application.messageservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dhwani.practice.Mobile_Application.database.Database;
import org.dhwani.practice.Mobile_Application.exception.DataNotFoundException;
import org.dhwani.practice.Mobile_Application.model.Message;

public class MessageService {
	
	private HashMap<Long, Message> messages=Database.getMessages();
	private long longestId=2;
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello Dhwani","Dhwani"));
		messages.put(2L, new Message(2, "Hello Dhwani","Dhwani"));
		
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> inMessages=new ArrayList<Message>();
		Calendar calendar=Calendar.getInstance();
		for(Message msg:messages.values()) {
			calendar.setTime(msg.getCreated());
			if(calendar.get(Calendar.YEAR)==year)				inMessages.add(msg);
		}
		return inMessages;
	}
	
	public List<Message> getAllMessagesPaginate(int start,int size) {
		int max=(start+size)>messages.size()?messages.size():(start+size);
		return new ArrayList<Message>(messages.values()).subList(start, max);
	}
	
	public Message getMessage(long id) throws DataNotFoundException{
		Message msg=messages.get(id);
		if(msg==null)			throw new DataNotFoundException("Message not found");
		return msg;
	}
	
	public Message addMessage(Message msg){
		//if(longestId==0)			messages.clear();
		msg.setId(++longestId);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		if(messages.get(msg.getId())==null)				return null;
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public void removeMessage(long id) {
		messages.remove(id);
	}
}
