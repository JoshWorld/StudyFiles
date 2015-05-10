package kr.or.kosta.thread.example1;

/**
 * ����������
 * ���ν������ ������ ���������� ����
 * ���ν����尡 ����Ǿ ����������� ������� ������ ���α׷��� ������� �ʴ´�.
 * 
 * ���󽺷���
 * ���ν����忡 �������� ������� ���ν����� ����� ���� ����Ǵ� ������
 * @author �����
 */
public class DaemonThread extends Thread{
	boolean stop;

	@Override
	public void run() {
		while(!stop){
			try {
				System.out.println("���󽺷��忡�� �����κ��� 1�ʴ����� �ǽð� ������ ��� �о�� ���!!!");
				//server.request();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("���ν����� ���۵�>>>");
		DaemonThread t = new DaemonThread();
		t.setDaemon(true);// ���󽺷���� ����
		t.start();
		
		try {
			// �׽�Ʈ�� ���� ���ν����� 10�ʰ� ���
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("���ν����� �����>>>");
	}

}
