package kr.or.kosta.swings;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneFrame extends JFrame {
	JTabbedPane tabPane;
	
	public JTabbedPaneFrame() {
		this("����������Ʈ��...");
	}

	public JTabbedPaneFrame(String title) {
		super(title);
		tabPane = new JTabbedPane();
		tabPane.addTab("���µ��", createImageIcon("add_index.gif"), new JLabel("���µ�� ȭ���Դϴ�.."));
		tabPane.addTab("���¸��", createImageIcon("add_index.gif"), new JLabel("���¸�� ȭ���Դϴ�.."));
		tabPane.addTab("���°˻�", createImageIcon("add_index.gif"), new JLabel("���°˻� ȭ���Դϴ�.."));
		tabPane.addTab("���»���", createImageIcon("add_index.gif"), new JLabel("���»��� ȭ���Դϴ�.."));
	}

	public void setContents() {
		add(tabPane, BorderLayout.CENTER);
	}
	
	public ImageIcon createImageIcon(String  filePath) {
		//return new ImageIcon("classes/" + filePath);
		return new ImageIcon(getClass().getResource("/images/"+filePath));
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
		JTabbedPaneFrame frame = new JTabbedPaneFrame();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






