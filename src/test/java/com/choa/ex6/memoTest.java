package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;

public class memoTest extends MyAbstract {

	@Inject
	private MemoService memoService;
	@Test
	public void test() throws Exception {

		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setWriter("choa55");
		memoDTO.setContents("choa55");

		
	
		
	}

}
