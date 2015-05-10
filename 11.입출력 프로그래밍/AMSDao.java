package kr.or.kosta.ams.controller;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.MinusAccount;
/**
 * AMS 입출력
 * @author 최승철
 * 
 */
public class AMSDao{

	/** 저장파일 경로*/
	private static final String FILE_PATH = "accounts.dbf";

	private RandomAccessFile randomAccessFile;

	/** 저장된 레코드(Account)수 */
	private int recordCount = 0;

	/** 레코드수 저장을 위한 컬럼 사이즈 */
	private static final int RECORD_COUNT_LENGTH = 4;

	/** 계좌정보 저장을 위한 레코드 컬럼별 사이즈 설정*/
	//계좌종류|계좌번호|예금주명|비밀번호|현재잔액|대출금액
	private static final int ACCOUNT_TYPE_LENGTH = 1;			// 계좌종류 1바이트
	private static final int ACCOUNT_NUM_LENGTH = 18;			// 계좌번호 최대 9글자
	private static final int ACCOUNT_OWNER_LENGTH = 10;			// 예금주명 최대 5글자
	private static final int ACCOUNT_PW_LENGTH = 4;				// 비밀번호 4바이트
	private static final int ACCOUNT_RESTMONEY_LENGTH = 8;		// 현재잔액 8바이트
	private static final int ACCOUNT_BORROWMONEY_LENGTH = 8;	// 대출금액 8바이트

	/** 계좌정보 저장을 위한 레코드 총사이즈 : 1+18+10+4+8+8=42바이트 */	
	public static final int RECORD_LENGTH = ACCOUNT_TYPE_LENGTH + ACCOUNT_NUM_LENGTH + ACCOUNT_OWNER_LENGTH + ACCOUNT_PW_LENGTH + ACCOUNT_RESTMONEY_LENGTH + ACCOUNT_BORROWMONEY_LENGTH;

	public AMSDao() throws IOException{
		randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
		// 저장된 계좌 목록이 있는 경우 
		if(randomAccessFile.length() != 0){
			recordCount = randomAccessFile.readInt(); //저장되어 있는 레코드의 수
		}

	}	

	public RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}
	public int getRecordCount() {
		return recordCount;
	}

	/** 
	 * 새로운 계좌 정보 저장
	 * 
	 */
	public void saveRecord(Account account) throws Exception{
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		randomAccessFile.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		// 레코드 추가
		newRecord(account);

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜 등록된 레코드(계좌) 수 1 증가
		randomAccessFile.seek(0);
		randomAccessFile.writeInt(++recordCount);
	}
	
	/**
	 * 레코드(계좌) 추가
	 */
	public void newRecord(Account account) throws IOException {

		byte accountType = account.getAccountType();		// 계좌종류
		String accountNum = account.getAccountNum();		// 계좌번호
		String accountOwner = account.getAccountOwner();	// 예금주명
		int pw = account.getPasswd();						// 비밀번호
		long restMoney = account.getRestMoney();			// 현재잔액
		long borrowMoney = 0;								// 대출금액
		if(accountType==1){	// 마이너스계좌일 경우
			borrowMoney = ((MinusAccount) account).getBorrowMoney();
		}

		// 계좌종류 쓰기
		randomAccessFile.write(accountType);

		// 계좌번호 쓰기
		int charCount = accountNum.length();
		for(int i = 0; i < (ACCOUNT_NUM_LENGTH/2); i++){		
			// EX) "1234-1234 "
			randomAccessFile.writeChar((i<charCount ? accountNum.charAt(i) : '.'));
		}

		// 예금주명 쓰기
		charCount = accountOwner.length();
		for(int i = 0; i < (ACCOUNT_OWNER_LENGTH/2); i++){
			// EX) "최승철  "
			randomAccessFile.writeChar((i<charCount ? accountOwner.charAt(i) : ' '));
		}

		// 비밀번호 쓰기
		randomAccessFile.writeInt(pw);

		// 현재잔액 쓰기
		randomAccessFile.writeLong(restMoney);

		// 대출금액 쓰기
		randomAccessFile.writeLong(borrowMoney);
	}

	/**
	 *  등록된 전체리스트 반환 
	 */
	public List<Account>  getRecords() throws Exception{
		ArrayList<Account> list = new ArrayList<Account>();
		for(int i=0; i<recordCount; i++){
			Account account = getRecord(i);
			list.add(account);		
		}
		return list;
	}

	/**
	 *  특정 레코드의 정보를 Account로 반환 
	 */
	private Account getRecord(int index) throws IOException{
		Account account = null;

		randomAccessFile.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		byte accountType = 0;
		accountType = randomAccessFile.readByte();

		String accountNum = "";
		for(int i=0; i<(ACCOUNT_NUM_LENGTH)/2; i++){
			accountNum += randomAccessFile.readChar();
		}
		accountNum = accountNum.trim();

		String accountOwner = "";
		for(int i=0; i<(ACCOUNT_OWNER_LENGTH)/2; i++){
			accountOwner += randomAccessFile.readChar();
		}
		accountOwner = accountOwner.trim();

		int pw = 0;
		pw = randomAccessFile.readInt();

		long restMoney = 0;
		restMoney = randomAccessFile.readLong();

		long borrowMoney = 0;
		borrowMoney = randomAccessFile.readLong();
		
		if(accountType == 1){
			account = new MinusAccount(accountNum, accountOwner, pw, borrowMoney);
		}else{
			account = new Account(accountNum, accountOwner, pw, restMoney);
		}
		return account;
	}

	/**
	 *  스트림 닫기
	 */
	public void close(){
		try{
			if(randomAccessFile != null) randomAccessFile.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	/**
	 *  계좌번호로 계좌 조회
	 */
	public Account get(String accountNum) throws IOException {
		for (int i=0; i<recordCount; i++) {
			Account account = getRecord(i);

			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		return null;
	}

	/**
	 * 예금주명으로 계좌 검색
	 */
	public List<Account> search(String name) throws IOException {
		List<Account> searchList = new ArrayList<Account>();
		Account account = null;
		
		for (int i=0; i<recordCount; i++) {
			account = getRecord(i);
			
			if(account.getAccountOwner().equals(name)) {
				searchList.add(account);
			}
		}
		return searchList;
	}

	/**
	 * 계좌번호로 계좌 삭제
	 */
	public boolean remove(String accountNum) throws Exception {
		for (int i=0; i<recordCount; i++) {
			Account deleteAccount = getRecord(i);

			if(deleteAccount.getAccountNum().equals(accountNum)) {
				// 삭제할 레코드 위치에 다음 레코드 덮어쓰기
				for (int j=i+1; j<recordCount;j++) {
					Account nextAccount = getRecord(j);
					randomAccessFile.seek(((j-1) * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
					newRecord(nextAccount);
				}
				// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜 등록된 레코드(계좌) 수 1 감소
				randomAccessFile.seek(0);
				randomAccessFile.writeInt(--recordCount);

				return true;
			}
		}
		return false;
	}
}

