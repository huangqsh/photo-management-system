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
@Table(name="tb_photo")
public class Photo extends BaseFile {
	
	@Column(name="url")
	private String url;
	//冗余字段
	@Column(name="author_name")
	private String authorName;
	@Column(name="describe_")
    private String describe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="album_id")
    private Album album;
}
