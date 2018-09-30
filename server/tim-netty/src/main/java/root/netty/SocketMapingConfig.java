package root.netty;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import root.netty.controller.SocketController;
import root.netty.util.AnnotationUtil;
import root.util.ClassUtil;


@Component
public class SocketMapingConfig {
		
	private static class SingletionSocketMapingConfig {
		static final SocketMapingConfig instance = new SocketMapingConfig();
	}
	
	public static SocketMapingConfig getInstance() {
		return SingletionSocketMapingConfig.instance;
	}
	
	
	private String basePack = "root.netty.controller";
	
	private List<String> classPaths = new ArrayList<String>();
	
	public void init() throws ClassNotFoundException {
		List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(SocketController.class.getPackage());
		AnnotationUtil.validAnnotation(clsList);
	}

}
