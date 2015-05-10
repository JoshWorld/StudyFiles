package kr.or.kosta.notepad;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ���ڽ�Ʈ��(BufferedReader/PrintWriter)�� �̿���
 * �޸��� ���ø����̼� �ۼ�
 */
public class JNotepadUI extends JFrame {
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newMI, openMI, saveMI, exitMI;
	
	JTextArea textArea;
	
	public JNotepadUI() {
		this("�ڹ� �޸���");
	}

	public JNotepadUI(String title) {
		super(title);
		menuBar = new JMenuBar();
		fileMenu = new JMenu("����");
		newMI = new JMenuItem("���θ����");
		openMI = new JMenuItem("����");
		saveMI = new JMenuItem("����");
		exitMI = new JMenuItem("����");
		textArea = new JTextArea();
	}
	
	public void setMenu(){
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
	}
	
	public void setContents() {
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	/** ���� ó�� */
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
		JNotepadUI ui = new JNotepadUI();
		ui.setMenu();
		ui.setContents();
		GUIUtil.setFullScreen(ui);
		GUIUtil.setLookNFeel(ui, GUIUtil.STYLE_NIMBUS);
		ui.setVisible(true);
		ui.eventRegist();
	}
}
