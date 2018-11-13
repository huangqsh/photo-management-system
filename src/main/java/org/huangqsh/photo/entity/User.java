package org.huangqsh.photo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_user",indexes= {
		@Index(name = "open_id_idx", columnList = "open_id"),
		@Index(name = "id_idx", columnList = "id"),
		@Index(name = "nick_name_idx", columnList = "nick_name")
})
public class User extends BaseEntity {
	@Column(name="is_registry", nullable = false)
	private Integer isRegistry = 0;
	@Column(name="open_id", nullable = false, updatable = false)
	private String openid;
	@Column(name="nick_name")
	private String nickName;
	@Column(name="avatar_url")
	private String avatarUrl;
	@Column(name="gender")
	private Integer gender;
	@Column(name="city")
	private String city;
	@Column(name="province")
	private String province;
	@Column(name="country")
	private String country;
	@Column(name="describe_")
	private String describe;
	@OneToMany(fetch = FetchType.LAZY,targetEntity = Auth.class,orphanRemoval = true)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	private List<Auth> auth;
	
	public void init() {
		super.init();
	}
}
