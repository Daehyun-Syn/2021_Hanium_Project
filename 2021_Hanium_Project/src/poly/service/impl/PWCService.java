package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IPWCMapper;
import poly.service.IPWCService;
import poly.util.CmmUtil;

@Service
public class PWCService implements IPWCService {
	
	@Resource(name="PWCMapper")
	private IPWCMapper PWCMapper;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public int Search(ProjectsDTO oDTO) throws Exception {
		int res = 0;
		
		if(oDTO==null) {
			oDTO = new ProjectsDTO();
		}
		
		log.info("컨트롤러에서 받아온 아이디 :" + oDTO.getUser_id());
		
		ProjectsDTO nDTO = new ProjectsDTO();
		
		log.info("아이디가 일치하는지 확인");
		nDTO = PWCMapper.Search(oDTO);
		
		if(nDTO ==null) {
			
			res = 1;
			log.info("없는 아이디 입니다");
		} else {
			res = 2;
			log.info("일치하는 아이디가 있습니다");
		}
		
		return res;
	}
	
	@Override
	public int New(ProjectsDTO wDTO) throws Exception {
		
		if(wDTO==null) {
			wDTO = new ProjectsDTO();
		}
		log.info("변경될(업데이트문) 임시비밀번호 :" + wDTO.getUser_pwd());
		
		//ProjectsDTO qDTO = new ProjectsDTO();
		int res = 0;
		res = PWCMapper.New(wDTO);
		
		return res;
	}
	
	@Override
	public int PWchange(ProjectsDTO uDTO) throws Exception {
		
		//비밀번호 변경 성공: 1, 현재 비밀번호 불일치로 인한 비밀번호 변경 실패: 2, 기타에러 발생:0
		int res = 0;
		
		//controller에서 값이 정상적응로 못 넘어오는 경우를 대비하기위해 사용함
	      if (uDTO == null) {
	         uDTO = new ProjectsDTO();
	         log.info("uDTO가 널로 넘어와서 메모리 올림");
	      }

	      log.info("PWC서비스 :" + uDTO.getUser_pwd());
	    
	    //현재 비밀번호와 일치하는지 조회하기 위해 DB에서 데이터를 조회
	    ProjectsDTO rDTO = PWCMapper.getPWExists(uDTO);
		
	      //mapper 에서 값이 정상적으로 못 넘어오는 경우를 대비하기 위해사용함
	      if(rDTO == null) {
	         rDTO = new ProjectsDTO();
	         log.info("rDTO가 널로 넘어와서 메모리 올림");
	      }
	      
	      log.info(rDTO.getExists_yn());
	      //비밀번호가 일치하지 않을경우, 결과값을 2로 변경하고 더이상 작업을 진행하지않음
	      if(CmmUtil.nvl(rDTO.getExists_yn()).equals("N")){
	         res=2;
	         log.info("비밀번호가 일치하지 않음");
	      //비밀번호 일치확인했으므로 비밀번호 변경 진행함
	      } else {
	         //비밀번호 변경
	    	 log.info("비밀번호변경 시작");
	         int success = PWCMapper.New(uDTO);
	         
	         //db에 데이터가 등록되었다면,
	         if(success > 0) {
	            res=1;
	            log.info("비밀번호 변경 완료");
	         }else {
	             res = 0;
	         }    
	         
	      }
	      return res;
	}
}
