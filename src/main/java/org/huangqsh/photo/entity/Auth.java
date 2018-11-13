package org.huangqsh.photo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户角色管理
 * @author huangqsh
 * @date 2018年10月25日
 */
@Entity
@Table(name="tb_auth")
public class Auth extends BaseEntity {
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User userId;
	
	@ManyToOne()
	@JoinColumn(name="role_id")
	private Role roleId;
}
