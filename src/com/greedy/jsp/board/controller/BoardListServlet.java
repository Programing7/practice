package com.greedy.jsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;
import com.greedy.jsp.board.model.service.BoardService;
import com.greedy.jsp.common.Pagenation;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		System.out.println(currentPage);
		System.out.println(pageNo);
		
		BoardService boardService = new BoardService();
		int totalCount = boardService.selectTotalCount();
		
		System.out.println(totalCount);
		
		int limit = 10;
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		List<BoardDTO> boardList = boardService.selectBoardList(pageInfo);
		
		for(BoardDTO board : boardList) {
			System.out.println(board);
		}
		
		String path = "";
		if(boardList != null) {
			path = "/WEB-INF/views/board/boardList.jsp";
			request.setAttribute("boardList", boardList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
