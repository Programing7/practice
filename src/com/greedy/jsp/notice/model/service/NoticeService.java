package com.greedy.jsp.notice.model.service;

import static com.greedy.jsp.jdbc.JDBCTemplate.close;
import static com.greedy.jsp.jdbc.JDBCTemplate.commit;
import static com.greedy.jsp.jdbc.JDBCTemplate.getConnection;
import static com.greedy.jsp.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.jsp.board.model.dto.PageInfoDTO;
import com.greedy.jsp.member.dao.MemberDAO;
import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.notice.model.dao.NoticeDAO;
import com.greedy.jsp.notice.model.dto.NoticeDTO;

public class NoticeService {
	
	private final NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}

	public int insertNotice(NoticeDTO insertNotice) {
		
		Connection con = getConnection();
		
		int result = noticeDAO.insertNotice(con, insertNotice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public List<NoticeDTO> selectNoticeList(PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<NoticeDTO> noticeList = noticeDAO.selectNoticeList(con, pageInfo);
		
		close(con);
		
		return noticeList;
	}

	public NoticeDTO selectNoticeDetail(int no) {
		
		Connection con = getConnection();
		
		NoticeDTO noticeDetail = noticeDAO.selectNoticeDetail(con, no);
		
		close(con);
		
		return noticeDetail;
	}

	public int updateNotice(NoticeDTO noticeUpdate) {
		
		Connection con = getConnection();
		
		int result = noticeDAO.updateNotice(con, noticeUpdate);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = noticeDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}



	}

