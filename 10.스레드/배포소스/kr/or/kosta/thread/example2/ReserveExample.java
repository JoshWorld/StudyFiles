package kr.or.kosta.thread.example2;


public class ReserveExample {
	public static void main(String[] args) {
		// 스레드에 의해 공유되는 객체
		MovieReserveSystem reserveManager = new MovieReserveSystem(10);
		
		// 테스트를 위한 고객 스레드 생성
		Member m1 = new Member("기윤", reserveManager);
		Member m2 = new Member("현직", reserveManager);
		Member m3 = new Member("제형", reserveManager);
		
		m1.start();
		m2.start();
		m3.start();

	}

}
