package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloBiz {
	
	// TODO : 06.Dao(@Repository) 호출
	@Autowired	
	private HelloDao dao;
	
	
	
	public String getHello() {	
		// TODO : 08.Biz에서 리턴
		return dao.getHello() + "Spring";
	}
}
