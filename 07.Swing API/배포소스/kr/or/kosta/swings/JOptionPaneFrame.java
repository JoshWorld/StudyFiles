package kr.or.kosta.swings;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneFrame extends JFrame {
	JButton messageButton, confirmButton, inputButton, optionButton;
	
	public enum Days{
		������, ȭ����, ������, �����, �ݿ���, �����, �Ͽ���
	}
	
	public JOptionPaneFrame() {
		this("����������Ʈ��...");
	}

	public JOptionPaneFrame(String title) {
		super(title);
		messageButton = new JButton("�޽���â");
		confirmButton = new JButton("Ȯ��â");
		inputButton = new JButton("�Է�â");
		optionButton = new JButton("�ɼ�â");
		
	}


	public void setContents() {
		setLayout(new FlowLayout());
		add(messageButton);
		add(confirmButton);
		add(inputButton);
		add(optionButton);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void showMessageDialog(){
		//JOptionPane.showMessageDialog(this, "���ϴ� ������~~~~");
		JOptionPane.showMessageDialog(this, "���� �� ����..","��������", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showConfirmDialog(){
		//int answer = JOptionPane.showConfirmDialog(this, "�¿�� �� �Ծ���?");
		int answer = JOptionPane.showConfirmDialog(this, "�¿�� �� �Ծ���?", "����ϴ�", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		switch (answer) {
			case JOptionPane.OK_OPTION:
				System.out.println("������");			
				break;
			case JOptionPane.NO_OPTION:
				System.out.println("����������");			
				break;
			default:
				System.out.println("�߱��?");	
		}
	}
	
	public void inputDialog(){
		//String food = JOptionPane.showInputDialog(this, "�� �Ծ���?");
		
		//String[] foods = {"������", "�ø�", "��â", "��ġ������"};
		//String food = (String)JOptionPane.showInputDialog(this, "�����ϴ� ����", "��������", JOptionPane.QUESTION_MESSAGE, null, foods, foods[0]);
		Days food = (Days) JOptionPane.showInputDialog(this, "�����ϴ� ������?", "Poll", JOptionPane.QUESTION_MESSAGE, null, Days.values(), Days.values()[6]);
		System.out.println(food + "�Ծ�����~~~~");
	}
	
	public void optionDialog(){
		// ��ư �� ���� ����
		String[] buttons = {"�α���", "ȸ������", "���"};
		int answer = JOptionPane.showOptionDialog(this, "���� �̵��ұ��", "Ÿ��Ʋ", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		messageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMessageDialog();
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showConfirmDialog();
			}
		});
		
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputDialog();
			}
		});
		
		optionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optionDialog();
			}
		});
	}

	public static void main(String[] args) {
		JOptionPaneFrame frame = new JOptionPaneFrame();
		frame.setContents();
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






