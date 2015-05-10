import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규표현식 검색
 * @author 김기정
 *
 */
public class RegExpressionExample1 {

	public static void main(String[] args) {
		// 테스트를 위한 문자열 목록
		String[] strings = { "bat", "baby", "bonus", "cA", "ca", "co", "c", "c.", "c0",	"car", "combat", "count", "date", "disc" };

		// c로 시작하는 소문자 영어단어 패턴 생성
		Pattern pattern = Pattern.compile("c[a-z]*"); 
		
		System.out.println("-------- 일치하는 단어들 ---------");
		for (String word : strings) {
			Matcher m = pattern.matcher(word);
			if (m.matches()) {
				System.out.println(word + "\t");
			}
		}
	}
}
