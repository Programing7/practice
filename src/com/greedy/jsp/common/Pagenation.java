package com.greedy.jsp.common;

import com.greedy.jsp.board.model.dto.PageInfoDTO;

public class Pagenation {

	public static PageInfoDTO getPageInfo(int pageNo, int totalCount, int limit, int buttonAmount) {
		
		int maxPage;
		int startPage;
		int endPage;
		int startRow;
		int endRow;
		
//		maxPage = (int) ((double) totalCount / limit + 0.9);
		
		maxPage = (int) Math.ceil((double) totalCount/limit);
		
		System.out.println(maxPage);
		
//		startPage = (((int) ((double) pageNo / buttonAmount + 0.9)) -1) * buttonAmount + 1;
		startPage = (int) (Math.ceil((double) pageNo / buttonAmount) -1) * buttonAmount + 1;
		
		System.out.println(startPage);
		
		endPage = startPage + buttonAmount - 1;
		
		System.out.println(endPage);
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		System.out.println(endPage);
		
		startRow = (pageNo -1) * limit + 1;
		endRow = startRow + limit -1;
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		
		return new PageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}

	
	
}
