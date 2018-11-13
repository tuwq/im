package root.util;

import java.util.UUID;

public class RandomUtil {
	
	
	public static String getPhoneValidate() {
		int number = (int)((Math.random()*9+1)*100000);
		return Integer.toString(number);
	}
	
	public static String getQQNumber() {
		int number = (int)((Math.random()*9+1)*10000000);
		return Integer.toString(number);
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		for (int i = 0; i< 100; i++) {
			System.out.println(RandomUtil.getQQNumber());
		}
	}
}
