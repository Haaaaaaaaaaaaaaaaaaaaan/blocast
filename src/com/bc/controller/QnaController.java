package com.bc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bc.frame.Service;
import com.bc.vo.QuestionVO;
import com.bc.vo.TagListVO;
import com.bc.vo.TagVO;

@Controller
public class QnaController {

	@Resource(name="qservice")
	Service<QuestionVO, String> qservice;
	
	@Resource(name="tservice")
	Service<TagVO, String> tservice;
	
	@Resource(name="tlservice")
	Service<TagListVO, String> tlservice;
	
	//글쓰기 
	@RequestMapping("/write.bc")
	public String write() {
		return "qna/write";
	}
		
	//글쓰고 나서
	@RequestMapping("/writeimpl.bc")
	public String writeimpl(HttpServletRequest request) {
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		
		//tservice.register(title);
		
		return "qna/write";
	}
	
	/*
	 * //글쓰고 나서
	@RequestMapping("/writeimpl.bc")
	public ModelAndView writeimpl() {
		ModelAndView mv = new ModelAndView();
		return "qna/write";
	}
	 * 
	 */
}
