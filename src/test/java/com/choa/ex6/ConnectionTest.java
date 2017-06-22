package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ConnectionTest extends MyAbstract{

	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession);
		
	}

}
