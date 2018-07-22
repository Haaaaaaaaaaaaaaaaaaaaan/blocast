package com.bc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	//@Resource(name="uservice")
	//Service<UsersVO, String> uservice;

	//홈
	@RequestMapping("/main.bc")
	public String main() {
		System.out.println("Main In");
		return "main";
	}
	
	//과목보기
	@RequestMapping("/codelist.bc")
	public ModelAndView codelist() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","codelist");
		return mv;
	}
	
	//qna페이지
	@RequestMapping("/qna.bc")
	public ModelAndView qna() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","qna");
		return mv;
	}
	//about페이지
	@RequestMapping("/about.bc")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","about");
		return mv;
	}
	
	//login페이지
	@RequestMapping("/login.bc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","login");
		return mv;
	}
	
	//loginimpl
	@RequestMapping("/loginimpl.bc")
	public ModelAndView loginimpl(HttpServletRequest request) {
		return null;
	}
	
	//로그아웃
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
	
	//회원가입 페이지
	@RequestMapping("/register.bc")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","register");
		return mv;
	}
	
//	//registerimpl
//	@RequestMapping("/registerimpl.bc")
//	public ModelAndView registerimpl(UsersVO user) {
//
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("main");
//		try {
//			uservice.register(user);
//			mv.addObject("centerpage", "registerok");
//		} catch (Exception e) {
//			mv.addObject("centerpage", "registerfail");
//			e.printStackTrace();
//		}
//
//		return mv;
//	}
	
}
