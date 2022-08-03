
package poly.service;


public interface IKakaoService {

	// 로그인 후 사용자 인증 코드를 발급 받기 위한 서비스
	String getAuthcode() throws Exception;

}