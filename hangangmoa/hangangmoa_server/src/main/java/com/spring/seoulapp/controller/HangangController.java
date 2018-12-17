package com.spring.seoulapp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.seoulapp.dto.LikeVO;
import com.spring.seoulapp.dto.ReviewVO;
import com.spring.seoulapp.dto.UserVO;
import com.spring.seoulapp.service.HangangService;

@Controller
public class HangangController {

	private static final Logger logger = LoggerFactory.getLogger(HangangController.class);

	@Inject
	private HangangService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) throws Exception {
	 * 
	 * logger.info("home"); List<HangangVO> memberList = service.selectMember();
	 * model.addAttribute("memberList", memberList); return "home"; }
	 */

	@ResponseBody
	@RequestMapping(value = "/select")
	public Map<String, List<UserVO>> select() throws Exception {
		Map<String, List<UserVO>> map = new HashMap<String, List<UserVO>>();

		
		List<UserVO> member = new ArrayList();
		member = service.selectMember();
		map.put("member", member);

		return map;

	}

	@RequestMapping("/join")
	@ResponseBody
	@PostMapping()
	public Message insert(@RequestBody UserVO userVO) {
		String msg = "성공";
		
		System.out.println("유저 인덱스 = " + userVO.getIdx());
		System.out.println("유저 아이디 = " + userVO.getEmail());
		System.out.println("유저 이름 = " + userVO.getName());
		System.out.println("유저 비밀번호 = " + userVO.getPw());

		Message hello = new Message();
		hello.setMsg(msg);
		service.insertUser(userVO);
		return hello;
	}
	
	/*@RequestMapping(value="/pwcheck", method=RequestMethod.POST)
    @ResponseBody
    public Object pwCheck(@RequestParam Map<String, Object> paramMap) {
 
        //리턴값
        Map<String, List<UserVO>> retVal = new HashMap<String,  List<UserVO>>();
 
        List<UserVO> review = new ArrayList();
        //정보입력
        review = service.getPwCheck(paramMap);
        retVal.put("review", review);
 
        if(result>0){
            retVal.put("code", "OK");
        }else{
            retVal.put("code", "FAIL");
            retVal.put("message", "패스워드를 확인해주세요.");
        }
        return retVal;
    }*/
	
	@RequestMapping(value="/pwcheck/{email}/{pw}", method=RequestMethod.GET)
	@ResponseBody
	    public Map<String, List<UserVO>> getPwCheck(@PathVariable("email") String email, @PathVariable("pw") String pw) {    // Map 형태의 데이터 반환하는 예 (/sample/sendMap)
		 	String emailValue = email;
	        String pwValue = pw;
	        Map<String, List<UserVO>> map = new HashMap<String, List<UserVO>>();    // Map 생성
	        
	        HashMap<String, Object> review = new HashMap<String, Object>();
	        review.put("email", emailValue);
	        review.put("pw", pwValue);

	        List<UserVO> result = new ArrayList();
	        result = service.getPwCheck(review);
	        map.put("result", result);
	        System.out.println(map);
	        return map;
	    }
	

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	@ResponseBody
	public Message updateUser(@RequestParam(value = "email", required = false, defaultValue = "1") String email,
							@RequestParam(value = "name", required = false, defaultValue = "jaeran") String name,
							@RequestParam(value = "pw", required = false, defaultValue = "0000") String pw
							) throws IOException {
		Message apiMessasge = new Message();

		try {
			UserVO userVO = new UserVO();
			userVO.setEmail(email);
			userVO.setName(name);
			userVO.setPw(pw);
			
			service.updateUser(userVO);
			apiMessasge.setMsg("수정 완료");

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			for (int i = 0; i < e.getStackTrace().length; i++) {
				System.out.println(e.getStackTrace()[i].toString());
			}
			apiMessasge.setMsg("수정 실패");
		}
		return apiMessasge;
	}
	
	
	@RequestMapping(value = "/upload/user/{idx}", method = RequestMethod.POST ,
		    consumes = {"multipart/form-data"})
	@ResponseBody
    public Message uploadUserProfilePicture(@PathVariable("idx") int idx,
                                               @RequestPart("file") MultipartFile sourceFile) throws IOException {
		String path = "/var/lib/tomcat8/webapps/resources/upload/profile_pictures/";
        return upload(path, idx, sourceFile);
    }
	
    public static Message upload(String path, int idx, MultipartFile sourceFile) {
    	Message apiMessage = new Message();
    	
        try {
            String sourceFileName = sourceFile.getOriginalFilename();
            String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
            File destinationFile;
            String destinationFileName;
            destinationFileName = idx + ".png";
//                    + sourceFileNameExtension;
            destinationFile = new File(path + "/" + destinationFileName);
            destinationFile.getParentFile().mkdirs();
            sourceFile.transferTo(destinationFile);
            if (sourceFile.getSize() > 0) {
            	apiMessage.setMsg("업로드 완료");
            } else {
            	apiMessage.setMsg("업로드 실패");
            }
        } catch (IOException e) {
        	apiMessage.setMsg("업로드 실패");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return apiMessage;
    }


    
	
	@RequestMapping(value="/insertreview", method = RequestMethod.POST)
	@ResponseBody
	public Message insertReview(@RequestParam(value = "idx")int idx, @RequestParam(value = "rvList", required=false, defaultValue="-")String rvList,
								/*@RequestParam(value = "rvDate", required=false) Date rvDate,*/ @RequestParam(value = "rvText", required=false, defaultValue="등록된 리뷰가 없습니다.") String rvText, 
								@RequestPart(value = "image", required = false) MultipartFile image, @RequestParam(value = "listGrade", required=false, defaultValue="0.0")double listGrade) throws IOException{
		Message apiMessasge = new Message();
		
		System.out.println("사용자 인덱스 = " + idx);
		System.out.println("리뷰 행사 = " + rvList);
		System.out.println("리뷰 텍스트 = " + rvText);
		System.out.println("별점 리뷰= " + listGrade);

		 if (!image.isEmpty()) {
	            try {
	                byte[] bytes = image.getBytes();
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream("/var/lib/tomcat8/webapps/resources/upload/review/" + new File(image.getOriginalFilename()))
	                );
	                System.out.println("이미지 저장 url = http://13.209.69.111:8080/resources/upload/review/" + image.getOriginalFilename());
	                String rvImage = "http://13.209.69.111:8080/resources/upload/review/" + image.getOriginalFilename();
	                stream.write(bytes);
	                stream.close();
	                apiMessasge.setMsg("업로드 완료");
	                // 해당 url 주소로 저장 (ex) http://18.188.54.59:8080/resources/upload/123.png
	                ReviewVO reviewVO = new ReviewVO();

	                reviewVO.setIdx(idx);
	                reviewVO.setRvList(rvList);
	                /*reviewVO.setRvDate(rvDate);*/
	                reviewVO.setRvImage(rvImage);
	                reviewVO.setRvText(rvText);
	                reviewVO.setListGrade(listGrade);
	                service.insertReview(reviewVO);

	            } catch (Exception e) {
	                System.out.println("Exception : " + e.getMessage());
	                for (int i = 0; i < e.getStackTrace().length; i++) {
	                    System.out.println(e.getStackTrace()[i].toString());
	                }
	                apiMessasge.setMsg("업로드 실패");
	            }
	        }
	        else{
	            apiMessasge.setMsg("업로드 완료");
	            // 해당 url 주소로 저장 (ex) http://18.188.54.59:8080/resources/upload/123.png
	            ReviewVO reviewVO = new ReviewVO();

	            reviewVO.setIdx(idx);
	            reviewVO.setRvList(rvList);
	            /*reviewVO.setRvDate(rvDate);*/
                reviewVO.setRvText(rvText);
                reviewVO.setRvImage("default");
                reviewVO.setListGrade(listGrade);

                service.insertReview(reviewVO);
	        }
	        return apiMessasge;
	}
	
	// 해당 행사 리뷰 뿌려주기
/*	@RequestMapping(value= "/review/{rvList}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, List<ReviewVO>> selectReview(@PathVariable("rvList") String rvList){
		String rvListValue = rvList;
		System.out.println(rvList);
		Map<String, List<ReviewVO>> map = new HashMap<String, List<ReviewVO>>();
			
		HashMap<String, Object> reviewMap = new HashMap<String, Object>();
		reviewMap.put("rvList", rvListValue);
		
		List<ReviewVO> result = new ArrayList();
		result = service.selectReview(reviewMap);
		map.put("result", result);
		
		System.out.println(map);
		return map;
	}*/
	
	@RequestMapping(value="/review/{rvList}", method=RequestMethod.GET)
	@ResponseBody
	    public Map<String, List<ReviewVO>> getReview(@PathVariable("rvList") String rvList) {    // Map 형태의 데이터 반환하는 예 (/sample/sendMap)
		 	String rvListValue = rvList;
	        Map<String, List<ReviewVO>> map = new HashMap<String, List<ReviewVO>>();    // Map 생성
	        
	        HashMap<String, Object> Listreview = new HashMap<String, Object>();
	        Listreview.put("rvList", rvListValue);

	        List<ReviewVO> result = new ArrayList();
	        result = service.selectReview(Listreview);
	        map.put("result", result);
	        System.out.println(map);
	        return map;
	    }
	
	@RequestMapping(value="/insertlikelist", method = RequestMethod.POST)
	@ResponseBody
	public Message insertLikeList(@RequestParam(value = "idx")int idx, @RequestParam(value = "listName", required=false, defaultValue="-") String listName,
									@RequestParam(value = "listDate", required=false, defaultValue="없습니다") String listDate, 
									@RequestParam(value = "listTime", required=false, defaultValue="없습니다") String listTime, @RequestParam(value = "listPlace", required=false, defaultValue="없습니다") String listPlace, 
									@RequestParam(value = "listInfo", required=false, defaultValue="없습니다") String listInfo, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException{
		Message apiMessasge = new Message();
		
		System.out.println("사용자 인덱스 = " + idx);
		System.out.println("축제 이름 = " + listName);
		System.out.println("축제 날짜 = " + listDate);
		System.out.println("축제 시간 = " + listTime);
		System.out.println("축제 장소 = " + listPlace);
		System.out.println("축제 상세정보 = " + listInfo);
		System.out.println("축제 이미지 = " + image);
		
		
		if (!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream("/var/lib/tomcat8/webapps/resources/upload/list/" + new File(image.getOriginalFilename()))
						);
				System.out.println("이미지 저장 url = http://13.209.69.111:8080/resources/upload/list/" + image.getOriginalFilename());
				String imageURL = "http://13.209.69.111:8080/resources/upload/list/" + image.getOriginalFilename();
				stream.write(bytes);
				stream.close();
				apiMessasge.setMsg("찜 완료");
				// 해당 url 주소로 저장 (ex) http://18.188.54.59:8080/resources/upload/123.png
				LikeVO likeVO = new LikeVO();
				
				likeVO.setIdx(idx);
				likeVO.setListName(listName);
				likeVO.setListDate(listDate);
				likeVO.setListTime(listTime);
				likeVO.setListPlace(listPlace);
				likeVO.setListInfo(listInfo);
				likeVO.setImageURL(imageURL);
				
				service.insertLikeList(likeVO);
				
			} catch (Exception e) {
				System.out.println("Exception : " + e.getMessage());
				for (int i = 0; i < e.getStackTrace().length; i++) {
					System.out.println(e.getStackTrace()[i].toString());
				}
				apiMessasge.setMsg("찜 실패");
			}
		}
		else{
			apiMessasge.setMsg("찜 완료");
			// 해당 url 주소로 저장 (ex) http://18.188.54.59:8080/resources/upload/123.png
			LikeVO likeVO = new LikeVO();
			
			likeVO.setIdx(idx);
			likeVO.setListName(listName);
			likeVO.setListDate(listDate);
			likeVO.setListTime(listTime);
			likeVO.setListPlace(listPlace);
			likeVO.setListInfo(listInfo);
			likeVO.setImageURL("default");
			
			service.insertLikeList(likeVO);
		}
		return apiMessasge;
	}
    
	
/*	// 해당 행사 리뷰 뿌려주기
		@RequestMapping(value= "/{rvList}/selectreview", method=RequestMethod.GET)
		@ResponseBody
		public Map<String, List<ReviewVO>> selectReview(@PathVariable("rvList") String rvList){
			String reviewList = rvList;
			Map<String, List<ReviewVO>> map = new HashMap<String, List<ReviewVO>>();
			
			
			List<ReviewVO> result = new ArrayList();
			result = service.selectReview(reviewList);
			map.put("result", result);

			return map;

		}*/



}
