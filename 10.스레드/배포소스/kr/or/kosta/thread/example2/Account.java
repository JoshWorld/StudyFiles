package kr.or.kosta.thread.example2;
/**
 * �ϻ��Ȱ�� ���� ����(��ü)�� �߻�ȭ�� ����Ŭ����
 */
public class Account /*extends Object*/{
	// ��ü�� ������ �Ӽ� ����
	// �������(�ν��Ͻ�����)��
	// ��������
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// ���
	public final static String BANK_NAME = "KOSTA";
		
	// ������ �����ε�(Overloading) : �ߺ�����
	public Account(){
		//super();
		this(null, null, 0, 0);
	}

	public Account(String accountNum, String accountOwner){
		//super();
		this(accountNum, accountOwner, 0, 0);
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney){
		//super();
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter �޼ҵ�
	public String getAccountNum(){
		return accountNum;
	}

	public void setAccountNum(String accountNum){
		this.accountNum = accountNum;
	}

	public String getAccountOwner(){
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner){
		this.accountOwner = accountOwner;
	}

	public int getPasswd(){
		return passwd;
	}

	public void setPasswd(int passwd){
		this.passwd = passwd;
	}

	public void setRestMoney(long restMoney){
		this.restMoney = restMoney;
	}

	public long getRestMoney(){
		return restMoney;
	}

	// ��ü�� �ܺο� �����ϴ� ��� ����
	public long deposit(long money){
		//restMoney = restMoney + money;
		return restMoney += money;
	}

	public long withdraw(long money){
		return restMoney -= money;
	}

	boolean checkPasswd(int pw){
		return passwd == pw;
	}

	// �Ӽ�(����)�� ���ڿ��� ��ȯ
	// Object�� toString() ������
	public String toString(){
		return accountNum+"\t"+accountOwner+"\t*****\t"+ restMoney;
	}
	
	// ������
	public boolean equals(Object obj){
		if(obj instanceof Account){
			return toString().equals(obj.toString());
		}
		return false;
	}
}
