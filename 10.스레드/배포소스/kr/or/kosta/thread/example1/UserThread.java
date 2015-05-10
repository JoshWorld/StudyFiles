package kr.or.kosta.thread.example1;

/**
 * 스레드 라이프사이클과 제어 메서드 테스트를 위한 사용자 정의 스레드
 * @author 김기정
 */
public class UserThread extends Thread {
	
	public UserThread(String name){
		super(name);
		System.out.println(name + "스레드 생성됨...");
	}
	
	/**
	 * 사용자 스레드의 실행 진입점
	 */
	@Override
	public void run() {
		System.out.println(getName() + "스레드 시작됐시유...");
		for(int i=0; i<10; i++){
			System.out.println(getName() + "스레드에서 i = "+i+" 출력.");
			// 우선순위가 같거나 높은 스레드에게 CPU 사용을 양보(단 100% 양보하진 않음)
			//Thread.yield();
			//stop();
			//suspend();
			//resume();
			
		}
		System.out.println(getName() + "스레드 종료됐시유...");
	}
}
