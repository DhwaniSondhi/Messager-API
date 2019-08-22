package org.dhwani.practice.Mobile_Application.messageservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dhwani.practice.Mobile_Application.database.Database;
import org.dhwani.practice.Mobile_Application.model.Profile;

public class ProfileService {
	private HashMap<String, Profile> profiles=Database.getProfiles();
	private int longestID;
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String profileID){
		return profiles.get(profileID);
	}
	public Profile addProfile(Profile profile){
		profile.setId(profile.getProfileName() +(++longestID) );
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile updateProfile(String profileID,Profile profile){
		if(profiles.get(profileID)==null)				return null;
		profiles.put(profileID,profile);
		return profile;
	}
	public void removeProfile(String profileID){
		profiles.remove(profileID);
	}
}
