package kr.or.kosta.io.randomaccessfile;

import java.util.*;
import java.io.*;

/**
 * FileDao �׽�Ʈ�� ���� ���ø����̼� Ŭ����
 * @author �����
 *
 */
public class  FriendFileDaoExample{
	public static void main(String[] args) {
		
		FriendDao fileManager = null;
		
		try{
			fileManager = new FriendDao();
			// ���Ͽ� ģ��(���ڵ�) �߰� �׽�Ʈ
			fileManager.saveRecord(new Friend("�����", 43, 61.34, "011-9179-8707"));
			fileManager.saveRecord(new Friend("��Ժ�", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("����ȭ", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("�ڼ���", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("�����", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("������", 43, 61.34, "010-9179-8707"));
			System.out.println("���������� ��ϵǾ����ϴ�..");
		}catch(Exception ex){
			System.out.println("��Ͻ� ������ �߻��Ͽ����ϴ�: " + ex);			
		} 
		
		// ��ü ����Ʈ..
		System.out.println("***** ��ϵ� ��� ģ�� ����Ʈ(�� "+fileManager.getRecordCount()+"��) *****");
		try{
			ArrayList<Friend> list = (ArrayList<Friend>) fileManager.getRecords();
			for (Friend friend : list) {
				//System.out.println("�� " + friend.getName() + " | " + friend.getAge() + " | " + friend.getWeight() + " | "+ friend.getTelephone());
				System.out.println(friend);
			}
				
		}catch(Exception ex){
			System.out.println("����Ʈ ��½� ������ �߻��Ͽ����ϴ�: " + ex);			
		}

		// ��Ʈ�� �ݱ�
		fileManager.close();

	}
}
