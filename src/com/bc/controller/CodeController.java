package com.bc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CodeController {

	//@Resource(name="qservice")
	//QService<QuestionVO, String> qservice;
	
	//@Resource(name="tservice")
	//TService<TagVO, String> tservice;
	
	//@Resource(name="tlservice")
	//TlService<TagListVO, String> tlservice;
	
	
//	public ModelAndView codemain() {
//		ModelAndView mv1 = new ModelAndView();
//		//mv.setViewName("main");
//		//mv.addObject("centerpage","code/codemain");
//		cm();
//		//mv.setViewName("code/codemain");
//		//mv.addObject("codecenter",null);
//		//return mv;
//		return mv1;
//	}
	@RequestMapping("/codemain.bc")
	public ModelAndView codemain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/codemain");
		return mv;
	}
	@RequestMapping("/blockchain.bc")
	public ModelAndView blockchain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/blockchain");
		return mv;
	}
	@RequestMapping("/bigdata.bc")
	public ModelAndView bigdata() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/bigdata");
		return mv;
	}
	@RequestMapping("/iot.bc")
	public ModelAndView iot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/iot");
		return mv;
	}	
	//과목보기
	@RequestMapping("/codelist.bc")
	public ModelAndView codelist() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/codeupload");
		return mv;
	}
	
	@RequestMapping("/codeupload.bc")	
	public ModelAndView codeUpload(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("main");
		//mv.addObject("centerpage", "code/codeupload");
		
		System.out.println("upload in");
		String code = request.getParameter("code");
		String filename = request.getParameter("filename");
		System.out.println(code);
		System.out.println(filename);
		
		StringBuffer sb = new StringBuffer();
		sb.append("C:\\code\\");
		sb.append(filename);
		
        BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(sb.toString()));
		    bw.write(code);
		} catch (IOException e) {
		    e.printStackTrace();
		}finally {
		    if(bw != null) 
		    	try {
		    		bw.close(); 
		    	} catch (IOException e) {
		    		e.printStackTrace();
		    	}
		}
		
        // 텍스트 파일 읽기
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(sb.toString()));
            String line;
            StringBuffer sbGet = new StringBuffer();
            while ((line = br.readLine()) != null) {
                System.out.println();
            	sbGet.append(line);
            }
            //System.out.println(sbGet.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }
		
		return mv;
		//JSONArray ja = new JSONArray();
		//JSONObject jo = new JSONObject();
		//jo.put("code", code);
		//ja.add(jo);
	//	System.out.println(ja);
		//PrintWriter writer = null;
		/*
		try {
			System.out.println("in try statement");
			response.setContentType("text/json; charset=euc-kr");
			writer = response.getWriter();
			writer.print(ja);
			//response.getWriter().print(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if(pw!=null) pw.close();
		*/
		
	}
}
