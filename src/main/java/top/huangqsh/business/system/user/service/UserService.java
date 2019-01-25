package top.huangqsh.business.system.user.service;

import top.huangqsh.business.system.user.entity.User;

/**
 * @author situliang
 */
public interface UserService {

    static final String PREFIX = "user";

    /**
     * 根据用户主键ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    User getUserById(String id);

    /**
     * 新增用户
     *
     * @param user 用户对象
     * @return 0:失败,1:成功
     */
    Integer insertUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户对象
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void deleteUser(Integer id);
}
