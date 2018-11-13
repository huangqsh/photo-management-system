package org.huangqsh.photo.entity.param;

import lombok.Data;

@Data
public class ReturnModel<T> {
	private String code;
	
	private String message;
	
	private T data;

	public ReturnModel(String code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public ReturnModel() {};
	
	public static ReturnModel<Object> returnSuccess() {
		ReturnModel<Object> success = new ReturnModel<>();
		success.setCode("200");
		success.setMessage("操作成功");
		return success;
	}
}
