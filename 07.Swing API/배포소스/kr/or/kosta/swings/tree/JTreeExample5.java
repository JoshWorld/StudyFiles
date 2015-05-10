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
 * JTree 활용 예제
 * TreeModel을 모델로 사용
 * 이벤트 처리 및 TreeCellRenderer 설정을 이용한 노드이미지 변경
 * @author 김기정
 *
 */
public class JTreeExample5 extends JFrame {
	JTree tree;
	
	TreeModel model;
	DefaultMutableTreeNode memberNode, listNode, addNode, searchNode, deleteNode;
	
	// 노드이미지 변경을 위한 셀렌더러
	DefaultTreeCellRenderer cellRenderer;
	
	public JTreeExample5() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample5(String title) {
		super(title);
		
		// 노드 생성
		memberNode = new DefaultMutableTreeNode("회원관리");
		listNode = new DefaultMutableTreeNode("목록");
		addNode = new DefaultMutableTreeNode("등록");
		searchNode = new DefaultMutableTreeNode("검색");
		deleteNode = new DefaultMutableTreeNode("삭제");
		memberNode.add(listNode);
		memberNode.add(addNode);
		memberNode.add(searchNode);
		memberNode.add(deleteNode);
		
		// 모델 생성
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
				// 선택노드 얻기				
				MutableTreeNode selectNode = (MutableTreeNode) tree.getLastSelectedPathComponent();
				if(selectNode == memberNode){
					System.out.println("회원관리 선택");
				}else if(selectNode == listNode){
					System.out.println("목록 선택");
				}else if(selectNode == addNode){
					System.out.println("등록 선택");
				}else if(selectNode == searchNode){
					System.out.println("검색 선택");
				}else if(selectNode == deleteNode){
					System.out.println("삭제 선택");
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






