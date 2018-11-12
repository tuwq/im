package root.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	
	public static boolean regexPhone(String phone) {
		String regEx = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches(); 
	}
	
	public static boolean regexQQnumber(String number) {
		String regEx = "^[1-9]\\d{4,10}$";;
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches(); 
	}
	
	public static boolean regExMail(String mail) {
		String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";;
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches(); 
	}
}
