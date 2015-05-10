package kr.or.kosta.swings.table;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * MVC ���������ϰ� ���õ� ����
 * JTable Ȱ�� ����
 * @author �����
 *
 */
public class JTableExample2 extends JFrame {
	JTable table;
	
	// ���̺��� ���� �� ��
	Vector<Vector<String>> cellDatas;
	Vector<String> headerNames;
	
	public JTableExample2() {
		this("����������Ʈ��...");
	}

	public JTableExample2(String title) {
		super(title);
		cellDatas = new Vector<Vector<String>>();
		
		// Row ������
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
		
		
		// �������
		headerNames = new Vector<String>();
		headerNames.addElement("�̸�");
		headerNames.addElement("�й�");
		headerNames.addElement("�а�");
		
		table = new JTable(cellDatas, headerNames);
		
	}

	public void setContents() {
		//setLayout(new FlowLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JTableExample2 frame = new JTableExample2();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






