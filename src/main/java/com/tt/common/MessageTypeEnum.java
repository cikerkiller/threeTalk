package com.tt.common;

/**
 * 
 * @author ciker
 * @desc  消息类型枚举
 *
 */
public enum MessageTypeEnum {
	
	message(1,"会话"),
	
	notice(0,"消息");
	
	private int code;
	
	private String desc;
	
	private MessageTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
