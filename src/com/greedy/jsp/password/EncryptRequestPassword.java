package com.greedy.jsp.password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptRequestPassword extends HttpServletRequestWrapper {

	public EncryptRequestPassword(HttpServletRequest request) {
		super(request);
		
	}

	@Override
	public String getParameter(String key) {
		
		String value = "";
		if("memberPwd".equals(key)) {
			BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
			value = pwdEncoder.encode(super.getParameter(key));
		} else {
			value = super.getParameter(key);
		}
		
		return value;
		
	}

}
