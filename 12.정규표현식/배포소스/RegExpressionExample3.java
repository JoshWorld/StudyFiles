/**
 * String Å¬·¡½ºÀÇ Á¤±ÔÇ¥Çö½Ä Áö¿ø ¸Þ¼Òµåµé
 * @author ±è±âÁ¤
 *
 */
public class RegExpressionExample3 {
	
	public static void main(String[] args) {
		String msg1 = "hello world";
		System.out.println(msg1.matches("hello"));          // false
		System.out.println(msg1.matches("hello ([a-z]*)")); // true
	
		System.out.println("------------------------");
		String msg2 = "hello a9ÇÑ";
		System.out.println(msg2.matches("hello ([a-z]*)"));
		System.out.println(msg2.matches("hello ([a-z0-9]*)"));
		System.out.println(msg2.matches("hello ([a-z0-9°¡-ÆR]*)"));
		
		System.out.println("------------------------");
		String msg3 = "gooooooogle";
		System.out.println(msg3.matches("google"));
		System.out.println(msg3.matches("goo*gle"));
		
		System.out.println("------------------------");
		
		// Á¤±Ô½ÄÀ» ±¸ºÐÀÚ·Î »ç¿ëÇÏ¿© ÅäÅ« ºÐ¸®
		String message = "ÅäÅ«1--ÅäÅ«2**ÅäÅ«3..ÅäÅ«4";
		String regex = "(--|\\*\\*|\\.\\.)";
		String[] tokens = message.split(regex);
		for (String token : tokens) {
			System.out.println(token);
		}
		
		// ¹®ÀÚ¿­ Ä¡È¯
		String txt = "gooooooogle goooogle gooogle goooogle";
		System.out.println(txt.replaceAll("goo*gle", "±¸±Û"));
	}
}











