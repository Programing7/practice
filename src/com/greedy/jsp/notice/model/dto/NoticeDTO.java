package com.greedy.jsp.notice.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.greedy.jsp.board.model.dto.CategoryDTO;
import com.greedy.jsp.member.dto.MemberDTO;

public class NoticeDTO implements Serializable {
	
	private int no;
	private String title;
	private String body;
	private int categoryCode;
	private CategoryDTO category;
	private int writer;
	private MemberDTO writerDto;
	private int count;
	private Date date;
	private String status;
	
	public NoticeDTO() {}

	public NoticeDTO(int no, String title, String body, int categoryCode, CategoryDTO category, int writer,
			MemberDTO writerDto, int count, Date date, String status) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.categoryCode = categoryCode;
		this.category = category;
		this.writer = writer;
		this.writerDto = writerDto;
		this.count = count;
		this.date = date;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public int getWriter() {
		return writer;
	}

	public MemberDTO getWriterDto() {
		return writerDto;
	}

	public int getCount() {
		return count;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public void setWriterDto(MemberDTO writerDto) {
		this.writerDto = writerDto;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", body=" + body + ", categoryCode=" + categoryCode
				+ ", category=" + category + ", writer=" + writer + ", writerDto=" + writerDto + ", count=" + count
				+ ", date=" + date + ", status=" + status + "]";
	}
	
	

}
