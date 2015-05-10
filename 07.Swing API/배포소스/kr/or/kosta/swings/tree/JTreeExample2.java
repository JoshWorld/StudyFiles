package kr.or.kosta.swings.tree;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 * JTree Ȱ�� ����
 * Vector�� �𵨷� ���
 * @author �����
 *
 */
public class JTreeExample2 extends JFrame {
	JTree tree;
	
	Vector<String> nodes;
	
	public JTreeExample2() {
		this("����������Ʈ��...");
	}

	public JTreeExample2(String title) {
		super(title);
		
		nodes = new Vector<String>();
		nodes.addElement("������");
		nodes.addElement("������");
		nodes.addElement("����˻�");
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
		JTreeExample2 frame = new JTreeExample2();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






