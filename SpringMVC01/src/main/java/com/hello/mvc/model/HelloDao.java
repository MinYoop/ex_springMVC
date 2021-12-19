package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	
	public String getHello() {
		
		//TODO : 07.Dao에서 리턴
		return "hello, ";
	}

}
