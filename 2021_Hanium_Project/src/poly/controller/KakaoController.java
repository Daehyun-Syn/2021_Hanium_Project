package poly.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IKakaoService;
import poly.service.ILoginService;



@Controller("KakaoController") 
public class KakaoController {

	private Logger log = Logger.getLogger(getClass()); 

	@Resource(name="kakaoService") 
	private IKakaoService kakaoService;
	
	@Resource(name = "LoginService")
	private ILoginService LoginService;
	
	// 카카오 정보 제공을 위한 매핑 카카오 로그인 or 카카오 정보 제공 화면 보일 것
	@RequestMapping(value="/kakaologinProc")
	public String kakaoLoginProc(Model model) throws Exception {
		
		log.info(this.getClass().getName() + "kakaoLogin Start !!");
		
		String forKakao = kakaoService.getAuthcode();
		
		String msg = "카카오 로그인 시도";
		String url = forKakao;
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass().getName() + "kakaoLgoin End !!");
		
		return "/user/redirect";
	}

	
}