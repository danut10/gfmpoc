package ro.cegeka.gfmpoc.app.core.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import ro.cegeka.gfmpoc.app.core.intf.IDao;
import ro.cegeka.gfmpoc.app.core.intf.IDaoFactory;

@Service
public class DaoFactorySpring implements IDaoFactory, ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public IDao getInstance(String entityCode) {
		String beanName = "dao" + StringUtils.capitalize(entityCode);
		IDao dao = (IDao) applicationContext.getBean(beanName);
		return dao;
	}
	
}
