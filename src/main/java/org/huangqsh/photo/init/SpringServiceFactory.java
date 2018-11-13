package org.huangqsh.photo.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringServiceFactory implements ApplicationContextAware {
	
	private static volatile SpringServiceFactory factory;

	private ApplicationContext ctx;
	
	
	public static SpringServiceFactory get(){
		return factory;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getService(Class clazz) {
		return (T) get().ctx.getBean(clazz.getName());
	}

	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> clazz, String name) {
		return (T) get().ctx.getBean(name);
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		factory = this;
		this.ctx = ctx;
	}
	
	public ApplicationContext getApplicationContext(){
		return get().ctx;
	}

}
