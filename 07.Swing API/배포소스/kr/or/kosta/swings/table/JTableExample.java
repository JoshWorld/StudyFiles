package kr.or.kosta.swings.table;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
public class JTableExample extends JFrame {
	JTable table;
	
	public JTableExample() {
		this("����������Ʈ��...");
	}

	public JTableExample(String title) {
		super(title);
		// ���̺��� �����ִ� ��
		Object[][] cellDatas = {{"�����", "87342065", "�����ϰ�"}, 
				                {"�ڱ���", "87342065", "�����ϰ�"},
				                {"�ֱ���", "87342065", "�����ϰ�"}
				               };
		Object[] headerNames = {"�̸�", "�й�", "�а�"};
		//table = new JTable(5, 5);
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
		JTableExample frame = new JTableExample();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






