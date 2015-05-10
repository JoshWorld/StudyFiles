package kr.or.kosta.swings.table;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {
	
	Vector<String> headerNames;
	Vector<Employee> employeeList;
	
	public EmployeeTableModel(){
		headerNames = new Vector<String>();
		headerNames.addElement("�̸�");
		headerNames.addElement("���");
		headerNames.addElement("�μ�");
		headerNames.addElement("����");
		headerNames.addElement("������");
		headerNames.addElement("����");
		headerNames.addElement("����");
		
		employeeList = new Vector<Employee>();
		// �׽�Ʈ�� ���� ���������
		Employee emp1 = new Employee("�����", "1234", "KOSTA", 40, 53.56, true, new ImageIcon("classes/images/add.gif"));
		Employee emp2 = new Employee("�ڱ��", "1234", "KOSTA", 40, 53.56, false, new ImageIcon("classes/images/add_index.gif"));
		employeeList.addElement(emp1);
		employeeList.addElement(emp2);
	}

	@Override
	public int getRowCount() {
		return employeeList.size();
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
				cellData = employeeList.elementAt(rowIndex).getName();
				break;
			case 1: 
				cellData = employeeList.elementAt(rowIndex).getSsn();
				break;
			case 2: 
				cellData = employeeList.elementAt(rowIndex).getDepartment();
				break;
			case 3: 
				cellData = employeeList.elementAt(rowIndex).getAge();
				break;
			case 4: 
				cellData = employeeList.elementAt(rowIndex).getWeight();
				break;
			case 5: 
				cellData = employeeList.elementAt(rowIndex).isMan();
				break;
			case 6: 
				cellData = employeeList.elementAt(rowIndex).getIcon();
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
	
	// �ʼ������� �������ؾ� �ϴ� �޼ҵ�� �ƴ�����
	// ���̺��� ������ ���� ���ϴ� ������������ �����ְ��� �Ѵٸ� ...
	@Override
	public Class getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
}





