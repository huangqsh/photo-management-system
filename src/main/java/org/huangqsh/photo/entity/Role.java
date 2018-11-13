package org.huangqsh.photo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="tb_role")
@Entity
public class Role extends BaseEntity {
	@Column(name="role_name")
	private String roleName;
	
	@OneToMany(fetch = FetchType.LAZY,targetEntity = Auth.class,orphanRemoval = true)
	@JoinColumn(name="role_id",insertable=false,updatable=false)
	private List<Auth> auth;

}
