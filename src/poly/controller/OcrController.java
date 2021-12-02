package poly.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.Session;

import poly.dto.SearchAllerDTO;
import poly.service.IOcrService;
import poly.util.DateUtil;
import poly.util.FileUtil;
import poly.util.UrlUtil;

@Controller("OcrController")
public class OcrController{
	private Logger log = Logger.getLogger(getClass());

	/*
	 *  비즈니스 로직( 중요 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재( 싱글톤패턴 적용됨)
	 */
	@Resource(name = "OcrService")
	private IOcrService ocrService;
	
	// 업로드되는 파일이 저장되는 기본 폴더 설정(자바에서 경로는 /로 표현함)
	final private String FILE_UPLOAD_SAVE_PATH = "c:/upload"; // C:\\upload 폴더에저장
	
	/**
	 * 이미지 인식을 위한 파일업로드 화면 호출
	 */
	
	@RequestMapping(value="ocr/imageFileUpload")
	public String Index(HttpServletRequest request, HttpServletResponse reponse, HttpSession session) {
		log.info(this.getClass().getName() + ".imageFileUpload! ");
		log.info(session.getAttribute("user_allergy"));
		if (session.getAttribute("id") == null) {
			String url = "/user/login.do";
			String msg = "Please log in.";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			return "/redirect";
		}
		return "/ocr/ImageFileUpload";
	}
	
	/**
	 * 파일 업로드 및 이미지 인식
	 */
	@RequestMapping(value="ocr/getReadforImageText")
	@ResponseBody
	public List<SearchAllerDTO> getReadforImageText(HttpServletRequest request, HttpServletResponse response, ModelMap model,HttpSession session,
			@RequestParam(value= "fileUpload") MultipartFile mf) throws Exception {
		log.info("OcrController: 컨트롤러 시작");
		String res = "";
		String t_res = "";
		String originalFileName = mf.getOriginalFilename();
		log.info(originalFileName);
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toLowerCase();
		SearchAllerDTO saDTO = new SearchAllerDTO();
		if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {
			String saveFileName = DateUtil.getDateTime("hhmmss") + "." + ext;

			String saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);

			String fullFileInfo = saveFilePath + "/" + saveFileName;

			log.info(ext);
			log.info(saveFileName);
			log.info(saveFilePath);
			log.info(fullFileInfo);

			mf.transferTo(new File(fullFileInfo));

			UrlUtil uu = new UrlUtil();

			String url = "http://127.0.0.1:5000";
			String api = "/image?";
			String iname = "ipath=";
			String ipath = fullFileInfo;

			log.info("url :" +url +"api : "+ api +"api : "+ iname +"ipath : "+ ipath);
			res = uu.urlReadforString(url + api + iname + ipath);
			log.info(res);
			System.out.println("res :" + t_res);
			saDTO.setFood_name(res);
		} 
		List<SearchAllerDTO> rList = ocrService.getFoodList(saDTO);
		List<String> allergyList = (List<String>) session.getAttribute("UserAllerList");
		String msg = "";
		for(int i=0; i<allergyList.size(); i++) {
			log.info("나의알러지 : "+allergyList.get(i));
			for(int j=0; j<rList.get(0).getfood_allergy1().size(); j++) {
				log.info("음식알러지 : " + rList.get(0).getfood_allergy1().get(j) );
				if(allergyList.get(i).equals(rList.get(0).getfood_allergy1().get(j)) ) {
					msg = msg + rList.get(0).getfood_allergy1().get(j) +" ";
				}
			}
		}
		
		if(msg.equals("")) {
			msg = "Safe : It's safe you can enjoy! ";
		}else {
			msg = "Warning  : Here are ingredients that cause allergies. Be careful.\nAllergic ingredients:" +msg; 
		}
		rList.get(0).setAlert(msg);
		log.info(msg);
		return rList;
	}
}

