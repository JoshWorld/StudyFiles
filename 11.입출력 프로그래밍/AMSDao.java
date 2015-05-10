package kr.or.kosta.ams.controller;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.MinusAccount;
/**
 * AMS �����
 * @author �ֽ�ö
 * 
 */
public class AMSDao{

	/** �������� ���*/
	private static final String FILE_PATH = "accounts.dbf";

	private RandomAccessFile randomAccessFile;

	/** ����� ���ڵ�(Account)�� */
	private int recordCount = 0;

	/** ���ڵ�� ������ ���� �÷� ������ */
	private static final int RECORD_COUNT_LENGTH = 4;

	/** �������� ������ ���� ���ڵ� �÷��� ������ ����*/
	//��������|���¹�ȣ|�����ָ�|��й�ȣ|�����ܾ�|����ݾ�
	private static final int ACCOUNT_TYPE_LENGTH = 1;			// �������� 1����Ʈ
	private static final int ACCOUNT_NUM_LENGTH = 18;			// ���¹�ȣ �ִ� 9����
	private static final int ACCOUNT_OWNER_LENGTH = 10;			// �����ָ� �ִ� 5����
	private static final int ACCOUNT_PW_LENGTH = 4;				// ��й�ȣ 4����Ʈ
	private static final int ACCOUNT_RESTMONEY_LENGTH = 8;		// �����ܾ� 8����Ʈ
	private static final int ACCOUNT_BORROWMONEY_LENGTH = 8;	// ����ݾ� 8����Ʈ

	/** �������� ������ ���� ���ڵ� �ѻ����� : 1+18+10+4+8+8=42����Ʈ */	
	public static final int RECORD_LENGTH = ACCOUNT_TYPE_LENGTH + ACCOUNT_NUM_LENGTH + ACCOUNT_OWNER_LENGTH + ACCOUNT_PW_LENGTH + ACCOUNT_RESTMONEY_LENGTH + ACCOUNT_BORROWMONEY_LENGTH;

	public AMSDao() throws IOException{
		randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
		// ����� ���� ����� �ִ� ��� 
		if(randomAccessFile.length() != 0){
			recordCount = randomAccessFile.readInt(); //����Ǿ� �ִ� ���ڵ��� ��
		}

	}	

	public RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}
	public int getRecordCount() {
		return recordCount;
	}

	/** 
	 * ���ο� ���� ���� ����
	 * 
	 */
	public void saveRecord(Account account) throws Exception{
		// ������ ������ ���ڵ峡���� ���� ������ �̵�.
		randomAccessFile.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		// ���ڵ� �߰�
		newRecord(account);

		// ���ڵ� ���� �� ���������͸� ������ ó������ �̵����� ��ϵ� ���ڵ�(����) �� 1 ����
		randomAccessFile.seek(0);
		randomAccessFile.writeInt(++recordCount);
	}
	
	/**
	 * ���ڵ�(����) �߰�
	 */
	public void newRecord(Account account) throws IOException {

		byte accountType = account.getAccountType();		// ��������
		String accountNum = account.getAccountNum();		// ���¹�ȣ
		String accountOwner = account.getAccountOwner();	// �����ָ�
		int pw = account.getPasswd();						// ��й�ȣ
		long restMoney = account.getRestMoney();			// �����ܾ�
		long borrowMoney = 0;								// ����ݾ�
		if(accountType==1){	// ���̳ʽ������� ���
			borrowMoney = ((MinusAccount) account).getBorrowMoney();
		}

		// �������� ����
		randomAccessFile.write(accountType);

		// ���¹�ȣ ����
		int charCount = accountNum.length();
		for(int i = 0; i < (ACCOUNT_NUM_LENGTH/2); i++){		
			// EX) "1234-1234 "
			randomAccessFile.writeChar((i<charCount ? accountNum.charAt(i) : '.'));
		}

		// �����ָ� ����
		charCount = accountOwner.length();
		for(int i = 0; i < (ACCOUNT_OWNER_LENGTH/2); i++){
			// EX) "�ֽ�ö  "
			randomAccessFile.writeChar((i<charCount ? accountOwner.charAt(i) : ' '));
		}

		// ��й�ȣ ����
		randomAccessFile.writeInt(pw);

		// �����ܾ� ����
		randomAccessFile.writeLong(restMoney);

		// ����ݾ� ����
		randomAccessFile.writeLong(borrowMoney);
	}

	/**
	 *  ��ϵ� ��ü����Ʈ ��ȯ 
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
	 *  Ư�� ���ڵ��� ������ Account�� ��ȯ 
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
	 *  ��Ʈ�� �ݱ�
	 */
	public void close(){
		try{
			if(randomAccessFile != null) randomAccessFile.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	/**
	 *  ���¹�ȣ�� ���� ��ȸ
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
	 * �����ָ����� ���� �˻�
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
	 * ���¹�ȣ�� ���� ����
	 */
	public boolean remove(String accountNum) throws Exception {
		for (int i=0; i<recordCount; i++) {
			Account deleteAccount = getRecord(i);

			if(deleteAccount.getAccountNum().equals(accountNum)) {
				// ������ ���ڵ� ��ġ�� ���� ���ڵ� �����
				for (int j=i+1; j<recordCount;j++) {
					Account nextAccount = getRecord(j);
					randomAccessFile.seek(((j-1) * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
					newRecord(nextAccount);
				}
				// ���ڵ� ���� �� ���������͸� ������ ó������ �̵����� ��ϵ� ���ڵ�(����) �� 1 ����
				randomAccessFile.seek(0);
				randomAccessFile.writeInt(--recordCount);

				return true;
			}
		}
		return false;
	}
}

