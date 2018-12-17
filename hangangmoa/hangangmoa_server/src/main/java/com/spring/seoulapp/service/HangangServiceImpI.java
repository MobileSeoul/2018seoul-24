package com.spring.seoulapp.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.seoulapp.dao.HangangDAO;
import com.spring.seoulapp.dto.LikeVO;
import com.spring.seoulapp.dto.ReviewVO;
import com.spring.seoulapp.dto.UserVO;


@Service
public class HangangServiceImpI implements HangangService {

	@Inject
	private HangangDAO dao;
	
	@Override
	public List<UserVO> selectMember() throws Exception{
		return dao.selectMember();
	}

	@Override
	public void insertUser(UserVO userVO) {
		  dao.insertUser(userVO);
	}

	@Override
	public void updateUser(UserVO userVO) {
		dao.updateUser(userVO);
	}

	@Override
	public void insertReview(ReviewVO reviewVO) {
		dao.insertReview(reviewVO);
	}

	@Override
	public void insertLikeList(LikeVO likeVO) {
		dao.insertLikeList(likeVO);
		
	}

	@Override
	public List<UserVO> getPwCheck(HashMap<String, Object> review) {
		return dao.getPwCheck(review);
	}

	@Override
	public List<ReviewVO> selectReview(HashMap<String, Object> Listreview){
		return dao.selectReview(Listreview);
	}
	
	
	
	
	


	
	
}
