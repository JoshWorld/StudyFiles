import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규표현식 치환
 * @author 김기정
 *
 */
public class RegExpressionExample2 {
	
	public static void main(String[] args) {
		String message = "A broken hand works, but not a broken heart.";
		
		String regex = "broken";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(message);
		
		
		// broken을 drunken으로 치환
		String replacedMessage = matcher.replaceAll("drunken");
		
		System.out.println("원본 문자열: " + message);
		System.out.println("치환 문자열: " + replacedMessage);
	}
}
