package com.greedy.jsp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.notice.model.dto.NoticeDTO;
import com.greedy.jsp.notice.model.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDTO noticeDetail = new NoticeService().selectNoticeDetail(no);
		
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/notice/noticeDetail.jsp";
			request.setAttribute("notice", noticeDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String body = request.getParameter("body");
		
		NoticeDTO noticeUpdate = new NoticeDTO();
		noticeUpdate.setNo(no);
		noticeUpdate.setBody(body);
		
		NoticeService noticeService = new NoticeService();
		int result = noticeService.updateNotice(noticeUpdate);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateNotice");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 수정 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
}

