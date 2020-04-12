package team.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetClientNumber {
	public static String getClientNumber() {
		String str1 = "C";
		String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());  
		return str1 + str;
	}
}
