package com.greedy.jsp.member.dto;

import java.sql.Date;

public class MemberDTO {
	
	private int no;
	private String id;
	private String pwd;
	private String nickname;
	private String phone;
	private String email;
	private String address;
	private Date enrollDate;
	private String roll;
	private String status;
	
	public MemberDTO() {}

	public MemberDTO(int no, String id, String pwd, String nickname, String phone, String email, String address,
			Date enrollDate, String roll, String status) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrollDate = enrollDate;
		this.roll = roll;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public String getRoll() {
		return roll;
	}

	public String getStatus() {
		return status;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", enrollDate=" + enrollDate + ", roll=" + roll
				+ ", status=" + status + "]";
	}
	
	
	
}
