package com.bc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bc.frame.Service;
import com.bc.frame.UService;
import com.bc.vo.UsersVO;

@Controller
public class MainController {

	@Resource(name="uservice")
	Service<UsersVO, String> service;
	@Resource(name="uservice")
	UService<UsersVO, String> uservice;

	
	//Ȩ
	@RequestMapping("/main.bc")
	public String main() {
		System.out.println("Main In");
		return "main";
	}
	
	//���񺸱�
	@RequestMapping("/codemain.bc")
	public ModelAndView codelist() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/codemain");
		return mv;
	}
	
	//qna������
	@RequestMapping("/qna.bc")
	public ModelAndView qna() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","qna/qmain");
		return mv;
	}
	//about������
	@RequestMapping("/about.bc")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","about");
		return mv;
	}
	
	//login������
		@RequestMapping("/login.bc")
		public ModelAndView login() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("main");
			mv.addObject("centerpage","user/login");
			return mv;
		}
		
	
		//loginimpl
		@RequestMapping("/loginimpl.bc")
		public ModelAndView loginimpl(HttpServletRequest request) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			HttpSession session = request.getSession();
			ModelAndView mv = new ModelAndView();
			ModelAndView mv2 = new ModelAndView();
			UsersVO user = null;
			
			try {
				user = service.get(id);
				if(user == null || !(user.getPwd().equals(pwd))) {
					//null�϶� ó�����ָ��
					mv.setViewName("main");
					mv.addObject("centerpage","user/login");
					mv.addObject("resultt", "asdf");
					
					return mv;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mv2.setViewName("main");
			mv2.addObject("centerpage","center");
			session.setAttribute("loginid", id);
			return mv2;
		}
	
	//�α׾ƿ�
	@RequestMapping("/logout.bc")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "center");
		return mv;
	}
	
	//ȸ������ ������
	@RequestMapping("/register.bc")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","user/register");
		return mv;
	}
	
	//registerimpl
		@RequestMapping("/registerimpl.bc")
		public ModelAndView registerimpl(HttpServletRequest request, UsersVO user) {

			ModelAndView mv = new ModelAndView();
			HttpSession session = request.getSession();
			mv.setViewName("main");
			try {
				service.register(user);	
				mv.addObject("centerpage", "center");
				session.setAttribute("loginid", user.getId());
				return mv;
			} catch (Exception e) {
				mv.addObject("centerpage", "user/register");
				mv.addObject("resultt", "asdd");
				e.printStackTrace();
				return mv;
			}
		}
	
}
