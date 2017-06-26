package com.choa.ex6;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
//@RestController  클래스에 모든 메서드가 @ResponseBody 라면 @Controller 말고 레스트 컨트롤러로 ㄱㄱ
@RequestMapping(value="/memo/**")
public class MemoController {
	
	@Inject
	private MemoService memoService;
	
	//list
	@RequestMapping(value="memoList")
	public void memoList(){		
	}
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}")
	@ResponseBody//리턴을 뷰가아닌 데이터를 받은 곳으로 돌가가겠다 (json) 형식으로 가겠다..... jackson Databind API가 있어야됨
	public List<MemoDTO> memoList(@PathVariable("curPage") int curPage,@PathVariable("find")String find, @PathVariable("search") String search)throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		List<MemoDTO> list = memoService.boardList(listInfo);
		return list;	
		
	}
	/*@RequestMapping(value="memoView/{num}")
	@ResponseBody
	public MemoDTO memoView(@PathVariable)*/
	
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model)throws Exception{
		int result = memoService.boardWrite(memoDTO);
		ListInfo listInfo =new ListInfo();
		listInfo.setCurPage(1);
		List<MemoDTO> list = memoService.boardList(listInfo);
		
		return list;
	}

}
