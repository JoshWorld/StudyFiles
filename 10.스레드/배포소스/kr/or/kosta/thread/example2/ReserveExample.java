package kr.or.kosta.thread.example2;


public class ReserveExample {
	public static void main(String[] args) {
		// �����忡 ���� �����Ǵ� ��ü
		MovieReserveSystem reserveManager = new MovieReserveSystem(10);
		
		// �׽�Ʈ�� ���� �� ������ ����
		Member m1 = new Member("����", reserveManager);
		Member m2 = new Member("����", reserveManager);
		Member m3 = new Member("����", reserveManager);
		
		m1.start();
		m2.start();
		m3.start();

	}

}
