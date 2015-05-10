package kr.or.kosta.thread.example1;

/**
 * 스레드 생명주기 테스트
 */
public class LifecycleExample {
	
	public static void main(String[] args) {
		// 현재 스레드 취득
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + "스레드 시작됨>>>");
		
		// 사용자 정의 스레드 생성 및 실행
		UserThread t1 = new UserThread("KIM");		
		UserThread t2 = new UserThread("PARK");
		t1.start();
		t2.start();
		
		System.out.println(currentThread.getName() + "스레드 종료됨>>>");
	}

}
