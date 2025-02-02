package kr.or.kosta.thread.example2;

// 여러 스레드에 의해 공유되는 객체
public class MovieReserveSystem /* extends Object*/{
	
	private boolean[] tickets;

	public MovieReserveSystem() {
		this(10);
	}

	public MovieReserveSystem(int count) {
		tickets = new boolean[count];
	}

	public /*synchronized*/ boolean reserve(Member member) {
		// 구체적 동기화 처리
		//synchronized (MovieReserveSystem.class) {
			System.out.println(member.getUserName() + "님 예약 신청!!!");
			// 원격의 데이터베이스 서버를 체크 한다는 의미로 1초 동안 대기
			try {
				System.out.println("예약 진행중 .............");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			for (int i = 0; i < tickets.length; i++) {
				// 예약되어 있지 않았으면
				if (!tickets[i]) {
					// 예약으로 변경
					tickets[i] = true;
					System.out.println("▶ " + member.getUserName() + "님 "
							+ (i + 1) + "번 좌석 예약처리 완료~~");
					return tickets[i];
				}
			}
		//}

		// 좌석이 없으면
		return false;

	}

}
