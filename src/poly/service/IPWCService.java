package poly.service;

import poly.dto.ProjectsDTO;

public interface IPWCService {

	int New(ProjectsDTO uDTO)throws Exception;

	int Search(ProjectsDTO oDTO) throws Exception;
	
	int PWchange(ProjectsDTO uDTO) throws Exception;
	

}
