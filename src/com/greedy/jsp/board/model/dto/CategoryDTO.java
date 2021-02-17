package com.greedy.jsp.board.model.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

	private int code;
	private String name;
	
	public CategoryDTO() {}

	public CategoryDTO(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDTO [code=" + code + ", name=" + name + "]";
	}
	
	
}
