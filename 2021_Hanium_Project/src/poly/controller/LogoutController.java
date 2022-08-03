package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.ILoginService;

// 21.08.13 : 미완 엑세스 토큰 활용법 잘 모름 , 세션 값 어떻게 너어야 하는지 잘 모름, 월요일에 배울 에정
// 21. 08. 16 : 내일로 미뤄짐 코드 확인 후 종료 
// 백업용

@Controller("LogoutController")
public class LogoutController {
	
	@Resource(name = "LoginService")
	private ILoginService LoginService;
	
	//==================================================== 로그 찍기 위한 메소드
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="user/Logout.do")
	public String logout(HttpSession session, Model model) throws Exception{       //session, model 사용
		
		log.info(this.getClass() + "user/Logout start !! ");
		
		String msg = "";
		String url = "";
		
		/*
		 * int res = LoginService.logout(accessToken); //엑세스 토큰값 뭐로 받아올지 아직 모르겠다.
		 * 
		 * if (res==1) { log.info("res : " + res); // 1이면 성공
		 * 
		 * msg = "로그아웃 성공"; url = "/user/login.do"; session.invalidate();
		 * 
		 * model.addAttribute("msg", msg); model.addAttribute("url", url); }else { msg =
		 * "로그아웃 실패"; url = "/"; }
		 * 
		 * log.info(this.getClass() + "user/logout end !!");
		 */
		
		return "/loginAlert";
	}

}
