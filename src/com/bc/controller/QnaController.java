package com.bc.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	// get question list
	@RequestMapping("/qnalist.bc")
	public void qnalist(@RequestParam(value = "classid") String cid, HttpServletResponse response)
			throws Exception {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		ArrayList<QuestionVO> qlist = null;
		
		qlist = qservice.getClassid(cid);

		for (QuestionVO q : qlist) {
			JSONObject jo = new JSONObject();
			jo.put("id", q.getId());
			jo.put("title", q.getTitle());
			jo.put("contents", q.getContents());
			jo.put("author", q.getAuthor());
			jo.put("regdate", q.getRegdate().toString());
			ja.add(jo);
			
		}
		
		out.println(ja.toJSONString());

		out.close();
	}
	
	@RequestMapping("/qsearch.bc")
	public ModelAndView qsearch(HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		ArrayList<QuestionVO> qlist = null;
		
		try {
			qlist = qservice.getNameCont(keyword);
			System.out.println(qlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","qna/searchlist");
		mv.addObject("qlist",qlist);
		return mv;
	}
}