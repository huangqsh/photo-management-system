package top.huangqsh.business.system.user.service.impl;

import top.huangqsh.business.system.user.dao.UserDao;
import top.huangqsh.business.system.user.entity.User;
import top.huangqsh.core.enums.ResultEnum;
import top.huangqsh.core.exception.GlobalException;
import top.huangqsh.business.system.user.service.UserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author situliang
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SqlSessionTemplate session;

    @Autowired
    private RedisTemplate redisCacheTemplate;

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(String userId) {

        try {
            //User user = userDao.selectByPrimaryKey(id);
            User user = session.selectOne("com.zzk.ssmdemo.dao.UserMapper.select_by_id",userId);
            /*User user = (User) redisCacheTemplate.opsForValue().get(PREFIX + "_" + id);
            if (user == null) {
                user = userDao.selectByPrimaryKey(id);
                redisCacheTemplate.opsForValue().set(PREFIX + "_" + id, user);
            }*/
            return user;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new GlobalException(ResultEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertUser(User user) {
        try {
            Integer effectNum = userDao.insertSelective(user);
            logger.info("insert user id is:" + user.getUserId());
            return effectNum;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new GlobalException(ResultEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user) {
//        try {
//            Integer effectNum = userDao.updateUserById(user);
//            if (effectNum > 0) {
//                redisCacheTemplate.delete(PREFIX + "_" + user.getUserId());
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw new UserException(ResultEnum.UNKNOWN_ERROR);
//        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Integer id) {
//        try {
//            Integer effectNum = userDao.deleteUserById(id);
//            if (effectNum > 0) {
//                redisCacheTemplate.delete(PREFIX + "_" + id);
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            throw new UserException(ResultEnum.UNKNOWN_ERROR);
//        }
    }


}
