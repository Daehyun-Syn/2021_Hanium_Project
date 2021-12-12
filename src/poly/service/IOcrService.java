package poly.service;

import java.util.List;

import poly.dto.OcrDTO;
import poly.dto.SearchAllerDTO;

public interface IOcrService {

	//플라스크 결과값을 통해 음식 리스트 가져오기;
	List<SearchAllerDTO> getFoodList(SearchAllerDTO saDTO) throws Exception;
}
