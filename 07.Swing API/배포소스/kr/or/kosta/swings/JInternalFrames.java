package kr.or.kosta.swings;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class JInternalFrames extends JFrame {
	
	JDesktopPane desktopPanel;
	JInternalFrame jif, jif2;
	
	public JInternalFrames() {
		this("����������Ʈ��...");
	}

	public JInternalFrames(String title) {
		super(title);
		desktopPanel = new JDesktopPane();
	}

	public void setContents() {
		// ���� �������� �г� ��ü
		setContentPane(desktopPanel);
		//jif = new JInternalFrame("����������");
		jif = new JInternalFrame("����������", true, true, true, true);
		jif.setSize(400, 400);
		jif.setVisible(true);
		
		jif2 = new JInternalFrame("����������2", true, true, true, true);
		//jif2.setSize(200, 200);
		jif2.setBounds(300, 100, 200, 200);
		jif2.setVisible(true);
		
		add(jif);
		add(jif2);
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
		JInternalFrames frame = new JInternalFrames();
		frame.setContents();
		frame.setSize(600, 500);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






