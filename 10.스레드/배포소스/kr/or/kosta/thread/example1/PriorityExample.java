package kr.or.kosta.thread.example1;
/**
 * 스레드 우선순위 테스트
 */
public class PriorityExample {

	
	public static void main(String[] args) {
		
		// 우선순위 상수
		System.out.println(Thread.MAX_PRIORITY);//10
		System.out.println(Thread.NORM_PRIORITY);//5
		System.out.println(Thread.MIN_PRIORITY);//1
		
		
		UserThread t1 = new UserThread("KIM");
		// 우선순위 확인(디폴트로 5로 설정되어 있음)
		System.out.println(t1.getPriority());
		
		// 우선순위 설정
		t1.setPriority(Thread.MAX_PRIORITY);
		
		UserThread t2 = new UserThread("LEE");
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		// main 스레드의 우선순위 확인
		System.out.println("main 우선순위: " + Thread.currentThread().getPriority());
	}

}
