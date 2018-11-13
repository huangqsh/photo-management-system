package org.huangqsh.photo.entity;



import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {
	
	@Id
	@Column(name="id", nullable = false, length = 36, updatable = false)
	private String id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date",nullable = false, updatable = false)
	private Date createDate;
	
	public void init() {
		this.id = UUID.randomUUID().toString();
		this.createDate = new Date();
	}
	
}
