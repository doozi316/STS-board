package com.example.demo.board.controller;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.board.domain.MemberVO;
import com.example.demo.board.service.MemberService;

@Controller
@RequestMapping("/board/*") //모든 맵핑은 /board/를 상속
public class MemberController {
	//로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService memberService;
	
	//01. 로그인 화면
	@RequestMapping("login.do")
	public String login() {
		return "login";
	}
	
	//02.로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true ) { // 로그인 성공
			//list로 이동
			mav.setViewName("list");
			mav.addObject("msg","success");
		}else {//로그인 실패
			//login.jsp로 이동
			mav.setViewName("login");
			mav.addObject("msg","failure");
			
		}
		return mav;
	}
	
	// 03. 로그아웃 처리
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg","logout");
		return mav;
	}
}


