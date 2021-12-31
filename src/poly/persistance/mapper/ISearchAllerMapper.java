package poly.persistance.mapper;


import config.Mapper;
import poly.dto.SearchAllerDTO;



@Mapper("SearchAllerMapper")
public interface ISearchAllerMapper {

	SearchAllerDTO getAllergyInfo(SearchAllerDTO uDTO) throws Exception;


}
