package poly.controller;
//깃테스트 이진아


//git test_김학겸

// 깃 테스트 주현

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import poly.dto.ProjectsDTO;
import poly.service.IJoinService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller("JoinController")
public class JoinController {

	@Resource(name = "JoinService")
	private IJoinService JoinService;
	
	private Logger log = Logger.getLogger(getClass());
	
	
	// ================================= 회원가입 페이지
	@RequestMapping(value = "user/join")
	public String join() {
		log.info("로그인 페이지 출력");
		return "/user/join";
	}
	
	// ================================== 회원가입 로직
	
		@RequestMapping(value = "user/user/join.do")
		public String insertinfo(HttpServletRequest request, ModelMap model) throws Exception {
			log.info("회원가입 로직 실행");
			
		  //회원가입 결과에 대한 메시지를 전달할 변수
		    String msg= "";
		    
		  //웹 회원정보 입력화면 에서 받는 정보를 저장할 변수
		    ProjectsDTO uDTO = null;
		    try { 
			String id = CmmUtil.nvl(request.getParameter("id"));
			String password = CmmUtil.nvl(request.getParameter("pwd"));
			String name = CmmUtil.nvl(request.getParameter("name"));
			String year = CmmUtil.nvl(request.getParameter("year"));
			String month = CmmUtil.nvl(request.getParameter("month"));
			String datey = CmmUtil.nvl(request.getParameter("date"));
			String gender = CmmUtil.nvl(request.getParameter("gender"));
			String date = CmmUtil.nvl((year)+("-"+month)+("-"+datey));
			String lang = CmmUtil.nvl(request.getParameter("lang"));
			//효율적인 문자열 붙이기를 위한 스트링빌더 사용
			StringBuilder allergySB= new StringBuilder();
			for(int i =0;i<8;i++) {
				String str= CmmUtil.nvl(request.getParameter( ("allergy"+(i+1))  ) );
				
				if(!str.equals("") && !str.equals("undifined")) {
					log.info("str : "+str);
					allergySB.append(str);
					if(i!=7)
					allergySB.append(",");
				}
			}
			String allergy = allergySB.toString();
			
			log.info("user_id : "+id);
			log.info("user_password : "+password);
			log.info("user_name : "+name);
			log.info("birth_year : "+year);
			log.info("birth_month : "+month);
			log.info("birth_date : "+datey);
			log.info("birth : "+date);
			log.info("gender : "+gender);
			log.info("allergy : "+allergy);
			
			//웹(회원정보 입력화면)에서 받는 정보를 저장할 변수를 메모리에 올리기
			uDTO = new ProjectsDTO();

			uDTO.setUser_id(id);
			//비밀번호는 절대로 복호화 되지 않도록 해시 알고리즘으로 암호화함
			uDTO.setUser_pwd(EncryptUtil.encHashSHA256(password));
			uDTO.setUser_name(name);
			uDTO.setUser_date(date);
			uDTO.setUser_gender(gender);
			uDTO.setUser_allergy(allergy);
			uDTO.setUser_lang(lang);

			int res = JoinService.insertinfo(uDTO);

			
			if (res==1) {
	            msg = "You have succeeded in signing up as a member.";
	         //추후 회원가입 입력화면에서 ajax를 활용해서 아이디 중복, 이메일 중복을 체크하길 바람
	         }else if (res==2) {
	            msg = "This is an ID that has already been registered already.\nPlease sign up with a different ID.";
	         }else {
	            msg = "The membership registration failed due to an error.";
	         }
			
	      }catch(Exception e) {
	         //저장이 실패되면 사용자에게 보여줄 메시지
	         msg = "실패하였습니다 :" + e.toString();
	         log.info(e.toString());
	         e.printStackTrace();
	         
	      }finally {
	         log.info(this.getClass().getName() + ".insertUserInfo end!");
	         //회원가입 여부 결과 메시지 전달하기
	         model.addAttribute("msg", msg);
	         //회원가입 여부 결과 메시지 전달하기
	         model.addAttribute("uDTO", uDTO);
	         //변수 초기화(메모리 효율화 시키기위해 사용함)
	         uDTO = null;
	      }
			
			return "/alert/JoinMsg";
		}
		
		
}
