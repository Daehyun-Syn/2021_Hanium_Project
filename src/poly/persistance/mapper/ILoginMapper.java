package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("LoginMapper")
public interface ILoginMapper {

	
	ProjectsDTO checkLogin(ProjectsDTO mDTO) throws Exception;

	List<ProjectsDTO> getAllergy(ProjectsDTO mDTO) throws Exception;

	
}
