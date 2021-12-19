package com.hello.mvc02.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.mvc02.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CustomerDto> selectList() {
		List<CustomerDto> res = null;
		
		try {
			System.out.println("111");
			res = sqlSession.selectList(namespace+"selectList");
			System.out.println("222");
			
		} catch (Exception e) {
			System.out.println("selectList 에러");
			e.printStackTrace();
		}		
		return res;
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
