package com.ezhao.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;

/*
 * msg_idint(11) NOT NULL
from_idint(11) NULL
to_idint(11) NULL
msg_contentvarchar(500) NULL
msg_datedatetime NULL
 */
public class Message {

	private Integer msgId;
	
	private Integer fromId;
	
	private Integer toId;
	
	private String msgContent;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date msgDate;


	public Message() {
		super();
	}

	public Message(Integer fromId, Integer toId, String msgContent, Date msgDate) {
		super();
		this.fromId = fromId;
		this.toId = toId;
		this.msgContent = msgContent;
		this.msgDate = msgDate;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	
	public String toJson() {
		
		return JSON.toJSONString(this);
	}
	
	@Override
	public String toString() {
		return "Message [fromId=" + fromId + ", toId=" + toId + ", msgContent=" + msgContent + ", msgDate=" + msgDate
				+ "]";
	}
}
