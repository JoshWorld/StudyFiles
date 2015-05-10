package kr.or.kosta.swings.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class StudentModel2 extends AbstractTableModel {
	
	Vector<String> headerNames;
	Vector<Student> cellDatas;
	
	public StudentModel2(){
		headerNames = new Vector<String>();
		headerNames.addElement("�̸�");
		headerNames.addElement("�й�");
		headerNames.addElement("�а�");
		cellDatas = new Vector<Student>();
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
		Object cellData = null;
		switch (columnIndex) {
			case 0: 
				cellData = cellDatas.elementAt(rowIndex).getName();
				break;
			case 1: 
				cellData = cellDatas.elementAt(rowIndex).getSsn();
				break;
			case 2: 
				cellData = cellDatas.elementAt(rowIndex).getMajor();
				break;
		}
		
		return cellData;
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
		Student student = new Student();
		student.setName(name);
		student.setSsn(ssn);
		student.setMajor(major);
		cellDatas.addElement(student);
		
		// �信�� ������ �뺸
		fireTableStructureChanged();
	}
	
	public void setStudent(Student student){
		cellDatas.clear();
		cellDatas.addElement(student);
		// �信�� ������ �뺸
		fireTableStructureChanged();
	}


}





