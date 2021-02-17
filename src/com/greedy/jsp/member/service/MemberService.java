package com.greedy.jsp.member.service;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greedy.jsp.member.dao.MemberDAO;
import com.greedy.jsp.member.dto.MemberDTO;
import com.greedy.jsp.password.EncryptRequestPassword;

import oracle.jdbc.OracleConnection.CommitOption;

import static com.greedy.jsp.jdbc.JDBCTemplate.getConnection;
import static com.greedy.jsp.jdbc.JDBCTemplate.commit;
import static com.greedy.jsp.jdbc.JDBCTemplate.rollback;
import static com.greedy.jsp.jdbc.JDBCTemplate.close;

public class MemberService {

	private final MemberDAO memberDAO;

	public MemberService() {
		memberDAO = new MemberDAO();
	}

	public int registMember(MemberDTO registMember) {

		Connection con = getConnection();

		int result = memberDAO.registMember(con, registMember);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		} 
		close(con);

		return result;
	}

	public MemberDTO loginMember(MemberDTO loginMember) {

		Connection con = getConnection();
		MemberDTO memberLogin = null;
		String encPwd = memberDAO.selectEncryptPwd(con, loginMember);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(loginMember.getPwd(), encPwd)) {

			memberLogin = memberDAO.selectLoginMember(con, loginMember);
		}

		close(con);

		return memberLogin;
	}

	public MemberDTO updateMember(MemberDTO updateMember) {

		Connection con = getConnection();
		MemberDTO memberUpdate = null;

		String encPwd = memberDAO.selectEncryptPwd(con, updateMember);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(updateMember.getPwd(), encPwd)) {
			int result = memberDAO.updateMember(con, updateMember);

			memberUpdate = memberDAO.selectLoginMember(con, updateMember);

			if(result > 0 && memberUpdate != null) {
				commit(con);
			} else {
				rollback(con);
			}	
			
		}
		close(con);
		
		return memberUpdate;
		
	}

	public int deleteMember(MemberDTO deleteMember) {
		
		Connection con = getConnection();
		int result = 0;
		
		String encPwd = memberDAO.selectEncryptPwd(con, deleteMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(deleteMember.getPwd(), encPwd)) {
			result = memberDAO.deleteMember(con, deleteMember);
		}
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
}