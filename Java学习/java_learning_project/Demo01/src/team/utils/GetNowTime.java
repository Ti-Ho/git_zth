package team.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTime {
	public static String getNowTime() {
		return new SimpleDateFormat("yyyy:MM:dd:HH:mm").format(new Date());
	}
}
