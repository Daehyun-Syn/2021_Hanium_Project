package poly.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.service.IKakaoService;


@Service("kakaoService")
public class KakaoService implements IKakaoService {
	
	private Logger log = Logger.getLogger(getClass());

	// =========================================== 로그인 후 사용자 인증 코드 발급을 위한 코드 ======================================
	@Override
	public String getAuthcode() throws Exception {
		
		final String RESTAPI_KEY = ""; //우리 집 열쇠
		final String Redirect_URI = ""; // 카카오에 등록한 요청 url
		// 카카오 개발자 센터에 있는 Sample Request 메뉴얼 참고
		String SampleRequest = ""; //카카오 접속 앤드포인트 url
		String forKakao = SampleRequest + RESTAPI_KEY + "&redirect_uri" + Redirect_URI + "&response_type=code"; //카카오로 최종적으로 보낼 주소
	
		return forKakao;
	}
	
	// ===========================================

}