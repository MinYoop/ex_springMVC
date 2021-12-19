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
	public List<CustomerDto> selectAll() {

		List<CustomerDto> res = null;

		try {
//			System.out.println("11");
			res = sqlSession.selectList(namespace + "selectList");
//			System.out.println("22");
		} catch (Exception e) {
			System.out.println("selectList 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public CustomerDto selectOne(String id) {
		CustomerDto dto = null;

		try {
			dto = sqlSession.selectOne(namespace + "selectOne", id);
		} catch (Exception e) {
			System.out.println("selectOne 에러");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(CustomerDto dto) {
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "insert",dto);
//			System.out.println(res + "///");
		} catch (Exception e) {
			System.out.println("insert 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(CustomerDto dto) {
		int res = 0;

		try {
//			System.out.println("111.");
			res = sqlSession.update(namespace + "update", dto);
//			System.out.println("222."+res + "///");
		} catch (Exception e) {
			System.out.println("update 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(String id) {
		int res = 0;

		try {
			res = sqlSession.delete(namespace + "delete", id);
//			System.out.println(res + "///");
		} catch (Exception e) {
			System.out.println("delete 에러");
			e.printStackTrace();
		}
		return res;
	}

}
