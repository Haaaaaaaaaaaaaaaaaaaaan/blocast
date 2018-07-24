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

	
	//Ȩ
	@RequestMapping("/main.bc")
	public String main() {
		System.out.println("Main In");
		return "main";
	}
	
//	//���񺸱�
//	@RequestMapping("/codemain.bc")
//	public ModelAndView codelist() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("main");
//		mv.addObject("centerpage","code/codemain");
//		return mv;
//	}
	
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
	//Ȩ
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
		// ���̹��� ��� smtp.naver.com �� �Է��մϴ�. 
		// Google�� ��� smtp.gmail.com �� �Է��մϴ�. 
		String host = "smtp.naver.com";
		
		final String username = "hny4813"; //���̹� ���̵� �Է����ּ���. @nave.com�� �Է����� ���ñ���. 
		final String password = "RLA20150205"; //���̹� �̸��� ��й�ȣ�� �Է����ּ���.
		int port=587; //��Ʈ��ȣ

		
		
		try {
			user = uservice.getSearch(user2);
			System.out.println("name: " + name);
			System.out.println("email: " + email );
			System.out.println("user:"+  user);
			if(user == null || !(user.getEmail().equals(email))) {
				//null�϶� ó�����ָ��
				mv.setViewName("main");
				mv.addObject("centerpage","user/email");
				mv.addObject("resultt", "asdf");
				
				return mv; 
			}
			else if(user != null && user.getEmail().equals(email))
			{
				// ���� ���� 
				String recipient = email; 
				//�޴� ����� �����ּҸ� �Է����ּ���. 
				String subject = "��Ƽķ�۽� BLOCAST"+user.getId()+"�� �ȳ��ϼ���. id�� password �����ص帳�ϴ�."; 
				//���� ���� �Է����ּ���. 
				String body = user.getName()+"���� ���̵�� "+ user.getId()+""
						+ "��й�ȣ�� "+ user.getPwd()+"�Դϴ�."; 
				//���� ���� �Է����ּ���. 
				Properties props = System.getProperties(); // ������ ��� ���� ��ü ����

				// SMTP ���� ���� ���� 
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", port); 
				
				//Session ���� 
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
				//MimeMessage ����
				mimeMessage.setFrom(new InternetAddress("hny4813@naver.com")); 
				//�߽��� ���� , ������ ����� �̸����ּҸ� �ѹ� �� �Է��մϴ�. �̶��� �̸��� Ǯ �ּҸ� �� �ۼ����ּ���. 
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //�����ڼ��� 
				//.TO �ܿ� .CC(����) .BCC(��������) �� ���� 
				mimeMessage.setSubject(MimeUtility.encodeText(subject,"EUC-KR", "B")); 
				//�������
				mimeMessage.setText(body); 
				//������� 
				Transport.send(mimeMessage); 
				//javax.mail.Transport.send() �̿�

				
				
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
