package com.gh.exception;

public class DMLException extends Exception{
	public DMLException(){
		this("DB연결시 문제가 생겼습니다. 다시 시도해주세요. ");
	}
	public DMLException(String message){
		super(message);
	}
}
