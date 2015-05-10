package kr.or.kosta.swings;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class JToolbarFrame extends JFrame {
	JToolBar toolBar;
	JButton button1, button2;

	public JToolbarFrame() {
		this("½ºÀ®ÄÄÆ÷³ÍÆ®µé...");
	}

	public JToolbarFrame(String title) {
		super(title);
		toolBar = new JToolBar();
		button1 = new JButton(createImageIcon("images/back.gif"));
		button2 = new JButton(createImageIcon("images/add_index.gif"));
	}

	public void setContents() {
		toolBar.add(button1);
		toolBar.addSeparator();
		toolBar.add(button2);
		
		add(toolBar, BorderLayout.NORTH);
	}
	
	public ImageIcon createImageIcon(String  filePath) {
		return new ImageIcon("classes/" + filePath);
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
		JToolbarFrame frame = new JToolbarFrame();
		frame.setContents();
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






