package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.ProjectsDTO;
import poly.util.PagingVO;

@Mapper("CommunityMapper")
public interface ICommunityMapper {

	
	void insertCommunity(ProjectsDTO uDTO) throws Exception;
	List<ProjectsDTO> getBoardList() throws Exception;
	ProjectsDTO getBoard(ProjectsDTO rDTO) throws Exception;
	void updateCommunity(ProjectsDTO uDTO) throws Exception;
	void deleteCommunity(ProjectsDTO uDTO) throws Exception;
	int countBoard() throws Exception;
	List<ProjectsDTO> selectBoard(PagingVO vo) throws Exception; 

}
