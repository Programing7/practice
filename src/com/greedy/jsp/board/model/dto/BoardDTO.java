package com.greedy.jsp.board.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.greedy.jsp.member.dto.MemberDTO;

public class BoardDTO implements Serializable {

	private int no;
	private int type;
	private int categoryCode;
	private CategoryDTO category;
	private String title;
	private String body;
	private int writerMemberNo;
	private MemberDTO Writer;
	private int count;
	private Date createdDate;
	private Date moditiedDate;
	private String status;
	
	public BoardDTO() {}

	public BoardDTO(int no, int type, int categoryCode, CategoryDTO category, String title, String body,
			int writerMemberNo, MemberDTO writer, int count, Date createdDate, Date moditiedDate, String status) {
		super();
		this.no = no;
		this.type = type;
		this.categoryCode = categoryCode;
		this.category = category;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		Writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.moditiedDate = moditiedDate;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public int getType() {
		return type;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public MemberDTO getWriter() {
		return Writer;
	}

	public int getCount() {
		return count;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModitiedDate() {
		return moditiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public void setWriter(MemberDTO writer) {
		Writer = writer;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModitiedDate(Date moditiedDate) {
		this.moditiedDate = moditiedDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", type=" + type + ", categoryCode=" + categoryCode + ", category=" + category
				+ ", title=" + title + ", body=" + body + ", writerMemberNo=" + writerMemberNo + ", Writer=" + Writer
				+ ", count=" + count + ", createdDate=" + createdDate + ", moditiedDate=" + moditiedDate + ", status="
				+ status + "]";
	}
	
	
	
	
}
