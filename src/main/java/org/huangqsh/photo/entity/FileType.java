package org.huangqsh.photo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Embeddable
@Data
@Table(name="file_type")
@Entity
public class FileType {
	
	@Id
	@Column(name="id", nullable = false, length = 36, updatable = false)
	private String id;
	@Column(name="type_name")
	private String typeName;

}
