package kr.or.kosta.swings.mvc;
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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MVC ���������ϰ� ���õ� ����
 * @author �����
 *
 */
public class JListExample extends JFrame {
	JList list;
	
	// JList(��)�� ������ ������ ������ ���� ��
	//String[] model;
	//Vector<String> model;
	
	// ��������� ListModel
	//NameModel model;
	
	// �̹� ������� �ִ� DefaultListModel
	DefaultListModel<Icon> model;
	
	
	JTextField tf;
	JButton button, deleteButton, updateButton;
	
	public JListExample() {
		this("����������Ʈ��...");
	}

	public JListExample(String title) {
		super(title);
		
		// �� ����
		//model = new String[10];
		//model[0] = "�Ժ�";
		//model[1] = "���";
		//model[3] = "����";
		//model = new Vector<String>();
		//model.addElement("�Ժ�");
		//model.addElement("���");
		
		//model = new NameModel();
		
		model = new DefaultListModel<Icon>();
		
		list = new JList(model);
		//list.setModel(model);
		//list.getModel();
		
		tf = new JTextField(20);
		button = new JButton("���");
		deleteButton = new JButton("����");
		updateButton = new JButton("����");
	}

	public void setContents() {
		setLayout(new FlowLayout());
		add(new JScrollPane(list));
		add(tf);
		add(button);
		add(deleteButton);
		add(updateButton);
	}
	
	public ImageIcon createImageIcon(String  filePath) {
		return new ImageIcon("classes/" + filePath);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void add(){
		String name = tf.getText();
		if(name != null){
			tf.setText("");
			//model[3] = name;
			//model.addElement(name);
			//model.addName(name);
			model.addElement(createImageIcon("images/add_index.gif"));
		}
		
				
	}
	
	public void delete(){
		int idx = list.getSelectedIndex();
		//model.deleteName(idx);
		model.removeElementAt(idx);
	}
	
	public void update(){
		String name = tf.getText();
		if(name != null){
			int idx = list.getSelectedIndex();
			//model.updateName(name, idx);
			model.setElementAt(createImageIcon("images/back.gif"), idx);
		}
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
				add();				
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();			
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tf.setText(list.getSelectedValue().toString());
			}
		});
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				update();			
			}
		});
		
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JListExample frame = new JListExample();
		frame.setContents();
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






