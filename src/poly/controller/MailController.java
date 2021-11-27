package poly.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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



@Controller("MailController")
public class MailController {

	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "MailService")
	private IMailService mailService;

	@Resource(name = "PWCService") private IPWCService PWCService;
	  
//	  @RequestMapping(value = "mail/sendMail") 
//	  private String sendMail(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
//	  log.info(this.getClass().getName() + "mail.sendMail start!");
//	  
//	  String toMail = CmmUtil.nvl(request.getParameter("toMail"));
//	  log.info(toMail); //String title =
//	  CmmUtil.nvl(request.getParameter("title")); //String contents =
//	  CmmUtil.nvl(request.getParameter("contents")); 
//	  
//	  String contents = RandomStringUtils.randomAlphanumeric(10);
//	  
//	  MailDTO pDTO = new MailDTO();
//	  pDTO.setToMail(toMail); 
//	  pDTO.setTitle("임시 비밀번호 입니다.");
//	  pDTO.setContents(contents);
//	  
//	  log.info("새로운 비밀번호 설정");
//
//	  String id = request.getParameter("toMail"); 
//	  log.info(contents);
//	  
//	  ProjectsDTO wDTO = new ProjectsDTO(); 
//	  wDTO.setUser_pwd(EncryptUtil.encHashSHA256(contents));
//	  wDTO.setUser_id(id); 
//	  log.info(wDTO.getUser_pwd());
//	  
//	  int res1 = PWCService.New(wDTO);
//
//	  if(res1 == 0) { 
//		  log.info("비밀번호 변경 실패"); 
//		  } else{
//	  	  log.info("비밀번호 변경 성공"); 
//	  	  }
//
//	  int res = mailService.doSendmail(pDTO);
//	  if(res == 1) { 
//		  	  log.info("메일발송 성공"); 
//		  } else { 
//			  log.info("메일 발송 실패"); }
//	  
//	  model.addAttribute("res", String.valueOf(res));
//	  
//	  log.info(this.getClass().getName() + "mail.sendMail end!");
//	 
//	  return "/mail/sendMailResult";
//	  
//	  }
	 
	 
}