package com.hello.mvc02.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc02.dto.CustomerDto;
import com.hello.mvc02.model.dao.CustomerDao;

@Service
public class CustomerBizImpl implements CustomerBIz {

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public List<CustomerDto> selectAll() {
		return customerDao.selectAll();
	}

	@Override
	public CustomerDto selectOne(String id) {
		return customerDao.selectOne(id);
	}

	@Override
	public int insert(CustomerDto dto) {
		return customerDao.insert(dto);
	}

	@Override
	public int update(CustomerDto dto) {
		return customerDao.update(dto);
	}

	@Override
	public int delete(String id) {
		return customerDao.delete(id);
	}

}
