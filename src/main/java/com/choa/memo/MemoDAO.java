package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {
	
	@Inject
	private SqlSession sqlSession;	
	private final String NAMESPACE="MemoMapper.";
	
	
	//count
	public int boardCount(ListInfo listInfo) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"count", listInfo);
	}
	
	
	//list
	
	public List<MemoDTO> boardList(ListInfo listInfo) throws Exception{	
		
		return sqlSession.selectList(NAMESPACE+"list",listInfo);	
	}		

	//insert
	public int boardWrite(MemoDTO memoDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
	}	
	//update
	public int boardUpdate(MemoDTO memoDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	
	//delete
	public int boardDelete(int num)throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", num);
	}

}
