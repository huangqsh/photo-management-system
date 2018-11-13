package org.huangqsh.photo.dao;

import org.huangqsh.photo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IuserDao  extends JpaRepository<User,String> {
	public User findByOpenid(String openId);
}
