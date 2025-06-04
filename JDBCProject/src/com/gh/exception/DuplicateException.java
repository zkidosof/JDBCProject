package com.gh.exception;

public class DuplicateException extends Exception{
	public DuplicateException(){
		this("중복된 데이터입니다.");
	}
	public DuplicateException(String message){
		super(message);
	}
}
