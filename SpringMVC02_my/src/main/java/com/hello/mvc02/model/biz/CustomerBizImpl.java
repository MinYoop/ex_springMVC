package com.hello.mvc02.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc02.dto.CustomerDto;
import com.hello.mvc02.model.dao.CustomerDao;

@Service
public class CustomerBizImpl implements CustomerBiz {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerDto> selectList() {
		// TODO Auto-generated method stub
		return customerDao.selectList();
	}

	@Override
	public CustomerDto selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CustomerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CustomerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
