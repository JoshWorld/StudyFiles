package kr.or.kosta.swings.tree;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 * JTree Ȱ�� ����
 * Hashtable�� �𵨷� ���
 * @author �����
 *
 */
public class JTreeExample3 extends JFrame {
	JTree tree;
	
	Hashtable<String, Object> nodes;
	
	public JTreeExample3() {
		this("����������Ʈ��...");
	}

	public JTreeExample3(String title) {
		super(title);
		
		nodes = new Hashtable<String, Object>();
		
		Hashtable<String, Object> subNodes = new Hashtable<String, Object>();
		subNodes.put("���", "");
		subNodes.put("���", "");
		subNodes.put("����", "");
		nodes.put("�������", subNodes);
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
		JTreeExample3 frame = new JTreeExample3();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






