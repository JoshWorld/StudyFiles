package kr.or.kosta.swings.mvc;

import java.util.Vector;

import javax.swing.AbstractListModel;

/**
 * JList�� ��� ��Ʈ�ѷ��� ����ϴ� ������ ������ ���� ��Ŭ����
 * @author �����
 *
 */
public class NameModel extends AbstractListModel/* implements ListModel*/{
	
	Vector<String> list;
	
	public NameModel(){
		list = new Vector<String>();
		// �׽�Ʈ �ʱ�ȭ
		list.addElement("�Ժ�");
		list.addElement("���");
	}
	
	@Override
	// View�� Controller�� ���� �ڵ� ȣ��Ǵ� �ݹ�޼ҵ�
	public int getSize() {
		System.out.println("getSize() ȣ���..");
		return list.size();
	}

	@Override
	// View�� Controller�� ���� �ڵ� ȣ��Ǵ� �ݹ�޼ҵ�
	public Object getElementAt(int index) {
		System.out.println("getElementAt(int index) ȣ���..");
		return list.elementAt(index);
	}
	
	/**
	 * ��� ��� �߰�
	 */
	public void addName(String name){
		list.addElement(name);
		// ���ϰ�, ��Ʈ�ѷ����� ������ ������ �뺸
		fireContentsChanged(list, 0, list.size());
	}
	
	/**
	 * ���� ��� �߰�
	 */
	public void deleteName(int idx){
		list.removeElementAt(idx);
		// ���ϰ�, ��Ʈ�ѷ����� ������ ������ �뺸
		fireContentsChanged(list, 0, list.size());
	}
	
	/**
	 * ���� ��� �߰�
	 */
	public void updateName(String name, int index){
		list.setElementAt(name, index);
		// ���ϰ�, ��Ʈ�ѷ����� ������ ������ �뺸
		fireContentsChanged(list, 0, list.size());
	}
}





