package kr.or.kosta.swings.mvc;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * MVC ���������ϰ� ���õ� ����
 * JList�� �����ۿ� ����� �̹����� �̸��� ���� �����ֱ�
 * @author �����
 *
 */
public class ViewExample2 extends JFrame {
	JList<Student> list;
	
	Vector<Student> items;
	ImageCellRender renderer;
	
	public ViewExample2() {
		this("����������Ʈ��...");
	}

	public ViewExample2(String title) {
		super(title);
		items = new Vector<Student>();
		//items.addElement(new Student("�����", "87342065", "�����а�", "classes/images/add.gif"));
		//items.addElement(new Student("�̸ͱ�", "87342065", "�����а�", "classes/images/search.gif"));
		//items.addElement(new Student("�̸ͱ�", "87342065", "�����а�", "classes/images/search.gif"));
		//items.addElement(new Student("�̸ͱ�", "87342065", "�����а�", "classes/images/search.gif"));
		//items.addElement(new Student("�̸ͱ�", "87342065", "�����а�", "classes/images/search.gif"));
		//items.addElement(new Student("�̸ͱ�", "87342065", "�����а�", "classes/images/search.gif"));
		list = new JList<Student>(items);
		renderer = new ImageCellRender();
		list.setCellRenderer(renderer);
	}

	public void setContents() {
		setLayout(new FlowLayout());
		add(new JScrollPane(list));
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
		ViewExample2 frame = new ViewExample2();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






