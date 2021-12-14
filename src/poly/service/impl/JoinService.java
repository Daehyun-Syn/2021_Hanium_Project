package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IJoinMapper;
import poly.service.IJoinService;
import poly.util.CmmUtil;

@Service("JoinService")
public class JoinService implements IJoinService {

	@Resource(name = "JoinMapper")
	private IJoinMapper JoinMapper;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public int insertinfo(ProjectsDTO uDTO) throws Exception {
		
		//회원가입 성공: 1, 아이디 중복으로 인한 가입취소: 2, 기타에러 발생:0
		int res = 0;
		
		//controller에서 값이 정상적응로 못 넘어오는 경우를 대비하기위해 사용함
	      if (uDTO == null) {
	         uDTO = new ProjectsDTO();
	      }

	      log.info("서비스 :" + uDTO.getUser_id());
	    
	    //회원 가입 중복방지를 위해 DB에서 데이터를 조회
	    ProjectsDTO rDTO = JoinMapper.getUserExists(uDTO);
		
	      //mapper 에서 값이 정상적으로 못 넘어오는 경우를 대비하기 위해사용함
	      if(rDTO == null) {
	         rDTO = new ProjectsDTO();
	      }
	      log.info(rDTO.getExists_yn());
	      //중복된 회원 정보가 있는 경우, 결과값을 2로 변경하고 더이상 작업을 진행하지않음
	      if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")){
	         res=2;
	      //회원가입이 중복이 아니므로 회원가입 진행함
	      } else {
	         //회원가입
	    	 log.info("회원가입 시작");
	         int success = JoinMapper.insertinfo(uDTO);
	         
	         //db에 데이터가 등록되었다면,
	         if(success > 0) {
	            res=1;
	            log.info("회원가입 완료");
	         }else {
	             res = 0;
	         }    
	         
	      }
	      return res;
	}
}
	      
