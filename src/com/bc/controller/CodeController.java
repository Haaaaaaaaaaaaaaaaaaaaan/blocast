package com.bc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bc.frame.Service;
import com.bc.vo.FilesVO;
import com.bc.vo.FolderVO;

@Controller
public class CodeController {

	@Resource(name="fservice")
	Service<FilesVO,String> fservice;
	
	@Resource(name="fdservice")
	Service<FolderVO,String> fdservice;
	
	
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
	@RequestMapping("/iotnocode.bc")
	public ModelAndView iotnocode() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/nocode");
		return mv;
	}
	@RequestMapping("/bigdatanocode.bc")
	public ModelAndView bigdatanocode() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/nocode");
		return mv;
	}
	@RequestMapping("/blockchainday01.bc")
	public ModelAndView blockchain01(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/blockday01");
		
		System.out.println("blockchain day01 in");
		String code = null;
		String filename = null;
		String subject = null;
		String day = request.getParameter("day");
		String src = "C:\\code\\";
		String ent = "\\r\\n";
		//System.out.println(code);
		//System.out.println(filename);
		//System.out.println(subject);
		System.out.println(day);
		ArrayList<String> codeList = null;
		
		try {
			System.out.println("DB list get");
			ArrayList<FilesVO> flist = fservice.get();
			JSONObject data = new JSONObject();
			JSONArray ja = new JSONArray();
			JSONObject jo = null;
			JSONArray ca = null;
			JSONObject co = null;
			PrintWriter writer = null;
			
			for(FilesVO files: flist) {
				System.out.println("list in");
				filename = files.getName();
				StringBuffer folder = new StringBuffer();
				folder.append("day0");
				folder.append(files.getFolder_id());
				ca = new JSONArray();
				
		        BufferedReader br = null;
		        try {
		            br = new BufferedReader(new FileReader(src+filename));
		            codeList = new ArrayList<>();
		            String line;
		            while ((line = br.readLine()) != null) {
		            	co = new JSONObject();
		            	if(line.length() < 1) {
		            		co.put("line" ,"e");
		            	}else {
		            		co.put("line" ,line);
		            	}
		            	ca.add(co);
		            		
		            	
		            }
//		            for(String s : codeList) {
//		            	System.out.println(s);
//		            }
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }finally {
		            if(br != null) try {br.close(); } catch (IOException e) {}
		        }

		        //json 颇老 积己
				jo = new JSONObject();
				jo.put("filename", filename);
				jo.put("day", folder.toString());
				jo.put("code", ca);
				//jo.put("subject", subject);
				ja.add(jo);
//		        //json 颇老 积己
//				ja = new JSONArray();
//				jo = new JSONObject();
//				jo.put("fileName", fileName);
//				jo.put("code", sbGet.toString());
//				//jo.put("subject", subject);
//				jo.put("day", folder);
//				ja.add(jo);
//				//System.out.println(ja);
			}
			//data.put("data", ja);
			try {
				System.out.println(ja);
				System.out.println("send to ajax");
				//String json=data.toJSONString();
				response.setContentType("text/json; charset=euc-kr");
				writer = response.getWriter();
				writer.print(ja);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/blockchainday02.bc")
	public ModelAndView blockchain02() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/blockday02");
		return mv;
	}
	@RequestMapping("/blockchainday03.bc")
	public ModelAndView blockchain03() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage","code/blockday03");
		return mv;
	}
	@RequestMapping("/bigdata.bc")
	public ModelAndView bigdata() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("code_center","code/bigdata");
		return mv;
	}
	@RequestMapping("/iot.bc")
	public ModelAndView iot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("code_center","code/iot");
		return mv;
	}	
	//苞格焊扁
	@RequestMapping("/codelist.bc")
	public ModelAndView codelist() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("code_center","code/codeupload");
		return mv;
	}
	
	@RequestMapping("/codeupload.bc")	
	public void codeUpload(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("upload in");
		String code = request.getParameter("code");
		String filename = request.getParameter("filename");
		String subject = request.getParameter("subject");
		String day = request.getParameter("day");
		System.out.println(code);
		System.out.println(filename);
		System.out.println(subject);
		System.out.println(day);
		
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
		
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("filename", filename);
		jo.put("day", day);
		jo.put("subject", subject);
		jo.put("code", code);
		ja.add(jo);
		System.out.println(ja);
		PrintWriter writer = null;
		
		try {
			System.out.println("in try statement");
			response.setContentType("text/json; charset=euc-kr");
			writer = response.getWriter();
			writer.print(ja);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//db俊 历厘
		StringBuffer folderName = new StringBuffer();
		folderName.append("day0");
		folderName.append(day);
		//System.out.println(folderName.toString());
		try {
			if(folderName.toString().equals(fdservice.get(folderName.toString()).getName())) {
				//System.out.println("result true");
				fservice.register(new FilesVO(day,filename));
			}
		} catch (Exception e1) {
			//e1.printStackTrace();
			try {
				//System.out.println("result false");
				fdservice.register(new FolderVO(subject,folderName.toString()));
				fservice.register(new FilesVO(day,filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
