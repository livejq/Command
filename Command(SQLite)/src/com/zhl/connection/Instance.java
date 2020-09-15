package com.zhl.connection;

import com.zhl.importdb.UserDao;

public class Instance {

	private static UserDao general;

	public static UserDao getGeneral() {
		return general;
	}

	public static void setGeneral(UserDao general) {
		Instance.general = general;
	}

}
