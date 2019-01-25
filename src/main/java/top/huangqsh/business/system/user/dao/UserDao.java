package top.huangqsh.business.system.user.dao;

import top.huangqsh.core.base.BaseMapper;
import top.huangqsh.business.system.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author situliang
 */
@Repository("userDao")
public interface UserDao extends BaseMapper<User> {

//
//    /**
//     * 根据主键查询用户信息
//     *
//     * @param id 主键ID
//     * @return 用户对象
//     */
//    User selectByPrimaryKey(Integer id);
//
//    /**
//     * 新增一个用户
//     *
//     * @param user 用户
//     * @return 对象主键值
//     */
//    Integer insertSelective(User user);
//
//    /**
//     * 更新一个用户
//     *
//     * @param user 更新的用户，用户ID必须有值
//     * @return 影响行数
//     */
//    int updateUserById(User user);
//
//    /**
//     * 根据ID删除用户
//     *
//     * @param userId 删除用户ID
//     * @return 影响行数
//     */
//    int deleteUserById(Integer userId);

}
