package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MailDTO;
import poly.dto.ProjectsDTO;
import poly.service.IMailService;
import poly.service.IPWCService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller("PWController")
public class PWController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "PWCService")
	private IPWCService PWCService;
	
	@Resource(name = "MailService")
	private IMailService mailService;
	
	// ================================= 비밀번호 찾기 페이지
	@RequestMapping(value = "user/forgot")
	public String forgot() {
		log.info("비밀번호 찾기 페이지 출력");
		return "/user/forgot";
	}
	
	// ================================== 비밀번호 로직
		 @RequestMapping(value = "user/Search")
		 public String Search(HttpServletRequest request, ModelMap model) throws Exception {
		 log.info("비밀번호 찾기 시작");
		 
		 String id = request.getParameter("toMail"); 
		 log.info("웹사이트에서 받아온 아이디 값 :" + id);
		 
		 ProjectsDTO oDTO = new ProjectsDTO(); 
		 oDTO.setUser_id(id);
		 log.info("oDTO에 입력된 ID : " + oDTO.getUser_id()); 
		 
		 int res = PWCService.Search(oDTO);
		 
		 String result = "";
		 if (res == 2) {
			    result = "/mail/sendMailResult";
			} else if (res == 1) {
				result = "/user/Return";
					log.info(result);
			} else {
				result = "ERROR : 3064";
					log.info(result);
			}
		 
		 log.info("메일 발송 시작!");
		 
		 String toMail = CmmUtil.nvl(request.getParameter("toMail"));
		 log.info("SMTP로 보낼 메일 주소" + toMail);
		 String contents = RandomStringUtils.randomAlphanumeric(10);
		
		 MailDTO pDTO = new MailDTO();
		 
		 pDTO.setToMail(toMail);
		 pDTO.setTitle("임시 비밀번호 입니다.");
		 pDTO.setContents(contents+"\n로그인 후 마이페이지에서 비밀번호를 변경해주세요.");
		 
		 log.info("SMTP로 보낼 임시 비밀번호 설정 로직 실행");
		 log.info("랜덤으로 생성된 임시 비밀번호 : " + contents);
		 
		 ProjectsDTO wDTO = new ProjectsDTO(); 
		 wDTO.setUser_pwd(EncryptUtil.encHashSHA256(contents));
		 wDTO.setUser_id(id);
		 log.info("wDTO에 들어간 임시 비밀번호 : " + wDTO.getUser_pwd()); 
		 
		 int res1 = PWCService.New(wDTO);
		 
		 if(res1 == 0) {
			 log.info("매퍼에서 sql문 에러=>비밀번호 변경 실패");
		 }
		 else{
			 
			 log.info("매퍼에서 sql문 성공=>비밀번호 변경 성공");
		 }
		 
	 	int res2 = mailService.doSendmail(pDTO);
		 
		 if(res2 == 1) {
			 log.info("메일발송 성공");
		 } else {
			 log.info("메일 발송 실패");
		 }
		 
		 
		 model.addAttribute("res", String.valueOf(res2));
		 
		 log.info(this.getClass().getName() + "mail.sendMail end!");
		 
		 return result;
		 
	 }
		
		// ================================= 비밀번호 변경 페이지
			@RequestMapping(value = "user/PWchange")
			public String change(HttpServletRequest request, HttpServletResponse reponse, HttpSession session) {
				if (session.getAttribute("id") == null) {
					String url = "/user/login.do";
					String msg = "Please log in.";
					request.setAttribute("url", url);
					request.setAttribute("msg", msg);
					return "/redirect";
				}
				log.info("비밀번호 찾기 페이지 출력");
				return "/user/PWchange";
			}
		// ================================= 비밀번호 변경 로직
			@RequestMapping(value = "user/PWchangeL")
			public String PWchangeL(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
				log.info("비밀번호 변경 로직 실행");
				
			  //비밀번호 변경에 대한 메시지를 전달할 변수
			    String msg= "";
			    
			  //웹 비밀번호 변경화면 에서 받는 정보를 저장할 변수
			    ProjectsDTO uDTO = null;
			    try { 
			    String passwordCheck = CmmUtil.nvl(request.getParameter("pwdck"));	
				String password = CmmUtil.nvl(request.getParameter("pwd"));

				log.info("new_password : "+password);

				
				//웹(비밀번호 변경화면)에서 받는 정보를 저장할 변수를 메모리에 올리기
				uDTO = new ProjectsDTO();
				
				uDTO.setUser_pwdck(EncryptUtil.encHashSHA256(passwordCheck));
				uDTO.setUser_id((String)session.getAttribute("id"));
				uDTO.setUser_pwd(EncryptUtil.encHashSHA256(password));

				
				int res = PWCService.PWchange(uDTO);

				
				if (res==1) {
		            msg = "You succeeded in changing the password.";
		         //추후 회원가입 입력화면에서 ajax를 활용해서 아이디 중복, 이메일 중복을 체크하길 바람
		         }else if (res==2) {
		            msg = "The password you entered does not match the current password, so it will be terminated.";
		         }else {
		            msg = "The password change failed due to an error.";
		         }
				
		      }catch(Exception e) {
		         //저장이 실패되면 사용자에게 보여줄 메시지
		         msg = "Failed :" + e.toString();
		         log.info(e.toString());
		         e.printStackTrace();
		         
		      }finally {
		         log.info(this.getClass().getName() + "PW변경 종료!");
		         //비밀번호 변경 결과 메시지 전달하기
		         model.addAttribute("msg", msg);
		         //비밀번호 변경 결과 메시지 전달하기
		         model.addAttribute("uDTO", uDTO);
		         //변수 초기화(메모리 효율화 시키기위해 사용함)
		         uDTO = null;
		      }
				
				return "/alert/PWchange";
			}
				
}
