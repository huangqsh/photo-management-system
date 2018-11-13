package org.huangqsh.photo.init.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.huangqsh.photo.utils.PageParam;
import org.huangqsh.photo.utils.PageThreadlocal;

import com.alibaba.fastjson.JSONObject;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		if(sre.getServletRequest().getParameter("page") != null) {
			String params = sre.getServletRequest().getParameter("page");
			PageParam param = JSONObject.parseObject(params, PageParam.class);
			PageThreadlocal.setThread(param);
		}
		
	}

}
