package com.spring.seoulapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.seoulapp.dto.LikeVO;
import com.spring.seoulapp.dto.ReviewVO;
import com.spring.seoulapp.dto.UserVO;


public interface HangangService {
	List<UserVO> selectMember() throws Exception;

	void insertUser(UserVO userVO);

	void updateUser(UserVO userVO);
	
	void insertReview(ReviewVO reviewVO);

	void insertLikeList(LikeVO likeVO);
	
	List<UserVO> getPwCheck(HashMap<String, Object> review);
	
	List<ReviewVO> selectReview(HashMap<String, Object> Listreview);

}
