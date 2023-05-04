package com.smart.contact.manager.helper;

public class MessageHelper {
	private String type;
	private String content;
	public MessageHelper(String type, String content) {
		super();
		this.type = type;
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MessageHelper [type=" + type + ", content=" + content + "]";
	}
	


}
