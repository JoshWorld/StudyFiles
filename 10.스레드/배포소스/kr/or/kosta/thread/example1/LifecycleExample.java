package kr.or.kosta.thread.example1;

/**
 * ������ �����ֱ� �׽�Ʈ
 */
public class LifecycleExample {
	
	public static void main(String[] args) {
		// ���� ������ ���
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + "������ ���۵�>>>");
		
		// ����� ���� ������ ���� �� ����
		UserThread t1 = new UserThread("KIM");		
		UserThread t2 = new UserThread("PARK");
		t1.start();
		t2.start();
		
		System.out.println(currentThread.getName() + "������ �����>>>");
	}

}
