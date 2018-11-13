package org.huangqsh.photo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_album")
public class Album extends BaseEntity {
	//是否公开
	@Column(name="is_public")
	private Integer isPublic;
	//影集名
	@Column(name="name_")
	private String name;
	//作者
	@Column(name="author_name")
	private String authorName;
	//图片地址
	@Column(name="poster")
	private String poster;
	//关联用户
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
}
