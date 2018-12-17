package com.spring.seoulapp.dto;

public class UserVO {
	
		private int idx;
		private String email;
	    private String pw;
	    private String name;
	   /* private String userProfile;*/
	 
	    
	    
	    public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getPw() {
	        return pw;
	    }
	 
	    public void setPw(String pw) {
	        this.pw = pw;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }

	/*	public String getUserProfile() {
			return userProfile;
		}

		public void setUserProfile(String userProfile) {
			this.userProfile = userProfile;
		}*/
	    
	    
	 
	}
