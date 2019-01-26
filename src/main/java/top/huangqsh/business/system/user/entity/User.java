package top.huangqsh.business.system.user.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Id;
import java.io.Serializable;

/**
* @Description:    用户
* @Author:         huangqsh
* @CreateDate:     2019/1/26 14:48
* @UpdateRemark:
* @Version:        1.0
*/
public class User extends BaseEntity {

    private String username;
    private String password;
    private String nickName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
