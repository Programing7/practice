package com.greedy.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.member.service.MemberService;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + memberPwd);
		
		MemberDTO loginMember = new MemberDTO();
		loginMember.setId(memberId);
		loginMember.setPwd(memberPwd);
		
		MemberService memberService = new MemberService();
		MemberDTO memberLogin = memberService.loginMember(loginMember);
		
		
		if(memberLogin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberLogin", memberLogin);
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}













