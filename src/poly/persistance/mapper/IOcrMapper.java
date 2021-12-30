package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.SearchAllerDTO;

@Mapper("OcrMapper")
public interface IOcrMapper {

	List<SearchAllerDTO> getFoodList(SearchAllerDTO saDTO) throws Exception;



}
