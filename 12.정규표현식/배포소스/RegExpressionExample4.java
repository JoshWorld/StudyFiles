/**
 * 정규표현식을 이용한 유효성 검증
 * @author 김기정
 *
 */
public class RegExpressionExample4 {

	public static void main(String[] args) {
		String[] emails = { "test@abc.com", "aaaa", "abcd@", "abc@mydomain", "bangry@xxx.co.kr" };
		
		// 이멜형식 검증을 위한 정규표현식
		//String pattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$";
//		String pattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[\\w]+)+$";
		String pattern = "^[\\w]+@[\\w]+(\\.[\\w]+)+$";
		
		for (String email : emails) {
			System.out.println(email + " : " + email.matches(pattern));
		}
	}
}








