package kr.or.kosta.thread.example1;

/**
 * ������ ����������Ŭ�� ���� �޼��� �׽�Ʈ�� ���� ����� ���� ������
 * @author �����
 */
public class UserThread extends Thread {
	
	public UserThread(String name){
		super(name);
		System.out.println(name + "������ ������...");
	}
	
	/**
	 * ����� �������� ���� ������
	 */
	@Override
	public void run() {
		System.out.println(getName() + "������ ���۵ƽ���...");
		for(int i=0; i<10; i++){
			System.out.println(getName() + "�����忡�� i = "+i+" ���.");
			// �켱������ ���ų� ���� �����忡�� CPU ����� �纸(�� 100% �纸���� ����)
			//Thread.yield();
			//stop();
			//suspend();
			//resume();
			
		}
		System.out.println(getName() + "������ ����ƽ���...");
	}
}
