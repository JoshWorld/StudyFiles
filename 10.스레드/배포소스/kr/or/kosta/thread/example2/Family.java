package kr.or.kosta.thread.example2;

public class Family extends Thread{
	private ATM atm;
	public Family(String name){
		super(name);
	}
	
	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}
	
	/** 동기화 문제 발생 */
	public void run() {
		// 스레드에서 공유계좌의 금액 출금
		try {
			atm.withdrawMoney("111-222-333", 1111, 10000, getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** synchronized{} 블럭을 이용한 동기화 문제 해결 */
	/*
	public void run() {
		// 스레드에서 공유계좌의 금액 출금
		try {
			synchronized (atm.account) {
				atm.withdrawMoney("111-222-333", 1111, 10000, getName());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	/** 동기화 처리 시 발생할 수 있는 스레드 기아 및 데드락 문제 */
	/*
	public void run() {
		// 스레드에서 공유계좌의 금액 출금
		try {
			synchronized (atm.account) {
				for(int i=0; i<10; i++){
					atm.withdrawMoney("111-222-333", 1111, 10000, getName());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	/** wait(), notify()/notifyAll() 메소드를 이용한 기아 및 데드락 문제 해결*/
	/*
	public void run() {
		// 스레드에서 공유계좌의 금액 출금
		try {
			synchronized (atm.account) {
				for(int i=0; i<10; i++){
					atm.withdrawMoney("111-222-333", 1111, 10000, getName());
					atm.account.notifyAll();
					//atm.account.wait();
					atm.account.wait(3000);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
}
