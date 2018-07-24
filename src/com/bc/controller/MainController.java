package com.bc.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	
	//홈
	@RequestMapping("/main.bc")
	public String main() {
		System.out.println("Main In");
		return "main";
	}
	
//	//과목보기
//	@RequestMapping("/codemain.bc")
//	public ModelAndView codelist() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("main");
//		mv.addObject("centerpage","code/codemain");
//		return mv;
//	}
	
	//qna페이지
	@RequestMapping("/qna.bc")
	public ModelAndView qna() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","qna/qmain");
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
				//null일때 처리해주면됨
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
	//홈
	@RequestMapping("/email.bc")
	public String email() {
		System.out.println("email In");
		return "user/email";
	}
	//loginimpl
	@RequestMapping("/emailimpl.bc")
	public ModelAndView emailimpl(HttpServletRequest request, ModelMap mo) throws AddressException, MessagingException{
		String name	 = request.getParameter("names");
		String email = request.getParameter("email");
		ModelAndView mv = new ModelAndView();
		UsersVO user = null;
		UsersVO user2 = new UsersVO();
		user2.setName(name);
		user2.setEmail(email);
		
		System.out.println("user 2:" + user2);
		// 네이버일 경우 smtp.naver.com 을 입력합니다. 
		// Google일 경우 smtp.gmail.com 을 입력합니다. 
		String host = "smtp.naver.com";
		
		final String username = "hny4813"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. 
		final String password = "RLA20150205"; //네이버 이메일 비밀번호를 입력해주세요.
		int port=587; //포트번호

		
		
		try {
			user = uservice.getSearch(user2);
			System.out.println("name: " + name);
			System.out.println("email: " + email );
			System.out.println("user:"+  user);
			if(user == null || !(user.getEmail().equals(email))) {
				//null일때 처리해주면됨
				mv.setViewName("main");
				mv.addObject("centerpage","user/email");
				mv.addObject("resultt", "asdf");
				
				return mv; 
			}
			else if(user != null && user.getEmail().equals(email))
			{
				// 메일 내용 
				String recipient = email; 
				//받는 사람의 메일주소를 입력해주세요. 
				String subject = "멀티캠퍼스 BLOCAST"+user.getId()+"님 안녕하세요. id와 password 전달해드립니다."; 
				//메일 제목 입력해주세요. 
				String body = user.getName()+"님의 아이디는 "+ user.getId()+""
						+ "비밀번호는 "+ user.getPwd()+"입니다."; 
				//메일 내용 입력해주세요. 
				Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성

				// SMTP 서버 정보 설정 
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", port); 
				
				//Session 생성 
				Session session = Session.getDefaultInstance(
						props, new javax.mail.Authenticator() { 
							String un=username; 
							String pw=password; 
							protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
								
								return new javax.mail.PasswordAuthentication(un, pw); 
								} 
							}); 
				session.setDebug(true); //for debug 
				Message mimeMessage = new MimeMessage(session); 
				//MimeMessage 생성
				mimeMessage.setFrom(new InternetAddress("hny4813@naver.com")); 
				//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요. 
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 
				//.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 
				mimeMessage.setSubject(MimeUtility.encodeText(subject,"EUC-KR", "B")); 
				//제목셋팅
				mimeMessage.setText(body); 
				//내용셋팅 
				Transport.send(mimeMessage); 
				//javax.mail.Transport.send() 이용

				
				
				mv.setViewName("main");
				mv.addObject("centerpage","user/email");
				mv.addObject("resultt", "asdd");
				
				return mv;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
