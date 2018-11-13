package org.huangqsh.photo.entity.dto;

import lombok.Data;

@Data
public class AlbumDto {
	private String id;
	
	private String createDate;
	
	private Integer isPublic;
	//影集名
	private String name;
	//作者
	private String authorName;
	//图片地址
	private String poster;
}
