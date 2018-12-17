package com.spring.seoulapp.dto;

import java.util.Date;

public class ReviewVO {

	private int idx;
	private String rvList;		//	review 이벤트 목록
	private Date rvDate;
	private String rvImage;
	private String rvText;
	private double listGrade;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	
	public String getRvList() {
		return rvList;
	}
	public void setRvList(String rvList) {
		this.rvList = rvList;
	}
	
	public String getRvImage() {
		return rvImage;
	}
	public void setRvImage(String rvImage) {
		this.rvImage = rvImage;
	}
	public String getRvText() {
		return rvText;
	}
	public void setRvText(String rvText) {
		this.rvText = rvText;
	}
	public double getListGrade() {
		return listGrade;
	}
	public void setListGrade(double listGrade) {
		this.listGrade = listGrade;
	}
	public Date getRvDate() {
		return rvDate;
	}
	public void setRvDate(Date rvDate) {
		this.rvDate = rvDate;
	}
	
	
	
	
	
}
