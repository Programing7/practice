package com.greedy.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.member.service.MemberService;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/registForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("zipCode")
					+ "$" + request.getParameter("address1")
					+ "$" + request.getParameter("address2");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + memberPwd);
		System.out.println("nickname : " + nickname);
		System.out.println("phone : " + phone);
		System.out.println("email : " + email);
		System.out.println("address : " + address);
		
		MemberDTO registMember = new MemberDTO();
		registMember.setId(memberId);
		registMember.setPwd(memberPwd);
		registMember.setNickname(nickname);
		registMember.setPhone(phone);
		registMember.setEmail(email);
		registMember.setAddress(address);
		
		int result = new MemberService().registMember(registMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "registMember");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
