 package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.ProjectsDTO;
import poly.service.ICommunityService;
import poly.util.CmmUtil;
import poly.util.PagingVO;

@Controller("communityController")
public class communityController {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Resource(name = "CommunityService")
	private ICommunityService CommunityService;
	
	
	
	// =========================================== 커뮤니티 게시판 글쓰기 페이지 출력
		@RequestMapping(value="testt")
		public String tes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			log.info("커뮤니티 게시판 글쓰기 페이지 출력");
			if (session.getAttribute("id") == null) {
				String url = "/user/login.do";
				String msg = "Please log in.";
				request.setAttribute("url", url);
				request.setAttribute("msg", msg);
				return "/redirect";
			}
			return "/Test";
		}
		
	// =========================================== 커뮤니티 게시판 리스트 페이지 출력
		@RequestMapping(value = "community/boardlist")
		public String boardList(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage, @RequestParam(value="cntPerPage", 
					required=false)String cntPerPage,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
			if (session.getAttribute("id") == null) {
				String url = "/user/login.do";
				String msg = "Please log in.";
				request.setAttribute("url", url);
				request.setAttribute("msg", msg);
				return "/redirect";
			}
			int total = CommunityService.countBoard();
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "5";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "5";
			}
			log.info("게시판 글수 : " + total);
			vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			List<ProjectsDTO> rList = CommunityService.selectBoard(vo);
			model.addAttribute("paging", vo);
			model.addAttribute("rList", rList);
			return "community/boardlist";
		}
	
	// =========================================== 커뮤니티 게시판 글쓰기 페이지 출력
	@RequestMapping(value="community/boardwrite")
	public String boardwrite(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info("커뮤니티 게시판 글쓰기 페이지 출력");
		if (session.getAttribute("id") == null) {
			String url = "/user/login.do";
			String msg = "Please log in.";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			return "/redirect";
		}
		return "/community/boardwrite";
	}
	
	// ========================================= 커뮤니티 게시판 게시글작성 로직
	@RequestMapping(value = "community/boardwrite/logic")
	public String insertCommunity(HttpServletRequest request, ModelMap model) throws Exception {
		log.info("게시글작성 로직 실행");

		String title = request.getParameter("BOARD_TITLE");
		String writer = request.getParameter("BOARD_WRITER");
		String contents = request.getParameter("BOARD_CONTENTS");
		String id = request.getParameter("id");
		
		log.info(title);
		log.info(writer);
		log.info(contents);
		log.info(id);
		
		ProjectsDTO aDTO = new ProjectsDTO();

		aDTO.setBoard_title(title);
		aDTO.setBoard_writer(writer);
		aDTO.setBoard_contents(contents);
		aDTO.setUser_id(id);

		int res = CommunityService.insertCommunity(aDTO);

		if (res == 0) {
			log.info("게시글 작성 실패");
		} else if (res == 1) {
			log.info("게시글 작성 성공");
		}
		model.addAttribute("res", String.valueOf(res));	
		
		return "/alert/boardwriteAlert";
		}
	
	// ========================================= 커뮤니티 게시판 상세 페이지 출력
	@RequestMapping(value="community/boardsee")
	public String boardsee(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) throws Exception {
		log.info("커뮤니티 게시판 상세 페이지 출력");
		if (session.getAttribute("id") == null) {
			String url = "/user/login.do";
			String msg = "Please log in.";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			return "/redirect";
		}
		String no = CmmUtil.nvl(request.getParameter("number").toString());
		//게시판 페이지에서 number를 잘 받아왔는지 찍어보는 로그
		log.info(no);
		
		//게시판 페이지에서 받아온 number값을 DTO에 넣어서 DB로 전송
		ProjectsDTO pDTO = new ProjectsDTO();
		pDTO.setBoard_seq(no);
		
		ProjectsDTO rDTO = new ProjectsDTO();
		rDTO = CommunityService.getBoard(pDTO);
		pDTO=null;
		
		//rDTO 널 처리
		if(rDTO==null) {
			rDTO = new ProjectsDTO();
			log.info("rDTO 널처리");
		}
		
		log.info(rDTO==null);
		
		model.addAttribute("rDTO",rDTO);
		log.info(this.getClass().getName());
		return "/community/boardsee";
	}
	
	// ========================================= 게시판 글 수정 페이지 출력
		@RequestMapping(value="community/boardupdate")
		public String boardupdate(HttpServletRequest request, ModelMap model) throws Exception {
			
			String no = CmmUtil.nvl(request.getParameter("number").toString());
			//게시판 상세 페이지에서 number를 잘 받아왔는지 찍어보는 로그
			log.info(no);
			
			//게시판 상세 페이지에서 받아온 number값을 DTO에 넣어서 DB로 전송
			ProjectsDTO pDTO = new ProjectsDTO();
			pDTO.setBoard_seq(no);
			
			ProjectsDTO rDTO = new ProjectsDTO();
			
			rDTO = CommunityService.getBoard(pDTO);
			//rDTO 널 처리
			if(rDTO==null) {
				rDTO = new ProjectsDTO();
			}
			
			pDTO=null;
			
			model.addAttribute("rDTO",rDTO);
			
			return "/community/boardupdate";
		}
		
		// ========================================= 게시글 수정 로직
		@RequestMapping(value = "community/boardupdate/logic")
		public String boardUpdateLogic(HttpServletRequest request, ModelMap model) throws Exception {
			log.info("게시글수정 로직 실행");

			String seq = CmmUtil.nvl(request.getParameter("number").toString());
			String title = request.getParameter("BOARD_TITLE");
			String writer = request.getParameter("BOARD_WRITER");
			String contents = request.getParameter("BOARD_CONTENTS");
			
			log.info(seq);
			log.info(title);
			log.info(writer);
			log.info(contents);

			ProjectsDTO aDTO = new ProjectsDTO();
			aDTO.setBoard_seq(seq);
			aDTO.setBoard_title(title);
			aDTO.setBoard_writer(writer);
			aDTO.setBoard_contents(contents);
		

			int res = CommunityService.updateCommunity(aDTO);

			
			if (res == 0) {
				log.info("게시글 수정 실패");
			} else if (res == 1) {
				log.info("게시글 수정 성공");
			}
			
			model.addAttribute("res", String.valueOf(res));	
			return "/alert/boardupdateAlert";
		}
		
		// ========================================= 게시글 삭제 로직
				@RequestMapping(value = "community/boarddelete")
				public String boarddelete(HttpServletRequest request, ModelMap model) throws Exception {
					log.info("게시글삭제 로직 실행");

					String seq = CmmUtil.nvl(request.getParameter("number").toString());
					log.info(seq);
					
					ProjectsDTO aDTO = new ProjectsDTO();
					aDTO.setBoard_seq(seq);
					
					int res = CommunityService.deleteCommunity(aDTO);

					
					if (res == 0) {
						log.info("게시글 삭제 실패");
					} else if (res == 1) {
						log.info("게시글 삭제 성공");
					}
					
					model.addAttribute("res", String.valueOf(res));	
					return "/alert/boarddeleteAlert";
				}
}