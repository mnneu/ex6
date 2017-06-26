package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	
	@Inject
	private MemoDAO memoDAO;
	
	
	
	public List<MemoDTO> boardList(ListInfo listInfo)throws Exception{
		int count = memoDAO.boardCount(listInfo);
		listInfo.makePage(count);
		listInfo.setRow();
		return memoDAO.boardList(listInfo);
	}
	public int boardWrite(MemoDTO memoDTO)throws Exception{
		return memoDAO.boardWrite(memoDTO);
	}
	public int boardUpdate(MemoDTO memoDTO)throws Exception{
		return memoDAO.boardUpdate(memoDTO);
	}

	public int boardDelete(int num)throws Exception{
		return memoDAO.boardDelete(num);
	}
}
