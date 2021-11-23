package poly.controller;


import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.ProjectsDTO;
import poly.service.IMainService;


@Controller("MainController")
public class MainController {
	
	@Resource(name="MainService")
	private IMainService MainService;
	
	private Logger log = Logger.getLogger(getClass());



	// =========================================== 메인페이지 출력
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session,
	         ModelMap model) throws Exception {
		
		
		if (session.getAttribute("id") == null) {
			String url = "/user/login.do";
			String msg = "Please log in.";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			return "/redirect";
		}
		
		String id = (String)session.getAttribute("id");
		log.info("세션 아이디1 : " + id);
		
		//DB에서 회원의 정보를 가져오기 위한 DTO선언
		ProjectsDTO pDTO = null;
		pDTO = new ProjectsDTO();
		
		//pDTO에 유저 아이디를 담는다 (pDTO가 빈상태로 보낼수 없기 떄문)
		pDTO.setUser_id(id);
		log.info("세션 아이디2 : " + id);
		
		//pDTO에 담긴 유저 아이디를 바탕으로 DB에서 정보를 가져와 rDTO에 넣는다
		ProjectsDTO rDTO = MainService.getUserInfo(pDTO);
		
		//널처리
		if(rDTO==null) {
			rDTO=new ProjectsDTO();
		}
		
		log.info("세션 아이디3 : " + id);
		log.info(rDTO.getUser_allergy());
		log.info(rDTO.getUser_name());
		
		//DB에 저장돼있던 사용자 알러지값을 ','을 기준으로 쪼개서 ArrayList 형태로 저장
		ArrayList<String> UserAllerList = new ArrayList<String>(Arrays.asList(rDTO.getUser_allergy().split(",")));
		session.setAttribute("UserAllerList", UserAllerList);
		log.info("##############세션 알레르기 값 테스트############ :" + UserAllerList);
		session.setAttribute("rDTO",rDTO);
		return "/index";
	}
}
