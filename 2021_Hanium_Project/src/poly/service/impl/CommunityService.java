package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.ICommunityMapper;
import poly.service.ICommunityService;
import poly.util.PagingVO;


@Service("CommunityService")
public class CommunityService implements ICommunityService {

	@Resource(name = "CommunityMapper")
	private ICommunityMapper CommunityMapper;
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public int insertCommunity(ProjectsDTO uDTO) throws Exception {
		int res = 0;
		
		if(uDTO ==null) {
			log.info("게시글 입력 실패");
			uDTO = new ProjectsDTO();
			log.info("DTO에 값이 없어 메모리에 강제로 올렸습니다.");
			
		} else {
			log.info("게시글 입력 로직 작동");
			CommunityMapper.insertCommunity(uDTO);
			res = 1;
			log.info("게시글 입력 완료");
			
			
		}
		return res;
	}
	
	@Override
	public List<ProjectsDTO> getBoardList() throws Exception {
		List<ProjectsDTO> rlist = new ArrayList<>();
		
		rlist = CommunityMapper.getBoardList();
		
		if(rlist==null) {
			//rlist가 null 일 경우 오류 방지를 위해 강제로 메모리에 LIST 를 올림 
			rlist = new ArrayList<>();
			log.info("rlist == null");
		}
		else {
			log.info("success");
		}
		
		return rlist;
	}
	
	@Override
	public ProjectsDTO getBoard(ProjectsDTO rDTO) throws Exception {
		
		if(rDTO==null) {
			rDTO = new ProjectsDTO();
			log.info("rDTO == null");
		}
		
		ProjectsDTO pDTO = new ProjectsDTO();
		pDTO = CommunityMapper.getBoard(rDTO);
		
		if(pDTO==null) {
			pDTO = new ProjectsDTO();
			log.info("pDTO == null");
		}
		else {
			log.info("게시판 상세 불러오기 성공");
		}
		
		return pDTO;
	}
	
	@Override
	public int updateCommunity(ProjectsDTO uDTO) throws Exception {
		int res = 0;
		
		if(uDTO ==null) {
			log.info("게시글 수정 실패");
			ProjectsDTO zDTO = new ProjectsDTO();
			log.info("DTO에 값이 없어 메모리에 강제로 올렸습니다.");
			
		} else {
			log.info("게시글 수정 로직 작동");
			CommunityMapper.updateCommunity(uDTO);
			res = 1;
			log.info("게시글 수정 완료");
			
			
		}
		return res;
	}
	
	@Override
	public int deleteCommunity(ProjectsDTO uDTO) throws Exception {
		int res = 0;
		
		if(uDTO ==null) {
			log.info("게시글 삭제 실패");
			 uDTO = new ProjectsDTO();
			log.info("DTO에 값이 없어 메모리에 강제로 올렸습니다.");
			
		} else {
			log.info("게시글 삭제 로직 작동");
			CommunityMapper.deleteCommunity(uDTO);
			res = 1;
			log.info("게시글 삭제 완료");
			
			
		}
		return res;
	}
	
	@Override
	public int countBoard() throws Exception {
		// TODO Auto-generated method stub
		return CommunityMapper.countBoard();
	}

	@Override
	public List<ProjectsDTO> selectBoard(PagingVO vo) throws Exception {
		return CommunityMapper.selectBoard(vo);
	}
}
