package kr.or.kosta.thread.example1;
/**
 * ������ �켱���� �׽�Ʈ
 */
public class PriorityExample {

	
	public static void main(String[] args) {
		
		// �켱���� ���
		System.out.println(Thread.MAX_PRIORITY);//10
		System.out.println(Thread.NORM_PRIORITY);//5
		System.out.println(Thread.MIN_PRIORITY);//1
		
		
		UserThread t1 = new UserThread("KIM");
		// �켱���� Ȯ��(����Ʈ�� 5�� �����Ǿ� ����)
		System.out.println(t1.getPriority());
		
		// �켱���� ����
		t1.setPriority(Thread.MAX_PRIORITY);
		
		UserThread t2 = new UserThread("LEE");
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		// main �������� �켱���� Ȯ��
		System.out.println("main �켱����: " + Thread.currentThread().getPriority());
	}

}
