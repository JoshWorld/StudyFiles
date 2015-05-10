package kr.or.kosta.thread.example2;

// ���� �����忡 ���� �����Ǵ� ��ü
public class MovieReserveSystem /* extends Object*/{
	
	private boolean[] tickets;

	public MovieReserveSystem() {
		this(10);
	}

	public MovieReserveSystem(int count) {
		tickets = new boolean[count];
	}

	public /*synchronized*/ boolean reserve(Member member) {
		// ��ü�� ����ȭ ó��
		//synchronized (MovieReserveSystem.class) {
			System.out.println(member.getUserName() + "�� ���� ��û!!!");
			// ������ �����ͺ��̽� ������ üũ �Ѵٴ� �ǹ̷� 1�� ���� ���
			try {
				System.out.println("���� ������ .............");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			for (int i = 0; i < tickets.length; i++) {
				// ����Ǿ� ���� �ʾ�����
				if (!tickets[i]) {
					// �������� ����
					tickets[i] = true;
					System.out.println("�� " + member.getUserName() + "�� "
							+ (i + 1) + "�� �¼� ����ó�� �Ϸ�~~");
					return tickets[i];
				}
			}
		//}

		// �¼��� ������
		return false;

	}

}
