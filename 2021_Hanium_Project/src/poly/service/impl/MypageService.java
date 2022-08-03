package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IMypageMapper;
import poly.service.IMypageService;

@Service("MypageService")
public class MypageService implements IMypageService {

	@Resource(name = "MypageMapper")
	private IMypageMapper MypageMapper;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public int updateAller(ProjectsDTO uDTO) throws Exception {
		
		//개인정보 수정 성공: 1, 기타에러 발생:0
		int res = 0;
		
		//controller에서 값이 정상적응로 못 넘어오는 경우를 대비하기위해 사용함
	      if (uDTO == null) {
	         uDTO = new ProjectsDTO();
	      }

	      log.info("서비스 :" + uDTO.getUser_id());
	    
	   
	         //마이페이지 수정
	    	 log.info("마이페이지_서비스 : 업데이트 로직 실행");
	         int success = MypageMapper.updateAller(uDTO);
	         
	         //db에 데이터가 등록되었다면,
	         if(success > 0) {
	            res=1;
	            log.info("개인정보 수정 완료");
	         }else {
	             res = 0;
	         }    
	         
	      
	      return res;
	}
}
	      
