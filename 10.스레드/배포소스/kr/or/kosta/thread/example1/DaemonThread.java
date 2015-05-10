package kr.or.kosta.thread.example1;

/**
 * 독립스레드
 * 메인스레드와 별도로 독립적으로 실행
 * 메인스레드가 종료되어도 독립스레드는 종료되지 않으며 프로그램은 종료되지 않는다.
 * 
 * 데몬스레드
 * 메인스레드에 종속적인 스레드로 메인스레드 종료시 같이 종료되는 스레드
 * @author 김기정
 */
public class DaemonThread extends Thread{
	boolean stop;

	@Override
	public void run() {
		while(!stop){
			try {
				System.out.println("데몬스레드에서 서버로부터 1초단위로 실시간 정보를 계속 읽어와 출력!!!");
				//server.request();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("메인스레드 시작됨>>>");
		DaemonThread t = new DaemonThread();
		t.setDaemon(true);// 데몬스레드로 설정
		t.start();
		
		try {
			// 테스트를 위해 메인스레드 10초간 대기
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인스레드 종료됨>>>");
	}

}
