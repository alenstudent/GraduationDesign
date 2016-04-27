package com.aaron.framework.utils;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanUtil<T> implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static<T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}
	@SuppressWarnings("unchecked")
	public static<T> T getBean(String beanId) {
		return (T) context.getBean(beanId);
	}
}
