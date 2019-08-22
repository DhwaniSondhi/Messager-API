package org.dhwani.practice.Mobile_Application.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.dhwani.practice.Mobile_Application.messageservice.ProfileService;
import org.dhwani.practice.Mobile_Application.model.*;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profileService=new ProfileService();
	
	
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles(); 
	}
	
	@GET
	@Path("/{profileID}")
	public Profile getProfile(@PathParam("profileID")String profileID) {
		return profileService.getProfile(profileID); 
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile); 
	}
	
	@PUT
	@Path("/{profileID}")
	public Profile updateProfile(@PathParam("profileID")String profileID,Profile profile) {
		return profileService.updateProfile(profileID,profile); 
	}
	
	@DELETE
	@Path("/{profileID}")
	public void removeProfile(@PathParam("profileID")String profileID) {
		profileService.removeProfile(profileID); 
	}
}
