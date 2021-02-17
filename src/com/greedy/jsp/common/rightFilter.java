package com.greedy.jsp.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.jsp.member.dto.MemberDTO;

@WebFilter(urlPatterns = {"/notice/*", "/member/*", "/board/*", "/thumbnail/*"})
public class rightFilter implements Filter {
	
	private Map<String, List<String>> permitURIList;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		
		System.out.println(uri);
		
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		System.out.println(intent);
		
		HttpSession session = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("memberLogin");
		
		if(loginMember != null) {
			
			boolean isAuthorized = false;
			
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			if("ADMIN".equals(loginMember.getRoll())) {
				if(isPermitAdmin || isPermitMember || isPermitAll) {
					isAuthorized = true;
				}
			} else if("MEMBER".equals(loginMember.getRoll())) {
				if((isPermitMember || isPermitAll) && !isPermitAdmin) {
					isAuthorized = true;
				}
			}
			
			if(isAuthorized) {
				chain.doFilter(request, response);
				
			} else {
				((HttpServletResponse) response).sendError(403);
			}
		} else {
			if(permitURIList.get("allPermitList").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "로그인이 필요한 서비스입니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(hrequest, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		adminPermitList.add("/notice/insert");
		adminPermitList.add("/notice/list");
		adminPermitList.add("/notice/insert");
		adminPermitList.add("/notice/detail");
		adminPermitList.add("/board/list");
		
		
		memberPermitList.add("/notice/list");
		
		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList", allPermitList);
		
	}

}
