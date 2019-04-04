
package com.practice.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.practice.messenger.model.Message;
import com.practice.messenger.model.UserProfile;

public class DatabaseClass {
	private static Map<Integer, Message> messages = new HashMap<>();
	private static Map<Integer, UserProfile> profiles = new HashMap<>();
	
	
	public static Map<Integer, Message> getMessages(){
		return messages;
	}
	public static Map<Integer, UserProfile> getProfiles(){
		return profiles;
	}
}
