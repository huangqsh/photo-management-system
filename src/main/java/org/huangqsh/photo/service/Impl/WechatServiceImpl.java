package org.huangqsh.photo.service.Impl;

import java.io.UnsupportedEncodingException;

import org.huangqsh.photo.dao.IuserDao;
import org.huangqsh.photo.entity.User;
import org.huangqsh.photo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class WechatServiceImpl implements UserService {
	//获得用户信息
	@Value("${WeChat.login}")
	private String wechar_login;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private IuserDao userDao;

	@Override
	public User getUserInfo(String code) {
		log.info(String.format("get user info [code = %s]", code));
		String url = String.format(wechar_login,code);
		String resultStr = restTemplate.getForObject(url, String.class);
        try {
			resultStr = new String(resultStr.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(String.format("获取用户信息错误  %s", e.getMessage()));
		}
        JSONObject result = JSONObject.parseObject(resultStr);
        if (result.getString("openid") != null) {
        	//通过openID查询用户
        	User user = userDao.findByOpenid(result.getString("openid"));
        	if(user == null) {
        		user = new User();
        		user.setOpenid(result.getString("openid"));
        	}
        	return user;
        }
        return null;
	}

	@Override
	public void saveUser(User user) {
		user.init();
		user.setIsRegistry(1);
		userDao.save(user);
	}
	
	
}
