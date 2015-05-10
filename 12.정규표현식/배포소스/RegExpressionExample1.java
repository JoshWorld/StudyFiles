import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����ǥ���� �˻�
 * @author �����
 *
 */
public class RegExpressionExample1 {

	public static void main(String[] args) {
		// �׽�Ʈ�� ���� ���ڿ� ���
		String[] strings = { "bat", "baby", "bonus", "cA", "ca", "co", "c", "c.", "c0",	"car", "combat", "count", "date", "disc" };

		// c�� �����ϴ� �ҹ��� ����ܾ� ���� ����
		Pattern pattern = Pattern.compile("c[a-z]*"); 
		
		System.out.println("-------- ��ġ�ϴ� �ܾ�� ---------");
		for (String word : strings) {
			Matcher m = pattern.matcher(word);
			if (m.matches()) {
				System.out.println(word + "\t");
			}
		}
	}
}
