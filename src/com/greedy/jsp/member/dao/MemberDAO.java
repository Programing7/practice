package com.greedy.jsp.member.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.greedy.jsp.config.ConfigLocation;
import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.notice.model.dto.NoticeDTO;

import static com.greedy.jsp.jdbc.JDBCTemplate.close;

public class MemberDAO {
	
	private final Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/member/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int registMember(Connection con, MemberDTO registMember) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("registMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, registMember.getId());
			pstmt.setString(2, registMember.getPwd());
			pstmt.setString(3, registMember.getNickname());
			pstmt.setString(4, registMember.getPhone());
			pstmt.setString(5, registMember.getEmail());
			pstmt.setString(6, registMember.getAddress());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectEncryptPwd(Connection con, MemberDTO loginMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = null;
		
		String qeury = prop.getProperty("selectEncryptPwd");
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setString(1, loginMember.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				encPwd = rset.getString("MEMBER_PWD");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return encPwd;
	}

	public MemberDTO selectLoginMember(Connection con, MemberDTO loginMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO memberLogin = null;
		
		String query = prop.getProperty("selectLoginMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginMember.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberLogin = new MemberDTO();
				memberLogin.setNo(rset.getInt("MEMBER_NO"));
				memberLogin.setId(rset.getString("MEMBER_ID"));
				memberLogin.setPwd(rset.getString("MEMBER_PWD"));
				memberLogin.setNickname(rset.getString("NICKNAME"));
				memberLogin.setPhone(rset.getString("PHONE"));
				memberLogin.setEmail(rset.getString("EMAIL"));
				memberLogin.setAddress(rset.getString("ADDRESS"));
				memberLogin.setEnrollDate(rset.getDate("ENROLL_DATE"));
				memberLogin.setRoll(rset.getString("MEMBER_ROLE"));
				memberLogin.setStatus(rset.getString("MEMBER_STATUS"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberLogin;
	}

	public int updateMember(Connection con, MemberDTO updateMember) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, updateMember.getNickname());
			pstmt.setString(2, updateMember.getPhone());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setString(4, updateMember.getAddress());
			pstmt.setInt(5, updateMember.getNo());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection con, MemberDTO deleteMember) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, deleteMember.getNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}


}
