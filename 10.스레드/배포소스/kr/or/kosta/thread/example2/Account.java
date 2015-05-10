package kr.or.kosta.thread.example2;
/**
 * 일상생활의 은행 계좌(객체)를 추상화한 구상클래스
 */
public class Account /*extends Object*/{
	// 객체가 가지는 속성 정의
	// 멤버변수(인스턴스변수)들
	// 정보은닉
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// 상수
	public final static String BANK_NAME = "KOSTA";
		
	// 생성자 오버로딩(Overloading) : 중복정의
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

	// setter/getter 메소드
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

	// 객체가 외부에 제공하는 기능 정의
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

	// 속성(정보)을 문자열로 반환
	// Object의 toString() 재정의
	public String toString(){
		return accountNum+"\t"+accountOwner+"\t*****\t"+ restMoney;
	}
	
	// 재정의
	public boolean equals(Object obj){
		if(obj instanceof Account){
			return toString().equals(obj.toString());
		}
		return false;
	}
}
