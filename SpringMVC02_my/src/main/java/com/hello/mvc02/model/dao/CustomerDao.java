package com.hello.mvc02.model.dao;

import java.util.List;

import com.hello.mvc02.dto.CustomerDto;

public interface CustomerDao {
	
	String namespace = "customer.";
	
	public List<CustomerDto> selectList();
	public CustomerDto selectOne(String id);
	public int insert(CustomerDto dto);
	public int update(CustomerDto dto);
	public int delete(String id);

}
