package org.huangqsh.photo.init.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.huangqsh.photo.service.Impl.AlbumServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebListener
public class ServletContextStartListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext  context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		log.info("servletContext 初始化start");
		log.info(context.getBean(AlbumServiceImpl.class));
		log.info("servletContext 初始化end");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("servletContext 销毁");
	}

}
