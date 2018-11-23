package root.netty;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MethodMapping {

	// 映射方法
	private static HashMap<String, Method> mappingMap = new HashMap<String, Method>();
		
	public static void addMapping(String actionName, Method targetMethod) {
		mappingMap.put(actionName, targetMethod);
	}
	
	public static Method mappingTo(String actionName) {
		return mappingMap.get(actionName);
	}
}
