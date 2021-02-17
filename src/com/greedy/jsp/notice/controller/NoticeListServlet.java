package com.greedy.jsp.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.board.model.dto.PageInfoDTO;
import com.greedy.jsp.common.Pagenation;
import com.greedy.jsp.notice.model.dto.NoticeDTO;
import com.greedy.jsp.notice.model.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageNo : " + pageNo);
		
		NoticeService noticeService = new NoticeService();
		int totalCount = noticeService.selectTotalCount();
		
		System.out.println("totalCount : " + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		List<NoticeDTO> noticeList = noticeService.selectNoticeList(pageInfo);
		
		System.out.println(noticeList);
		
		for(NoticeDTO notice : noticeList) {
			System.out.println(notice);
		}
		
		String path = "";
		if(noticeList != null) {
			path = "/WEB-INF/views/notice/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
