package root.netty.util;

import java.lang.reflect.Method;
import java.util.List;

import root.netty.NettyStorage;
import root.netty.annotations.SocketMapping;

public class AnnotationUtil {
	
	public static void validAnnotation(List<Class<?>> clsList){
		if (clsList != null && clsList.size() > 0) {
			for (Class<?> cls: clsList) {
				Method[] methods = cls.getDeclaredMethods();
				if (methods != null && methods.length > 0) {
					for (Method method : methods) {
						SocketMapping socketMapping = (SocketMapping) method.getAnnotation(SocketMapping.class);
						if (socketMapping != null) {
							NettyStorage.addMapping(socketMapping.value(), method);
						}
					}
				}
			}
		}
	}
}
