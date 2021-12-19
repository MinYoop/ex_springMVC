package com.hello.mvc02.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// TODO Auto-generated method stub
		List<CustomerDto> res = null;
		try {
			res = sqlSession.selectList(namespace + "selectList");

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
	
	@Override
	public CustomerDto login(String id, String password) {
		
		CustomerDto dto = null;
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		
		try {
			dto = sqlSession.selectOne(namespace + "login", map); 
		}catch(Exception e) {
			System.out.println("selectOne 에러");
			e.printStackTrace();
		}
		
		return dto;
	}

}
