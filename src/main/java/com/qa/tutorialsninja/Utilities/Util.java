package com.qa.tutorialsninja.Utilities;

import java.util.Date;

public class Util {

	public static String generateEmailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@gmail.com";
	}

	
	
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 100;
	public static final int SCRIPT_TIME = 500;

}
