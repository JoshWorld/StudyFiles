/**
 * 정규표현식을 활용한 유효성 검증 공통메소드
 * @author 김기정 
 *
 */
public class Validator {
	/**
	 * 입력필드 입력여부 검증
	 * @param value
	 * @return
	 */
	public static boolean isNull(String value){
		return value == null || value.trim().length() == 0;
	}

	/**
	 * 아이디 유효성 검증
	 * @param id
	 * @return
	 */
	public static boolean isValidId(String id){
		return id.matches("^[a-zA-Z0-9]{8,10}$");
	}

	/**
	 * 이메일 유효성 검증
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		return email.matches("^[\\w]+@[\\w]+(\\.[\\w]+)+$");
	}
	
	/**
	 * 전화번호 유효성 검증 
	 * @param number
	 * @return
	 */
	public static boolean isValidPhoneNumber(String number) {
		return number.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$");
	}
	
	/**
	 * 휴대폰번호 유효성 검증
	 * @param number
	 * @return
	 */
	public static boolean isValidMobileNumber(String number) {
		return number.matches("^01(0|1|[6-9])-(\\d{3,4})-\\d{4}$");
	}
	
	/**
	 * 주민등록번호 유효성 검증
	 * @param ssn
	 * @return
	 */
	public static boolean isValidSSN(String ssn) {
		return ssn.matches("\\d{6}\\-[1-4]\\d{6}");
	}
	
	/**
	 * IP주소 유효성 검증
	 * @param ip
	 * @return
	 */
	public static boolean isValidIP(String ip) {
		String pattern = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
		return ip.matches(pattern);
	}
	
	/**
	 * 파일명 유효성 검증
	 * @param ip
	 * @return
	 */
	public static boolean isValidFile(String fileName) {
		return fileName.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
	}

	public static void main(String[] args) {
		System.out.println(Validator.isNull("  "));
		System.out.println(Validator.isValidId("bangry313"));
		System.out.println(Validator.isValidEmail("kj3133k@aa.com"));
		System.out.println(Validator.isValidPhoneNumber("02-1234-1234"));
		System.out.println(Validator.isValidMobileNumber("019-1234-1234"));
		System.out.println(Validator.isValidSSN("680313-1234568"));
		System.out.println(Validator.isValidIP("192.168.34.56"));
		System.out.println(Validator.isValidFile("abc.gif"));
	}
}
