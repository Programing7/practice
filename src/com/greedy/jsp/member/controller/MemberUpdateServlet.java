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

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/updateForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO no = (MemberDTO) session.getAttribute("memberLogin");
		int memberNo = no.getNo();
		
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("zipCode")
					+ "$" + request.getParameter("address1")
					+ "$" + request.getParameter("address2");
		
		MemberDTO updateMember = new MemberDTO();
		updateMember.setNo(memberNo);
		updateMember.setId(memberId);
		updateMember.setPwd(memberPwd);
		updateMember.setNickname(nickname);
		updateMember.setPhone(phone);
		updateMember.setEmail(email);
		updateMember.setAddress(address);
		
		MemberService memberService = new MemberService();
		MemberDTO memberUpdate = memberService.updateMember(updateMember);
		
		String path = "";
		if(memberUpdate != null) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateMember");
			request.getSession().setAttribute("memberLogin", memberUpdate);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 수정에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
