package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;

public class DtoTest extends MyAbstract {
	
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	@Test
	public void test() throws Exception{
		
	 BoardDTO boardDTO = noticeDAOImpl.boardView(523);
	 assertNotNull(boardDTO);
	}

}
