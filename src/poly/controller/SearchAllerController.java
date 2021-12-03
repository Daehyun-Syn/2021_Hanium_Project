/*
 * package poly.controller;
 * 
 * import java.util.ArrayList;
 * 
 * import java.util.Arrays; import java.util.List;
 * 
 * import javax.annotation.Resource; import
 * javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpSession;
 * 
 * import org.apache.log4j.Logger; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import poly.dto.SearchAllerDTO; import poly.service.ISearchAllerService;
 * import poly.util.CmmUtil;
 * 
 * @Controller("SearchAllerController") public class SearchAllerController {
 * 
 * @Resource(name = "SearchAllerService") private ISearchAllerService
 * SearchAllerService; private Logger log = Logger.getLogger(getClass());
 * 
 * @RequestMapping(value = "resultProc")
 * 
 * @SuppressWarnings("unchecked") // 비확인 경고를 제거해주는 어노테이션. 로직 실행에 영향을 주지 않음
 * public String resultProc(HttpSession session, HttpServletRequest request,
 * ModelMap model) throws Exception {
 * 
 * String msg = "";
 * 
 * // 웹에서 사용자가 확인하고 싶은 음식 이름을 받아옴 String Foodname =
 * CmmUtil.nvl(request.getParameter("search")); log.info("웹에서 받아온 값: " +
 * Foodname);
 * 
 * // 알러지테이블에서 정보를 받아오기 위한 DTO를 선언 및 메모리에 올리기 SearchAllerDTO rDTO = new
 * SearchAllerDTO(); SearchAllerDTO uDTO = new SearchAllerDTO(); // 알러지테이블에서 조회를
 * 하기 위한 데이터를 DTO에 셋팅 rDTO.setFood_name(Foodname);
 * 
 * // food_name을 통해 db에 저장된 해당 음식의 정보를 담아옴 uDTO =
 * SearchAllerService.getAllergyInfo(rDTO);
 * 
 * if (uDTO == null) { uDTO = new SearchAllerDTO();
 * log.info("uDTO 값이 null이라 강제로 메모리에 올립니다."); }
 * 
 * log.info("DB에서 받아온 칼로리: " + uDTO.getFood_kcal()); log.info("DB에서 받아온 음식명: " +
 * uDTO.getFood_name()); log.info("DB에서 받아온 원재료: " + uDTO.getFood_material());
 * log.info("DB에서 받아온 알레르기정보: " + uDTO.getFood_allergy());
 * 
 * // db에서 담아온 음식의 알러지 정보를 "," 를 기준으로 split으로 잘라 리스트에 담음 ArrayList<String>
 * food_allerList = new
 * ArrayList<String>(Arrays.asList(uDTO.getFood_allergy().split(", "))); // 사용자의
 * 알러지 정보가 담긴 리스트를 가져옴 ArrayList<String> UserAllerList = (ArrayList<String>)
 * session.getAttribute("UserAllerList"); log.info("db에서 가져온 음식 알러지 정보 : " +
 * food_allerList); log.info("사용자 알러지 정보 리스트 : " + UserAllerList);
 * 
 * if (UserAllerList == null) { UserAllerList = new ArrayList<>();
 * log.info("알러지 리스트를 잘못 받아옴. 강제로 메모리에 올림"); }
 * 
 * log.info("두가지 리스트를 서비스에 넘김"); // db에서 넘어온 알러지정보와 사용자 알러지정보를 토대로 rList로 사용자가
 * 섭취하지 말아야 할 알러지 정보를 리스트에 담아옴 ArrayList<String> rList =
 * SearchAllerService.pickAllergy(food_allerList, UserAllerList);
 * log.info("결과값 리스트를 받아옴");
 * 
 * if (rList == null) { rList = new ArrayList<String>();
 * log.info("로직 처리 중 오류 발생. 널처리"); msg = "오류가 발생하였습니다."; } else if (rList.size()
 * == 0) { rList = new ArrayList<String>(); msg = "안전한 식품입니다.";
 * log.info("리스트 크기가 0이므로 안전식품으로 간주"); } else { msg = "섭취에 주의해야 할 식품입니다.";
 * log.info("rList의 첫번째 값 : " + rList.get(0)); }
 * 
 * // 음식정보, 알러지 교집합리스트, 메시지를 뷰에 넘김 model.addAttribute("uDTO", uDTO);
 * model.addAttribute("rList", rList); model.addAttribute("msg", msg);
 * 
 * return "/Result";
 * 
 * } }
 */