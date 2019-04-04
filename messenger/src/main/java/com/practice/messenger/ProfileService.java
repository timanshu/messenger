package com.practice.messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.practice.messenger.database.DatabaseClass;
import com.practice.messenger.model.UserProfile;

public class ProfileService {
	private Map<Integer, UserProfile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put(1, new UserProfile(1, "Munny"));
		profiles.put(2, new UserProfile(2, "Nunny"));
	}
	
	public List<UserProfile> getAllProfiles()
	{
		return new ArrayList<>(profiles.values());
	}
	
	public UserProfile addProfile(UserProfile profile) 
	{
		profile.setProfileId(profiles.size() + 1);
		profiles.put(profile.getProfileId(), profile);
		return profile;
	}
	
	public UserProfile updateProfile(UserProfile profile)
	{
		profiles.put(profile.getProfileId(), profile);
		return profile;
	}
	
	public UserProfile removeProfile(int id)
	{
		return profiles.remove(id);
	}
	
	public UserProfile getProfile(int id)
	{
		return profiles.get(id);
	}
}
