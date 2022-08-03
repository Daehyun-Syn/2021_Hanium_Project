package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.ILoginMapper;
import poly.service.ILoginService;
import poly.util.CmmUtil;

@Service("LoginService")
public class LoginService implements ILoginService {
   
   @Resource(name="LoginMapper")
   private ILoginMapper LoginMapper;

   private Logger log = Logger.getLogger(getClass());
   
   
   @Override
   public int Loginpage(ProjectsDTO mDTO) throws Exception {
	   
	   if(mDTO==null) {
		   mDTO = new ProjectsDTO();
		   log.info("mDTO를 강제로 메모리에 올림");
	   }
      
      // 로그인 성공 : 1 , 실패 : 0
      int res = 0;
      
      
      ProjectsDTO uDTO = LoginMapper.checkLogin(mDTO);
   
      
      if (uDTO==null) {
         uDTO = new ProjectsDTO();
      }
   
      if(CmmUtil.nvl(uDTO.getUser_id()).length()>0) {
         
         res = 1;
      }
      
      
      return res;
   }


@Override
public List<ProjectsDTO> getAllergy(ProjectsDTO mDTO) throws Exception {
	
	List<ProjectsDTO> rList = LoginMapper.getAllergy(mDTO);
	
	return rList;
}


}