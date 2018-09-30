package root.util;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtil {
	
	
	// 获取指定包以及子包下所有类
	public static List<Class<?>> getAllClassByPackageName(Package pkg) {
		String packageName = pkg.getName();
		List<Class<?>> returnClassList = getClasses(packageName);
		return returnClassList;
	}
	
	// 从包package中获取所有的Class
	private static List<Class<?>> getClasses(String packageName) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		boolean recursive = true;
		String packageDirName = packageName.replace('.', '/');
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				String protocol = url.getProtocol();
				if ("file".equals(protocol)) {
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				} else if("jar".equals(protocol)) {
					JarFile jar;
					try {
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						Enumeration<JarEntry> entries = jar.entries();
						while (entries.hasMoreElements()) {
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							if (name.charAt(0) == '/') {
								name = name.substring(1);
							}
							if (name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								if (idx != -1) {
									packageName = name.substring(0, idx).replace('/', '.');
								}
								if ((idx != -1) || recursive) {
									if (name.endsWith(".class") && !entry.isDirectory()) {
										String className = name.substring(packageName.length() + 1, name.length() - 6);
										try {
											classes.add(Class.forName(packageName + '.' + className));
										} catch(ClassNotFoundException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return classes;
	}
	
	private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes) {
		File dir = new File(packagePath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		File[] dirfiles = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		for (File file : dirfiles) {
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
			} else {
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					classes.add(Class.forName(packageName + '.' + className));
				} catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			} 
		}
		
	}

	// 通过接口名取得某个接口下所有实现这个接口的类
	public static List<Class<?>> getAllClassByInterface(Class<?> c) {
		List<Class<?>> returnClassList = null;
		if (c.isInterface()) {
			String packageName = c.getPackage().getName();
			List<Class<?>> allClass = getClasses(packageName);
			if (allClass != null && allClass.size() > 0) {
				returnClassList = new ArrayList<Class<?>>();
				for (Class<?> cls: allClass) {
					if (c.isAssignableFrom(cls)) {
						if (!c.equals(cls)) {
							returnClassList.add(cls);
						}
					}
				}
			}
		}
		return returnClassList;
	}
	
	// 取得某一类所在包的所有类名,不含迭代
	public static String[] getPackageAllClassName(String classLocation, String packageName) {
		String[] packagePathSplit = packageName.split("[.]");
		String realClassLocation = classLocation;
		int packageLength = packagePathSplit.length;
		for (int i = 0; i < packageLength; i++) {
			realClassLocation = realClassLocation + File.separator + packagePathSplit[i];
		}
		File packeageDir = new File(realClassLocation);
		if (packeageDir.isDirectory()) {
			String[] allClassName = packeageDir.list();
			return allClassName;
		}
		return null;
	}
	
	
}
