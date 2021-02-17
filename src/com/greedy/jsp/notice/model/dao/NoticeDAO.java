package com.greedy.jsp.notice.model.dao;

import static com.greedy.jsp.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.jsp.board.model.dto.CategoryDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;
import com.greedy.jsp.config.ConfigLocation;
import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.notice.model.dto.NoticeDTO;


public class NoticeDAO {
	
	private final Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/notice/notice-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNotice(Connection con, NoticeDTO insertNotice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, insertNotice.getTitle());
			pstmt.setString(2, insertNotice.getBody());
			pstmt.setInt(3, insertNotice.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<NoticeDTO> selectNoticeList(Connection con, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> noticeList = null;
		
		
		String query = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			
			rset = pstmt.executeQuery();
			
			noticeList = new ArrayList<>();
			
			while(rset.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setWriterDto(new MemberDTO());
				
				notice.setNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("NOTICE_TITLE"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriter(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				notice.getWriterDto().setNickname(rset.getString("NICKNAME"));
				notice.setCount(rset.getInt("NOTICE_COUNT"));
				notice.setDate(rset.getDate("CREATED_DATE"));
				
				
				noticeList.add(notice);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return noticeList;
			
	}

	public NoticeDTO selectNoticeDetail(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		NoticeDTO noticeDetail = null;
		
		String query = prop.getProperty("selectNoticeDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noticeDetail = new NoticeDTO();
				noticeDetail.setWriterDto(new MemberDTO());
				
				noticeDetail.setNo(rset.getInt("NOTICE_NO"));
				noticeDetail.setTitle(rset.getString("NOTICE_TITLE"));
				noticeDetail.setBody(rset.getString("NOTICE_BODY"));
				noticeDetail.setWriter(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				noticeDetail.getWriterDto().setNickname(rset.getString("NICKNAME"));
				noticeDetail.setDate(rset.getDate("CREATED_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return noticeDetail;
	}

	public int updateNotice(Connection con, NoticeDTO noticeUpdate) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, noticeUpdate.getBody());
			pstmt.setInt(2, noticeUpdate.getNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectTotalCount(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return totalCount;
	}



	}

