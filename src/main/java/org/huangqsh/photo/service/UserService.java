package org.huangqsh.photo.service;

import org.huangqsh.photo.entity.User;

public interface UserService {

	/**
	 * 获得用户信息
	 * @param code
	 * @return
	 */
	public User getUserInfo(String code);
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user);
}
