package org.dhwani.practice.Mobile_Application.database;

import java.util.HashMap;

import org.dhwani.practice.Mobile_Application.model.*;

public class Database {
	private static HashMap<Long, Message> messages=new HashMap<>();
	private static HashMap<String, Profile> profiles=new HashMap<>();
	
	public static HashMap<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(HashMap<Long, Message> messages) {
		Database.messages = messages;
	}
	public static HashMap<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(HashMap<String, Profile> profiles) {
		Database.profiles = profiles;
	}
	
}
