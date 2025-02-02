package kr.or.kosta.swings.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class StudentModel2 extends AbstractTableModel {
	
	Vector<String> headerNames;
	Vector<Student> cellDatas;
	
	public StudentModel2(){
		headerNames = new Vector<String>();
		headerNames.addElement("이름");
		headerNames.addElement("학번");
		headerNames.addElement("학과");
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
	//추상 메소드는 아니지만 헤더이름이 나오기위해서는
	// 반드시 재정의 필요
	public String getColumnName(int column) {
		return headerNames.elementAt(column);
	}
	
	/**
	 * 학생정보 등록을 위한 사용자 정의 메소드
	 */
	public void addStudent(String name, String ssn, String major){
		Student student = new Student();
		student.setName(name);
		student.setSsn(ssn);
		student.setMajor(major);
		cellDatas.addElement(student);
		
		// 뷰에게 변경을 통보
		fireTableStructureChanged();
	}
	
	public void setStudent(Student student){
		cellDatas.clear();
		cellDatas.addElement(student);
		// 뷰에게 변경을 통보
		fireTableStructureChanged();
	}


}





