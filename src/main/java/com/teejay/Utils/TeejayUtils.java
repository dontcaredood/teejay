package com.teejay.Utils;

import org.springframework.stereotype.Service;

import com.teejay.Model.User;
@Service
public class TeejayUtils {
	
	
	public static User userMapper(User user) {
		user.setUserLevel(1);
		user.setLastLogin("Not Yet");
		user.setIsActive("Y");
		return user;
	}
	
	public static String loginIdGenerator(User user) {
		String loginId = "tj"+user.getUsername().substring(1,4)+user.getUserId();
		return loginId;
	}
}
