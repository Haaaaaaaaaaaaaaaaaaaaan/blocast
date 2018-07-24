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

import com.bc.frame.Service;
import com.bc.frame.TlService;
import com.bc.vo.TagListVO;
import com.bc.vo.TagVO;

@Controller
public class TagController {

	@Resource(name="tlservice")
	TlService<TagListVO, String> taglistservice;
		
	@Resource(name="tservice")
	Service<TagVO, String> tagservice;

	// get tag list where question_id is given
	@RequestMapping("/taglist.bc")
	@ResponseBody
	public void qnalist(@RequestParam(value = "id") String qid, HttpServletResponse response)
			throws Exception {
		System.out.println("taglist controller Á¢¼Ó!");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		ArrayList<TagListVO> tlist = null;
		
		tlist = taglistservice.getTid(qid);

		for (TagListVO t : tlist) {
			ja.add(tagservice.get(t.getTag_id()).getName());
		}
		
		out.println(ja.toJSONString());

		out.close();
	}
	
	
}