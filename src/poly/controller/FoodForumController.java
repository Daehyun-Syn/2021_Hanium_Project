package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller("FoodForumController")
public class FoodForumController {

	private Logger log = Logger.getLogger(getClass()); 

	
	// 카카오 정보 제공을 위한 매핑 카카오 로그인 or 카카오 정보 제공 화면 보일 것
	@RequestMapping(value="/FoodForum")
	public String FoodForum(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		if (session.getAttribute("id") == null) {
			String url = "/user/login.do";
			String msg = "Please log in.";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			return "/redirect";
		}
		
		return "/FoodForum/bullentinBoard";
	}

	
}