package com.practice.messenger.model;

public class UserProfile 
{
	public UserProfile(){}
	public UserProfile(int profileId, String name)
	{
		this.profileId 	= profileId;
		this.name		= name;
	}
	
	int profileId;
	String name;
	
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
