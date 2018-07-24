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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bc.frame.CService;
import com.bc.frame.QService;
import com.bc.frame.Service;
import com.bc.frame.TService;
import com.bc.frame.TlService;
import com.bc.vo.ClassVO;
import com.bc.vo.QuestionVO;
import com.bc.vo.TagListVO;
import com.bc.vo.TagVO;

@Controller
public class QnaController {

	@Resource(name="qservice")
	QService<QuestionVO, String> qservice;
	
	@Resource(name="qservice")
	Service<QuestionVO, String> qservice2;
	
	@Resource(name="cservice")
	Service<QuestionVO, String> cservice;
	
	@Resource(name="cservice")
	CService<QuestionVO, String> cservice2;
	
	@Resource(name="tservice")
	TService<TagVO, String> tservice;
	
	@Resource(name="tservice")
	Service<TagVO, String> service;
	
	@Resource(name="tlservice")
	TlService<TagListVO, String> tlservice;
	
	@Resource(name="tlservice")
	Service<TagListVO, String> tlservice2;
	
	//글쓰기 
	@RequestMapping("/write.bc")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","qna/write");
		try {
			System.out.println("cservice.get() :" + cservice.get());
			mv.addObject("classInfo",cservice.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//글쓰고 나서
	@RequestMapping("/writeimpl.bc")
	public ModelAndView writeimpl(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.setViewName("main");
		String classI=request.getParameter("classI");	
		ClassVO cvo =null;
		try {
		    cvo = cservice2.getname(classI);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		ArrayList<String> list1 = new ArrayList<>();
		System.out.println("classI:" + classI);
		
		QuestionVO q = new QuestionVO();
		q.setTitle(title);
		q.setContents(content);
		q.setClass_id(cvo.getId());
		q.setAuthor(session.getAttribute("loginid").toString());
		//System.out.println("session.getAttribute(\"loginid\"):" + session.getAttribute("loginid"));

		//question 테이블에 title과 content 입력
		//class_id 받아와서 넣어야 함. regdate는 자동으로 넣어지고 thumbsup은 default 0이므로 무시
		//author은 해당 사용자의 아이디가 들어가야 함 
		//다입력 되었을때 생성되는 question_id를 가져와서  taglist테이블에 넣어야함 
		try {
			qservice2.register(q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//question 테이블에서 최근 데이터를 가져옴.
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
		
		a:for(int i =0; i<list1.size(); i++)
		{
//			System.out.println("list:" + i + ":" + list1.get(i).replaceAll(" ", "").replaceAll("#", ""));

			
			try {
				ArrayList<TagVO> tags = service.get();
				boolean flag = false;
				String input = list1.get(i).replaceAll(" ", "").replaceAll("#", "");
				for(int j =0; j<tags.size(); j++)
				{
					TagVO tag2 = tags.get(j);
					
					//같은 name의 tag가 있으면 flag가 true
					if(tag2.getName().equals(input))
					{
						flag=true;
					}
					
					if(flag==true) {
						continue a;
					}
				}
				
				service.register(input);
				System.out.println("input :"+input+" is inserted!" );
				tali1.add(tservice.getRecent());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		TagListVO tl1 = new TagListVO();
		
		//qusetion_id 에 해당되는 tag_id를 넣는 부분
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
	@ResponseBody
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
	
	// get tag list where question_id is given
	@RequestMapping("/tlist.bc")
	@ResponseBody
	public void taglist(@RequestParam(value = "qid") String qid, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		ArrayList<TagListVO> tlist = null;

		tlist = tlservice.getTid(qid);
		for (TagListVO t : tlist) {
			ja.add(service.get(t.getTag_id()).getName());
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