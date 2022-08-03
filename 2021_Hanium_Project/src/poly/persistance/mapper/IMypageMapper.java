package poly.persistance.mapper;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("MypageMapper")
public interface IMypageMapper {



	int updateAller(ProjectsDTO uDTO) throws Exception;



}
