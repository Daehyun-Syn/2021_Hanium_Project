package poly.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import poly.dto.OcrDTO;
import poly.dto.SearchAllerDTO;
import poly.persistance.mapper.IMainMapper;
import poly.persistance.mapper.IOcrMapper;
import poly.service.IOcrService;
import poly.util.CmmUtil;


@Service("OcrService")
public class OcrService implements IOcrService {
	
	@Resource(name="OcrMapper")
	private IOcrMapper OcrMapper;

	//로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public List<SearchAllerDTO> getFoodList(SearchAllerDTO saDTO) throws Exception {
		List<SearchAllerDTO> rList= OcrMapper.getFoodList(saDTO);
		log.info(rList.size());
		return rList;
	}
	

}
