package com.doctor.main.exception;

import java.util.Date;



public class EmptyData extends RuntimeException{
	
//	public EmptyData(String msg) 
//	{super();}
//
//	private Date TimeStamp;
	private String Msg;

	
	public EmptyData(String msg) {
		//TimeStamp = new Date();
		Msg = msg;
	}


//	public Date getTimeStamp() {
//		return TimeStamp;
//	}
//
//
//	public void setTimeStamp(Date timeStamp) {
//		TimeStamp = timeStamp;
//	}


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
