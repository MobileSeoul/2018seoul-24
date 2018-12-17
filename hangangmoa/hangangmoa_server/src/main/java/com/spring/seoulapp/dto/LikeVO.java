package com.spring.seoulapp.dto;

public class LikeVO {
	
	// idx와 listName = PK
	private int idx;
	private String listName;
	private String listDate;
	private String listTime;
	private String listPlace;
	private String listInfo;
	private String imageURL;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListDate() {
		return listDate;
	}
	public void setListDate(String listDate) {
		this.listDate = listDate;
	}
	public String getListTime() {
		return listTime;
	}
	public void setListTime(String listTime) {
		this.listTime = listTime;
	}
	public String getListPlace() {
		return listPlace;
	}
	public void setListPlace(String listPlace) {
		this.listPlace = listPlace;
	}
	public String getListInfo() {
		return listInfo;
	}
	public void setListInfo(String listInfo) {
		this.listInfo = listInfo;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	

}
