package kr.or.kosta.io.randomaccessfile;


import java.io.*;
import java.util.*;
/**
 * RandomAccessFile�� �̿��� ���� ���Ӽ� ó�� Ŭ���� ĸ��ȭ
 * @author �����
 *
 */
public class FriendDao{
	
	/** �������� ���*/
	private static final String FILE_PATH = "accounts.dbf";
	
	private RandomAccessFile randomAccessFile;
	
	/** ����� ���ڵ�(ģ��)�� */
	private int recordCount = 0;
	
	/** ���ڵ�� ������ ���� �÷� ������ */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** ģ������ ������ ���� ���ڵ� �÷��� ������ ����*/
	//�̸�|����|������|��ȭ��ȣ|
	private static final int NAME_LENGTH = 10;        // �̸�(10����Ʈ)
	private static final int AGE_LENGTH = 4;          // ����(4����Ʈ)
	private static final int WEIGHT_LENGTH = 4;       // ������(8����Ʈ)
	private static final int TELEPHONE_LENGTH = 26;    // ��ȭ��ȣ(26����Ʈ)
	
	/** ģ������ ������ ���� ���ڵ� �ѻ����� : 48����Ʈ */	
	public static final int RECORD_LENGTH = NAME_LENGTH + AGE_LENGTH + WEIGHT_LENGTH + TELEPHONE_LENGTH;

	
	public FriendDao() throws IOException{
		randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
		// ����� ģ�� ����� �ִ� ��� 
		if(randomAccessFile.length() != 0){
			recordCount = randomAccessFile.readInt(); //����Ǿ� �ִ� ���ڵ��� ��
		}else{
			// �ӽ� �׽�Ʈ
			System.out.println("ó������ ���α׷��� �����Ͽ� ���Ͽ� ��ϵ� ģ�� ����");
		}
	}	
		
	public RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}
	public int getRecordCount() {
		return recordCount;
	}
	
	/** ���ο� ģ�� ���� ���� */
	public void saveRecord(Friend friend) throws Exception{
		// ������ ������ ���ڵ峡���� ���� ������ �̵�.
		randomAccessFile.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// ���ο� ���ڵ�(ģ��) �߰�
		//10 + 4 + 8 + 26
		String name = friend.getName();
		int age = friend.getAge();
		double weight = friend.getWeight();
		String telephone = friend.getTelephone();
		
		int charCount = name.length();		
		charCount = name.length();
		//10����Ʈ(5����)�� �̸� ����
		for(int i = 0; i < (NAME_LENGTH/2); i++){		
			// EX) "�����  "
			randomAccessFile.writeChar((i<charCount ? name.charAt(i) : ' '));
		}
		
		// ����(4����Ʈ)
		randomAccessFile.writeInt(age);
		// ������(8����Ʈ)
		randomAccessFile.writeDouble(weight);
				
		// 26����Ʈ(13����)�� ��ȭ��ȣ ����		
		charCount = telephone.length();
		for(int i = 0; i < (TELEPHONE_LENGTH/2); i++){
			// EX) "010-9179-8707"
			randomAccessFile.writeChar((i<charCount ? telephone.charAt(i) : ' '));
		}

		// ���ڵ� ���� �� ���������͸� ������ ó������ �̵�����
		// ��ϵ� ���ڵ�(ģ��) �� 1 ����
		randomAccessFile.seek(0);
		randomAccessFile.writeInt(++recordCount);
	}
	

	/** ��ϵ� ��ü����Ʈ ��ȯ */
	public List<Friend>  getRecords() throws Exception{
		ArrayList<Friend> list = new ArrayList<Friend>();
		for(int i=0; i<recordCount; i++){
			Friend friend = getRecord(i);
			list.add(friend);		
		}
		return list;
	}
	
	
	/** Ư�� ���ڵ��� ������ Friend�� ��ȯ */
	private Friend getRecord(int index) throws IOException{
		Friend friend = null;
		
		String name = "";
		randomAccessFile.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		for(int i=0; i<(NAME_LENGTH/2); i++){
			name += randomAccessFile.readChar();
		}
		name = name.trim();
		
		int age = 0;
		age = randomAccessFile.readInt();
		
		double weight = 0.0;
		weight = randomAccessFile.readDouble();
		
		String telephone = "";
		for(int i = 0;i<(TELEPHONE_LENGTH/2);i++){
			telephone += randomAccessFile.readChar();
		}
		telephone = telephone.trim();
		
		friend = new Friend(name, age, weight, telephone);
		return friend;
	}
	
	// ��Ʈ�� �ݱ�
	public void close(){
		try{
			if(randomAccessFile != null) randomAccessFile.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}


