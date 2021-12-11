package poly.service;

import java.util.List;

import poly.dto.ProjectsDTO;
import poly.util.PagingVO;

public interface ICommunityService {

	int insertCommunity(ProjectsDTO uDTO) throws Exception;
	List<ProjectsDTO> getBoardList() throws Exception;
	ProjectsDTO getBoard(ProjectsDTO pDTO) throws Exception;
	int updateCommunity(ProjectsDTO aDTO) throws Exception;
	int deleteCommunity(ProjectsDTO aDTO) throws Exception;
	int countBoard() throws Exception;
	List<ProjectsDTO> selectBoard(PagingVO vo) throws Exception;
}
