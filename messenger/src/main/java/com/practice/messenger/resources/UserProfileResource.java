package com.practice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.practice.messenger.ProfileService;
import com.practice.messenger.model.UserProfile;

@Path("/profiles")
public class UserProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserProfile> getProfiles()
	{
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserProfile getProfile(@PathParam("profileId") int profileId)
	{
		return profileService.getProfile(profileId);
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserProfile> addProfile(UserProfile profile)
	{
		profileService.addProfile(profile);
		
		return getProfiles();
	}
	
	@PUT
	@Path("/{profileId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserProfile> updateProfile(@PathParam("profileId") int profileId, UserProfile profile)
	{
		profile.setProfileId(profileId);
		profileService.updateProfile(profile);
		return getProfiles();
	}
	
	@DELETE
	@Path("/{profileId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserProfile> remove(@PathParam("profileId") int profileId)
	{
		profileService.removeProfile(profileId);
		return getProfiles();
	}
}
