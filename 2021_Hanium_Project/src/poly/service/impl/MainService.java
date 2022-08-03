package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IMainMapper;
import poly.service.IMainService;

 @Service("MainService")
public class MainService implements IMainService {
	 
	 private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="MainMapper")
	private IMainMapper MainMapper;

	@Override
	public ProjectsDTO getUserInfo(ProjectsDTO pDTO) throws Exception {
		
		if(pDTO==null) {
			pDTO = new ProjectsDTO();
			log.info("pDTO에 값이 없어서 강제로 메모리에 올림");
		}
		
		return MainMapper.getUserInfo(pDTO);
	}
	


}
