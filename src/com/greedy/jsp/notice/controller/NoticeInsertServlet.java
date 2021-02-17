package com.greedy.jsp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.notice.model.dto.NoticeDTO;
import com.greedy.jsp.notice.model.service.NoticeService;

@WebServlet("/notice/insert")
public class NoticeInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/notice/insertForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO memberNo = (MemberDTO) session.getAttribute("memberLogin");
		int writerNo = memberNo.getNo();
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		NoticeDTO insertNotice = new NoticeDTO();
		insertNotice.setTitle(title);
		insertNotice.setBody(body);
		insertNotice.setWriter(writerNo);
		
		System.out.println(insertNotice);
		
		int result = new NoticeService().insertNotice(insertNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertNotice");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지등록에 실패했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
