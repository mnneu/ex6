package com.choa.aspect;

import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;

public class TestInterceptor extends HandlerInterceptorAdapter{

	//컨트롤러를 빠저나온 후 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("controller 나온 후");
		Map<String, Object> map =  modelAndView.getModel();
		Object list = map.get("list");
		Object listInfo = map.get("listInfo");
		Object board = map.get("board");
		System.out.println(((List<BoardDTO>) list).get(0).getTitle());
		System.out.println(((ListInfo)listInfo).getCurBlock());
		System.out.println(board);
		
		
		super.postHandle(request, response, handler, modelAndView);
	}

	
	
	//controller를 가기전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("controller 가기 전");
		
		return true;
	}
	
	

}
