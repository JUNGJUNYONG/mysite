package com.douzone.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.GuestBookVo;

@Repository
public class GuestBookRepository {
	@Autowired
	private SqlSession sqlSession;

	public List<GuestBookVo> findAll() {
		
	return sqlSession.selectList("guestbook.findall");
	}

	public boolean delete(GuestBookVo vo) {
		int count = sqlSession.delete("guestbook.delete", vo);
		return count == 1;
	}

	public boolean insert(GuestBookVo vo) {
		int count = sqlSession.insert("guestbook.insert", vo);
		return count == 1;
	}

}
