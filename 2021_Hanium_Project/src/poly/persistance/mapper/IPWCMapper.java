package poly.persistance.mapper;


import config.Mapper;
import poly.dto.ProjectsDTO;


@Mapper("PWCMapper")
public interface IPWCMapper {


	ProjectsDTO Search(ProjectsDTO oDTO) throws Exception;

	int New(ProjectsDTO uDTO) throws Exception;
	
	//비밀번호 일치 확인(DB조회하기)
	ProjectsDTO getPWExists(ProjectsDTO uDTO) throws Exception;


}
