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

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO no = (MemberDTO) session.getAttribute("memberLogin");
		int memberNo = no.getNo();
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		MemberDTO deleteMember = new MemberDTO();
		deleteMember.setNo(memberNo);
		deleteMember.setId(memberId);
		deleteMember.setPwd(memberPwd);
		
		int result = new MemberService().deleteMember(deleteMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteMember");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 탈퇴에 실패했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
