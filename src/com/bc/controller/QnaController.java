package com.bc.controller;


import static org.hamcrest.CoreMatchers.nullValue;

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
	
	@Resource(name="qservice")
	Service<QuestionVO, String> qservice2;
	
	@Resource(name="tservice")
	TService<TagVO, String> tservice;
	
	@Resource(name="tservice")
	Service<TagVO, String> service;
	
	@Resource(name="tlservice")
	TlService<TagListVO, String> tlservice;
	
	@Resource(name="tlservice")
	Service<TagListVO, String> tlservice2;
	
	//�۾��� 
	@RequestMapping("/write.bc")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","qna/write");
		return mv;
	}
		
	//�۾��� ����
	@RequestMapping("/writeimpl.bc")
	public ModelAndView writeimpl(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.setViewName("main");
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		ArrayList<String> list1 = new ArrayList<>();
		
		QuestionVO q = new QuestionVO();
		q.setTitle(title);
		q.setContents(content);
		q.setClass_id("1");
		q.setAuthor(session.getAttribute("loginid").toString());
		//System.out.println("session.getAttribute(\"loginid\"):" + session.getAttribute("loginid"));

		//question ���̺� title�� content �Է�
		//class_id �޾ƿͼ� �־�� ��. regdate�� �ڵ����� �־����� thumbsup�� default 0�̹Ƿ� ����
		//author�� �ش� ������� ���̵� ���� �� 
		//���Է� �Ǿ����� �����Ǵ� question_id�� �����ͼ�  taglist���̺� �־���� 
		try {
			qservice2.register(q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//question ���̺��� �ֱ� �����͸� ������.
		QuestionVO q1 = null;
		try {
			q1 = qservice.getRecent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("tag: " + tag);
		
		String [] sp = tag.split(",");
		
		for(String t : sp) {
			list1.add(t);
		}
		
		ArrayList<TagVO> tali1 = new ArrayList<TagVO>();
		
		for(int i =0; i<list1.size(); i++)
		{
//			System.out.println("list:" + i + ":" + list1.get(i).replaceAll(" ", "").replaceAll("#", ""));

			
			try {
				service.register(list1.get(i).replaceAll(" ", "").replaceAll("#", ""));
				tali1.add(tservice.getRecent());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		TagListVO tl1 = new TagListVO();
		
		//qusetion_id �� �ش�Ǵ� tag_id�� �ִ� �κ�
		for(int i = 0; i<tali1.size(); i++)
		{
			tl1.setQuestion_id(q1.getId());
			tl1.setTag_id(tali1.get(i).getId());
			try {
				tlservice2.register(tl1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		mv.addObject("centerpage","qna/qmain");
		return mv;
	}
	
	/*
	 * //�۾��� ����
	@RequestMapping("/writeimpl.bc")
	public ModelAndView writeimpl() {
		ModelAndView mv = new ModelAndView();
		return "qna/write";
	}
	 * 
	 */
}
