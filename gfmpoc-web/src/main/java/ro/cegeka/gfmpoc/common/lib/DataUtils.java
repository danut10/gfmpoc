package ro.cegeka.gfmpoc.common.lib;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import ro.cegeka.gfmpoc.common.core.intf.IDataObject;

public class DataUtils {
	
	public static IDataObject cloneFilter(IDataObject inputFilter) {
		if(inputFilter == null) {
			return null;
		}
		IDataObject outputFilter = (IDataObject) ObjectFactory.getInstance(inputFilter.getClass());
		for (PropertyDescriptor propertyDescriptor : PropertyUtils.getPropertyDescriptors(inputFilter)) {
			try {
				String propertyName = propertyDescriptor.getName();
				if (propertyName.equalsIgnoreCase("class")) { continue; }
				Object propertyValue = PropertyUtils.getProperty(inputFilter, propertyName);
				if (propertyValue == null) { continue; }
				Object newPropertyValue;
				Class<?> propertyClass = propertyDescriptor.getPropertyType();
				if (String.class.isAssignableFrom(propertyClass)) {
					String oldValue = propertyValue.toString();
					newPropertyValue = stringFilter(oldValue);
			    } else if (IDataObject.class.isAssignableFrom(propertyClass)) {
			            newPropertyValue = cloneFilter((IDataObject) propertyValue);
				} else {
			    		newPropertyValue = propertyValue;
				}
				Field field = FieldUtils.getField(outputFilter.getClass(), propertyName, true);
				field.set(outputFilter, newPropertyValue);
			} catch (Exception e) {
				continue;
			}
		}
		return outputFilter;
	}
	
	private static String stringFilter(String str) {
		str = str.replace("%", "");
		str = str.trim();
		if(str.charAt(str.length() - 1) == '-') { 
			str = str.substring(0, str.length() - 1); 
		} else { 
			str += "*";
		} 
		str = str.replace("*", "%");
		str = "%" + str;
		return str;
	}
	
}
