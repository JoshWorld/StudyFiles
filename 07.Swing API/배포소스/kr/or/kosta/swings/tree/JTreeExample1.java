package kr.or.kosta.swings.tree;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 * JTree Ȱ�� ����
 * Object[]�� �𵨷� ���
 * @author �����
 *
 */
public class JTreeExample1 extends JFrame {
	JTree tree;
	
	public JTreeExample1() {
		this("����������Ʈ��...");
	}

	public JTreeExample1(String title) {
		super(title);
		
		// JTree�� ������ Model
		Object[] nodes = {"������", "������", "����˻�"};
		
		tree = new JTree(nodes);
	}

	public void setContents() {
		//setLayout(new FlowLayout());
		add(new JScrollPane(tree), BorderLayout.CENTER);
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
		JTreeExample1 frame = new JTreeExample1();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






