package root.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


// 获取Spring的上下文
@Component("applicationContextUtil")
public class ApplicationContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public static <T> T popBean(Class<T> clazz) {
		if (applicationContext == null) {
			return null;	
		}
		return applicationContext.getBean(clazz);
	}
	
	public static <T> T popBean(String name, Class<T> clazz) {
		if (applicationContext == null) {
			return null;
		}
		return applicationContext.getBean(name, clazz);
	}
	
}
