package ro.cegeka.gfm.poc.common.lib;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class LexicalFactory {
	
	private String prefix;
	private List<String> packageList;
	
	/*
	 * Constructors
	 */

	public LexicalFactory() {
		this.packageList = new ArrayList<>();
		this.prefix = "";
	}

	/*
	 * Public methods
	 */
	
	public LexicalFactory setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}
	
	public LexicalFactory addPackage(String packageName) {
		if (!StringUtils.isNotEmpty(packageName)) { return this; }
		if (packageList.contains(packageName)) { return this; }
		packageList.add(packageName);
		return this;
	}
	
	public LexicalFactory clearPackages() { 
		this.packageList.clear();
		return this;
	}

	public Class<?> getType(String code) {
		Class<?> cls = findClass(code);
		return cls;
	}
	
	public Object createInstance(String code) {
		Class<?> type = getType(code);
		if (type == null) { return null; }
		Object obj = null;
		try {
			obj = type.newInstance();
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (SecurityException ex) {
		} catch (IllegalArgumentException ex) {
		}
		return obj;
	}

	/*
	 * Private methods
	 */
	
	private Class<?> findClass(String code) {
		Class<?> cls = null;
		for (String packageName : this.packageList) {
			cls = findClass(packageName, code);
			if (cls != null) { break; }
		}
		return cls;
	}
	
	private Class<?> findClass(String packageName, String code) {
		
		Class<?> cls = null;
		String classFqn = packageName + "." + this.prefix + code;
		try {
			cls =  Class.forName(classFqn);
		} catch (ClassNotFoundException ex) {
			// do nothing
		}
		return cls;
	}
}
