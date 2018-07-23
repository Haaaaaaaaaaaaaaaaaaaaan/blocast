package com.bc.controller;


import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bc.frame.QService;
import com.bc.frame.Service;
import com.bc.frame.TService;
import com.bc.frame.TlService;
import com.bc.vo.QuestionVO;
import com.bc.vo.TagListVO;
import com.bc.vo.TagVO;

@Controller
public class QnaController {

	@Resource(name="qservice")
	QService<QuestionVO, String> qservice;
	
	@Resource(name="tservice")
	TService<TagVO, String> tservice;
	
	@Resource(name="tservice")
	Service<TagVO, String> service;
	
	@Resource(name="tlservice")
	TlService<TagListVO, String> tlservice;
	
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
		ArrayList<String> list1 = new ArrayList<>();
		
		//question 테이블에 title과 content 입력
		
		
		System.out.println("tag: " + tag);
		
		String [] sp = tag.split(",");
		
		for(String t : sp) {
			list1.add(t);
		}
		
		
		for(int i =0; i<list1.size(); i++)
		{
			System.out.println("list:" + i + ":" + list1.get(i).replaceAll(" ", "").replaceAll("#", ""));
		}
		
		
		/*
		try {
			service.register(tag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
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
