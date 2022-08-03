package poly.persistance.mapper;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("MainMapper")
public interface IMainMapper {

	ProjectsDTO getUserInfo(ProjectsDTO pDTO) throws Exception;

}
