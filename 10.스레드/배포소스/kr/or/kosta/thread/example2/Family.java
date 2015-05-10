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
	
	/** ����ȭ ���� �߻� */
	public void run() {
		// �����忡�� ���������� �ݾ� ���
		try {
			atm.withdrawMoney("111-222-333", 1111, 10000, getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** synchronized{} ���� �̿��� ����ȭ ���� �ذ� */
	/*
	public void run() {
		// �����忡�� ���������� �ݾ� ���
		try {
			synchronized (atm.account) {
				atm.withdrawMoney("111-222-333", 1111, 10000, getName());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	/** ����ȭ ó�� �� �߻��� �� �ִ� ������ ��� �� ����� ���� */
	/*
	public void run() {
		// �����忡�� ���������� �ݾ� ���
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
	
	/** wait(), notify()/notifyAll() �޼ҵ带 �̿��� ��� �� ����� ���� �ذ�*/
	/*
	public void run() {
		// �����忡�� ���������� �ݾ� ���
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
