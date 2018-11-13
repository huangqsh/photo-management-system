package org.huangqsh.photo.entity.dto;

import java.util.Date;

import org.huangqsh.photo.entity.FileType;

public class PhotoDto {
	private String id;
	private Date createDate;
	private String url;
	private String authorName;
    private String describe;
	private String fileName;
	private Integer size;
	private FileType fileType;
	private Integer isQuality;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public FileType getFileType() {
		return fileType;
	}
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	public Integer getIsQuality() {
		return isQuality;
	}
	public void setIsQuality(Integer isQuality) {
		this.isQuality = isQuality;
	}
	
}
