package kr.or.kosta.thread.example2;


/**
 * ���� ���� �������� ��Ʈ��ũ ����� ���� ���� ���� ó�� ���
 * @author �����
 *
 */
public class ATM {
	/** �׽�Ʈ�� ���� �ӽ� ���� */
	Account account = new Account("111-222-333", "��׸���������", 1111, 100000);
	
	public ATM(){}
	
	/** �Ա� */
	public void depositMoney(String accountNum, int passwd, long money, String user) throws Exception{
		System.out.println("***** " + user + " �Ա� ���� *****");
		if(!checkAccountNum(accountNum)){
			throw new Exception("�������� �ʴ� �����Դϴ�.");
		}
		if(!checkPasswd(passwd)){
			throw new Exception("��й�ȣ �����Դϴ�.");
		}
		
		// ���� �������� ��ſ� �ణ�� �ð��� �ҿ�ȴ� ����..
		Thread.sleep(300);
		account.deposit(money);
		Thread.sleep(300);
		System.out.println(user+" �Ա� �� �ܾ� : " + account.getRestMoney());
		System.out.println("***** " + user + " �Ա� �Ϸ� *****");
	}
	
	/** ��� */
	public  /*synchronized*/ void withdrawMoney(String accountNum, int passwd, long money, String user) throws Exception{
		
		//synchronized (account) {
			System.out.println("***** " + user + " ��� ���� *****");
			
			if(!checkAccountNum(accountNum)){
				throw new Exception("�������� �ʴ� �����Դϴ�.");
			}
			if(!checkPasswd(passwd)){
				throw new Exception("��й�ȣ �����Դϴ�.");
			}
			if(money > account.getRestMoney()){
				throw new Exception("�ܾ��� �����մϴ�.");
			}
			
			// ���� �������� ��ſ� �ణ�� �ð��� �ҿ�ȴ� ����..
			Thread.sleep(300);
			account.withdraw(money);
			
			Thread.sleep(300);
			System.out.println(user+" ��� �� �ܾ� : " + account.getRestMoney());
			System.out.println("***** " + user + " ��� �Ϸ� *****");
	//	}
	}

	private boolean checkAccountNum(String accountNum) throws Exception{
		// ���� �������� ��ſ� �ణ�� �ð��� �ҿ�ȴ� ����..
		Thread.sleep(300);
		return accountNum.equals(account.getAccountNum());
	}
	
	private boolean checkPasswd(int passwd) throws Exception{
		// ���� �������� ��ſ� �ణ�� �ð��� �ҿ�ȴ� ����..
		Thread.sleep(300);
		return passwd == account.getPasswd();
	}

}
