package com.zhl.util;

import com.zhl.bean.Fresh;

public class Refresh {
	private static Fresh fresh;

	public static Fresh getFresh() {
		return fresh;
	}

	public static void setFresh(Fresh fresh) {
		Refresh.fresh = fresh;
	}
}
