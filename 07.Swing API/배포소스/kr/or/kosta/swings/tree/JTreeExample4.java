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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

/**
 * JTree 활용 예제
 * TreeModel을 모델로 사용
 * @author 김기정
 *
 */
public class JTreeExample4 extends JFrame {
	JTree tree;
	
	TreeModel model;
	
	public JTreeExample4() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample4(String title) {
		super(title);
		
		// 노드 생성
		DefaultMutableTreeNode memberNode, listNode, addNode, searchNode, deleteNode;
		memberNode = new DefaultMutableTreeNode("회원관리");
		listNode = new DefaultMutableTreeNode("목록");
		addNode = new DefaultMutableTreeNode("등록");
		searchNode = new DefaultMutableTreeNode("검색");
		deleteNode = new DefaultMutableTreeNode("삭제");
		memberNode.add(listNode);
		memberNode.add(addNode);
		memberNode.add(searchNode);
		memberNode.add(deleteNode);
		
		listNode.add(new DefaultMutableTreeNode("용주바보"));
		
		// 모델 생성
		model = new DefaultTreeModel(memberNode);
		
		tree = new JTree(model);
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
		JTreeExample4 frame = new JTreeExample4();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






