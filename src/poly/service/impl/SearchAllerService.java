package poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.SearchAllerDTO;
import poly.persistance.mapper.ISearchAllerMapper;
import poly.service.ISearchAllerService;

@Service("SearchAllerService")
public class SearchAllerService implements ISearchAllerService {

	@Resource(name = "SearchAllerMapper")
	private ISearchAllerMapper SearchAllerMapper;
	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override // 컨트롤러에서 받아온 값을 넣을 DTO 이름을 지정
	public SearchAllerDTO getAllergyInfo(SearchAllerDTO uDTO) throws Exception {

		if (uDTO == null) {
			uDTO = new SearchAllerDTO();
			log.info("널처리");
		}

		log.info("OcrService: 이미지 인식 서비스 시작");

		uDTO.setFood_name(uDTO.getFood_name());
		// uDTO에 넣어서 매퍼로 보냄
		SearchAllerDTO rDTO = SearchAllerMapper.getAllergyInfo(uDTO);

		if (rDTO == null) {
			rDTO = new SearchAllerDTO();
			log.info("입력하신 음식과 일치하는 정보가 없습니다.");
		} else {
			log.info("Food_name : " + rDTO.getFood_name());
		}

		return rDTO;
	}

	@Override
	public ArrayList<String> pickAllergy(ArrayList<String> dList, ArrayList<String> uList) throws Exception {

		log.info(this.getClass().getName());

		if (uList == null) {
			uList = new ArrayList<String>();
			log.info("uList 널처리");
		}
		if (dList == null) {
			dList = new ArrayList<String>();
			log.info("dList 널처리");
		}

		ArrayList<String> result = new ArrayList<>();

		HashMap<String, Integer> hm = new HashMap<>();

		// 유저의 알러지 정보가 key : allergyname, value : 1의 형태로 저장됨
		for (String user : uList) {
			// getorDefault(a, b)는 해쉬맵에 a를 키로 갖는 밸류값이 있으면 그 밸류값을 가져오고(get), 없으면 0을
			// 불러옴(Default)

			hm.put(user, hm.getOrDefault(user, 0) + 1);
			log.info("사용자 알러지 " + user + " 의 밸류 : " + hm.get(user));
		}
		// 음식의 알러지 정보를 키밸류로 저장. 앞서 등록됐던 알러지에 대한 밸류는 호출받아 -1됐으므로 0이 됨. dList에만 있는 알러지명에
		// 대한 밸류는 -1이 됨. uList에만 있는 알러지명에 대한 밸류는 그대로 1.
		for (String food : dList) {
			hm.put(food, hm.getOrDefault(food, 0) - 1);
			log.info("음식db 알러지 " + food + " 의 밸류 : " + hm.get(food));
		}
		// 음식에도 있고 유저에게도 있는 알러지명에 대한 밸류가 0이면서 유저에게 섭취에 유의하라고 알려줘야 할 항목임.
		// 따라서 해쉬맵의 키값들을 통해 밸류를 차례로 호출하면서 0인 것을 결과리스트에 추가
		for (String key : hm.keySet()) {
			log.info("key : " + key + " value : " + hm.get(key));
			if (hm.get(key) == 0) {
				result.add(key);
			}
		}

		log.info(this.getClass().getName());
		return result;
	}

}
