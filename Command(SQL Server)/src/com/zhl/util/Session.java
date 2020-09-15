package com.zhl.util;

import com.zhl.bean.User;

public class Session {
	private static User user;
	
	public static User getUser() {
		return user;
	}
	
	public static void setUser(User user) {
		Session.user = user;
	}
}
