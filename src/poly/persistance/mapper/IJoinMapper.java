package poly.persistance.mapper;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("JoinMapper")
public interface IJoinMapper {

	ProjectsDTO checkID(ProjectsDTO uDTO) throws Exception;

	int insertinfo(ProjectsDTO uDTO) throws Exception;
	
	//회원 가입 전 중복 체크하기(DB조회하기)
	ProjectsDTO getUserExists(ProjectsDTO pDTO) throws Exception;


}
