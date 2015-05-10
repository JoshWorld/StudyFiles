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
public class JTableExample3 extends JFrame {
	JTable table;
	
	JButton button, searchB;
	
	// ���̺��� ���� �� ��
	//StudentModel model;
	StudentModel2 model;
	
	public JTableExample3() {
		this("����������Ʈ��...");
	}

	public JTableExample3(String title) {
		super(title);
		button = new JButton("�����߰��� ���� ��ư");
		searchB = new JButton("�˻�");

		model = new StudentModel2();
		table = new JTable(model);
		//table.setModel(model);
		
	}

	public void setContents() {
		//setLayout(new FlowLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		add(searchB, BorderLayout.NORTH);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void studentAdd(){
		String name = "ȫ�浿";
		String ssn = "45454545";
		String major = "ü���а�";
		model.addStudent(name, ssn, major);
	}
	
	public void studentSearch(){
		Student searchStudent = new Student("�����", "1224", "�����а�");
		model.setStudent(searchStudent);
	}
	

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentAdd();
			}
		});
		searchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentSearch();
			}
		});
		
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JTableExample3 frame = new JTableExample3();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






