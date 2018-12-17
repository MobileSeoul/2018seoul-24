package com.spring.seoulapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.seoulapp.dto.LikeVO;
import com.spring.seoulapp.dto.ReviewVO;
import com.spring.seoulapp.dto.UserVO;




@Repository
public class HangangDAOImpI implements HangangDAO{
	  @Inject
	    private SqlSession sqlSession;
	    
	    private static final String Namespace = "com.spring.seoulapp.memberMapper";
	    
	    @Override
	    public List<UserVO> selectMember() throws Exception {
	 
	        return sqlSession.selectList(Namespace+".selectMember");
	    }

		@Override
		public void insertUser(UserVO userVO) {
	/*		System.out.println("DAO email = " + userVO.getEmail());
			System.out.println("DAO name = " + userVO.getName());
			System.out.println("DAO pw = " + userVO.getPw());*/

			sqlSession.insert(Namespace+".insertUser", userVO);
		}

		@Override
		public void updateUser(UserVO userVO) {
			System.out.println("DAO email = " + userVO.getEmail());
			System.out.println("DAO name = " + userVO.getName());
			System.out.println("DAO pw = " + userVO.getPw());
			
			sqlSession.update(Namespace+".updateUser", userVO);
		}

		@Override
		public void insertReview(ReviewVO reviewVO) {
			sqlSession.insert(Namespace+".insertReview", reviewVO);
		}

		@Override
		public void insertLikeList(LikeVO likeVO) {
			sqlSession.insert(Namespace+".insertLikeList", likeVO);
		}

		@Override
		public List<UserVO> getPwCheck(HashMap<String, Object> review) {
			return sqlSession.selectList(Namespace+".getPwCheck", review);
		}

		@Override
		public List<ReviewVO> selectReview(HashMap<String, Object> Listreview) {
			return sqlSession.selectList(Namespace+".selectReview");
		}
		
		

	
	    
	    
	 
	}


