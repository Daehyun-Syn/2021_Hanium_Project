package poly.dto;


public class ProjectsDTO {

	private String user_id;
	private String user_pwd;
	private String user_pwdck;
	private String user_name;
	private String tomail;
	private String rownum;
	private String user_date;
	private String user_gender;
	private String user_allergy;
	private String user_lang;
	private String board_title;
	private String board_writer;
	private String board_contents;
	private String board_seq;
	private String board_regdate;
	private String reg_id;
	private String reg_dt;
	private String chg_id;
	private String chg_dt;
	
	// 회원가입시, 중복가입을 방지 위해 사용할 변수
	// DB를 조회해서 회원이 존재하면 Y값을 반환함
	// DB테이블에 존재하지 않는 가상의 컬럼(ALIAS)
	private String exists_yn;
	
	
	public String getUser_pwdck() {
		return user_pwdck;
	}
	public void setUser_pwdck(String user_pwdck) {
		this.user_pwdck = user_pwdck;
	}
	public String getUser_lang() {
		return user_lang;
	}
	public void setUser_lang(String user_lang) {
		this.user_lang = user_lang;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getChg_id() {
		return chg_id;
	}
	public void setChg_id(String chg_id) {
		this.chg_id = chg_id;
	}
	public String getChg_dt() {
		return chg_dt;
	}
	public void setChg_dt(String chg_dt) {
		this.chg_dt = chg_dt;
	}
	public String getExists_yn() {
		return exists_yn;
	}
	public void setExists_yn(String exists_yn) {
		this.exists_yn = exists_yn;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public String getTomail() {
		return tomail;
	}
	public void setTomail(String tomail) {
		this.tomail = tomail;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_allergy() {
		return user_allergy;
	}
	public void setUser_allergy(String user_allergy) {
		this.user_allergy = user_allergy;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	
	
}
