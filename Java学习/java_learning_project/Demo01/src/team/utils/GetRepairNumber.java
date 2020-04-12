package team.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetRepairNumber {
	public static String getRepairNumber() {
		String str1 = "R";
		String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());  
		return str1 + str;
	}
}
