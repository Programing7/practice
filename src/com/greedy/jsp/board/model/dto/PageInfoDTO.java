package com.greedy.jsp.board.model.dto;

import java.io.Serializable;

public class PageInfoDTO implements Serializable {

	private int PageNo;
	private int totalCount;
	private int limit;
	private int buttonAmount;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	
	
	public PageInfoDTO() {}


	public PageInfoDTO(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage, int endPage,
			int startRow, int endRow) {
		super();
		PageNo = pageNo;
		this.totalCount = totalCount;
		this.limit = limit;
		this.buttonAmount = buttonAmount;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.endRow = endRow;
	}


	public int getPageNo() {
		return PageNo;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public int getLimit() {
		return limit;
	}


	public int getButtonAmount() {
		return buttonAmount;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public int getStartRow() {
		return startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setPageNo(int pageNo) {
		PageNo = pageNo;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public void setButtonAmount(int buttonAmount) {
		this.buttonAmount = buttonAmount;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	@Override
	public String toString() {
		return "PageInfoDTO [PageNo=" + PageNo + ", totalCount=" + totalCount + ", limit=" + limit + ", buttonAmount="
				+ buttonAmount + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	
	
}
