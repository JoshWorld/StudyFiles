/**
 * ����ǥ������ Ȱ���� ��ȿ�� ���� ����޼ҵ�
 * @author ����� 
 *
 */
public class Validator {
	/**
	 * �Է��ʵ� �Է¿��� ����
	 * @param value
	 * @return
	 */
	public static boolean isNull(String value){
		return value == null || value.trim().length() == 0;
	}

	/**
	 * ���̵� ��ȿ�� ����
	 * @param id
	 * @return
	 */
	public static boolean isValidId(String id){
		return id.matches("^[a-zA-Z0-9]{8,10}$");
	}

	/**
	 * �̸��� ��ȿ�� ����
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		return email.matches("^[\\w]+@[\\w]+(\\.[\\w]+)+$");
	}
	
	/**
	 * ��ȭ��ȣ ��ȿ�� ���� 
	 * @param number
	 * @return
	 */
	public static boolean isValidPhoneNumber(String number) {
		return number.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$");
	}
	
	/**
	 * �޴�����ȣ ��ȿ�� ����
	 * @param number
	 * @return
	 */
	public static boolean isValidMobileNumber(String number) {
		return number.matches("^01(0|1|[6-9])-(\\d{3,4})-\\d{4}$");
	}
	
	/**
	 * �ֹε�Ϲ�ȣ ��ȿ�� ����
	 * @param ssn
	 * @return
	 */
	public static boolean isValidSSN(String ssn) {
		return ssn.matches("\\d{6}\\-[1-4]\\d{6}");
	}
	
	/**
	 * IP�ּ� ��ȿ�� ����
	 * @param ip
	 * @return
	 */
	public static boolean isValidIP(String ip) {
		String pattern = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
		return ip.matches(pattern);
	}
	
	/**
	 * ���ϸ� ��ȿ�� ����
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
