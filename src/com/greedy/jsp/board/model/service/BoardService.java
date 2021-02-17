package com.greedy.jsp.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.greedy.jsp.board.model.dao.BoardDAO;
import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;

import static com.greedy.jsp.jdbc.JDBCTemplate.getConnection;
import static com.greedy.jsp.jdbc.JDBCTemplate.close;


public class BoardService {
	
	private final BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = boardDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<BoardDTO> selectBoardList(PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(con, pageInfo);
		
		close(con);
		
		return boardList;
	}


}
