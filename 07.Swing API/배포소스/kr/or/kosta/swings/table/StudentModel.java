package kr.or.kosta.swings.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class StudentModel extends AbstractTableModel {
	
	Vector<String> headerNames;
	Vector<Vector<String>> cellDatas;
	
	
	public StudentModel(){
		headerNames = new Vector<String>();
		headerNames.addElement("�̸�");
		headerNames.addElement("�й�");
		headerNames.addElement("�а�");
		
		cellDatas = new Vector<Vector<String>>();
		
		// ���� Row ������
		Vector<String> row = new Vector<String>();
		row.addElement("�����");
		row.addElement("87342065");
		row.addElement("�����а�");
		
		Vector<String> row2 = new Vector<String>();
		row2.addElement("�ڱ���");
		row2.addElement("87342065");
		row2.addElement("�����а�");
		cellDatas.addElement(row);
		cellDatas.addElement(row2);
		
	}

	@Override
	public int getRowCount() {
		return cellDatas.size();
	}

	@Override
	public int getColumnCount() {
		return headerNames.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return cellDatas.elementAt(rowIndex).elementAt(columnIndex);
	}
	
	@Override
	//�߻� �޼ҵ�� �ƴ����� ����̸��� ���������ؼ���
	// �ݵ�� ������ �ʿ�
	public String getColumnName(int column) {
		return headerNames.elementAt(column);
	}
	
	/**
	 * �л����� ����� ���� ����� ���� �޼ҵ�
	 */
	public void addStudent(String name, String ssn, String major){
		Vector<String> row = new Vector<String>();
		row.addElement(name);
		row.addElement(ssn);
		row.addElement(major);	
		
		cellDatas.addElement(row);
		
		// �信�� ������ �뺸
		fireTableStructureChanged();
	}
	
	public void setStudent(Student student){
		cellDatas.clear();
		
		Vector<String> row = new Vector<String>();
		row.addElement(student.getName());
		row.addElement(student.getSsn());
		row.addElement(student.getMajor());	
		
		cellDatas.addElement(row);
		
		// �信�� ������ �뺸
		fireTableStructureChanged();
	}


}





