package poly.service;

import java.util.ArrayList;

import poly.dto.SearchAllerDTO;

public interface ISearchAllerService {

								  //컨트롤러에서 받아온 값을 넣을 DTO이름을 설정해준다
	SearchAllerDTO getAllergyInfo(SearchAllerDTO uDTO) throws Exception;

	ArrayList<String> pickAllergy(ArrayList<String> uList, ArrayList<String> dList) throws Exception;
}
