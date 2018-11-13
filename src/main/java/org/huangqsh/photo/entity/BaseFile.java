package org.huangqsh.photo.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseFile extends BaseEntity {
	@Column(name="file_name", nullable = false, updatable = false)
	private String fileName;
	@Column(name="size", nullable = false)
	private Integer size;
	@Embedded
	private FileType fileType;
	
	@Column(name="is_quality")
	private Integer isQuality;
}
