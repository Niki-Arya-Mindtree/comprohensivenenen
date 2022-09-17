package com.doctor.main.exception;

import java.util.Date;

public class ExceptionModel {

	
	private Date TimeStamp;
	private String Msg;

	
	public ExceptionModel(String msg) {
		TimeStamp = new Date();
		Msg = msg;
	}


	public ExceptionModel(String msg, String description) {
		// TODO Auto-generated constructor stub
		TimeStamp = new Date();
		Msg = msg;
	}


	public Date getTimeStamp() {
		return TimeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}


	public String getMsg() {
		return Msg;
	}


	public void setMsg(String msg) {
		Msg = msg;
	}
	
//	public EmptyData getEmpty(String msg) 
//	{
//		TimeStamp = new Date();
//		Msg = msg;
//	}
	
	
}
