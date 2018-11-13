package org.huangqsh.photo.controller;

import javax.servlet.http.HttpServletRequest;

import org.huangqsh.photo.constant.WebConstants;
import org.huangqsh.photo.entity.User;
import org.huangqsh.photo.entity.param.ReturnModel;
import org.huangqsh.photo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 登陆
	 * @param code
	 * @return
	 */
	@RequestMapping("/localLogin")
	public ReturnModel<User> localLogin(String code,HttpServletRequest request) {
		User user = userService.getUserInfo(code);
		String sessionId = request.getSession().getId();
		if(user.getId() != null) {
			request.getSession().setAttribute(WebConstants.LOGIN_USER, user);
		}
		
		return new ReturnModel<User>(WebConstants.SUCCESS_CODE, sessionId,user);
	}
	
	/**
	 * 注册
	 * @param code
	 * @return
	 */
	@RequestMapping("/registry")
	public ReturnModel<Object> registry(@RequestBody User user,HttpServletRequest request) {
		userService.saveUser(user);
		request.getSession().setAttribute(WebConstants.LOGIN_USER, user);
		return new ReturnModel<Object>(WebConstants.SUCCESS_CODE, "成功注册到本地系统",null);
	}
}
