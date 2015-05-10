package kr.or.kosta.swings.tree;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * JTree Ȱ�� ����
 * TreeModel�� �𵨷� ���
 * �̺�Ʈ ó�� �� TreeCellRenderer ������ �̿��� ����̹��� ����
 * @author �����
 *
 */
public class JTreeExample5 extends JFrame {
	JTree tree;
	
	TreeModel model;
	DefaultMutableTreeNode memberNode, listNode, addNode, searchNode, deleteNode;
	
	// ����̹��� ������ ���� ��������
	DefaultTreeCellRenderer cellRenderer;
	
	public JTreeExample5() {
		this("����������Ʈ��...");
	}

	public JTreeExample5(String title) {
		super(title);
		
		// ��� ����
		memberNode = new DefaultMutableTreeNode("ȸ������");
		listNode = new DefaultMutableTreeNode("���");
		addNode = new DefaultMutableTreeNode("���");
		searchNode = new DefaultMutableTreeNode("�˻�");
		deleteNode = new DefaultMutableTreeNode("����");
		memberNode.add(listNode);
		memberNode.add(addNode);
		memberNode.add(searchNode);
		memberNode.add(deleteNode);
		
		// �� ����
		model = new DefaultTreeModel(memberNode);
		tree = new JTree(model);
		
		cellRenderer = new DefaultTreeCellRenderer();
		cellRenderer.setLeafIcon(createImageIcon("images/add_index.gif"));
		cellRenderer.setClosedIcon(createImageIcon("images/debug.gif"));
		cellRenderer.setOpenIcon(createImageIcon("images/arrow.gif"));
		tree.setCellRenderer(cellRenderer);
		
	}

	public ImageIcon createImageIcon(String  filePath) {
		return new ImageIcon("classes/" + filePath);
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
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// ���ó�� ���				
				MutableTreeNode selectNode = (MutableTreeNode) tree.getLastSelectedPathComponent();
				if(selectNode == memberNode){
					System.out.println("ȸ������ ����");
				}else if(selectNode == listNode){
					System.out.println("��� ����");
				}else if(selectNode == addNode){
					System.out.println("��� ����");
				}else if(selectNode == searchNode){
					System.out.println("�˻� ����");
				}else if(selectNode == deleteNode){
					System.out.println("���� ����");
				}
				
				TreePath treePath =  tree.getSelectionPath();
				//System.out.println(treePath);
				Object[] path = treePath.getPath();
				for (Object node : path) {
					System.out.print(node);
				}
			}
		});
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JTreeExample5 frame = new JTreeExample5();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






