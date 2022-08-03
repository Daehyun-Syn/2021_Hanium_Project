package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MailDTO;
import poly.service.IMailService;
import poly.util.CmmUtil;

@Controller("CustomerCenterController")

public class CustomerCenterController {

	private Logger log = Logger.getLogger(getClass());

	@Resource(name = "MailService")
	private IMailService mailService;

	@RequestMapping(value = "/customerCenter/csCenterMail")
	   public String Mail(HttpServletRequest request, HttpSession session, ModelMap model,
				HttpServletResponse response) throws Exception {
		if (session.getAttribute("id") == null) {
			String url = "/user/login.do";
			String msg = "Please log in.";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			return "/redirect";
		}
		
	      log.info(this.getClass());
	      

	      return "/customerCenter/csCenterMail";
	   }
	
	@RequestMapping(value = "/customerCenter/csCenterMails")
	   public String Mails(HttpServletRequest request, HttpSession session, ModelMap model,
				HttpServletResponse response) throws Exception {

	      log.info(this.getClass());
	      
			String toMail = "style0986@naver.com";
			String title = CmmUtil.nvl(request.getParameter("title"));
			String contents = CmmUtil.nvl(request.getParameter("contents"));
			
			// 값 들어갔는지 확인
			log.info(toMail);
			log.info(title);
			log.info(contents);

			MailDTO pDTO = new MailDTO();

			pDTO.setToMail(toMail);
			pDTO.setTitle(title);
			pDTO.setContents(contents);

			int res = mailService.contactwrite(pDTO);

			if (res == 1) {
				log.info(this.getClass().getName() + "mail.sendMail success !");
			} else {
				log.info(this.getClass().getName() + "mail.sendMail fail !");
			}

			model.addAttribute("res", String.valueOf(res));

			log.info(this.getClass().getName() + "mail.sendMail end !");
			 
	      return "/alert/customerCenterAlert";
	   }

}