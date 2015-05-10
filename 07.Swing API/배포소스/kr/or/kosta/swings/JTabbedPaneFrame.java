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
		this("½ºÀ®ÄÄÆ÷³ÍÆ®µé...");
	}

	public JTabbedPaneFrame(String title) {
		super(title);
		tabPane = new JTabbedPane();
		tabPane.addTab("°èÁÂµî·Ï", createImageIcon("add_index.gif"), new JLabel("°èÁÂµî·Ï È­¸éÀÔ´Ï´Ù.."));
		tabPane.addTab("°èÁÂ¸ñ·Ï", createImageIcon("add_index.gif"), new JLabel("°èÁÂ¸ñ·Ï È­¸éÀÔ´Ï´Ù.."));
		tabPane.addTab("°èÁÂ°Ë»ö", createImageIcon("add_index.gif"), new JLabel("°èÁÂ°Ë»ö È­¸éÀÔ´Ï´Ù.."));
		tabPane.addTab("°èÁÂ»èÁ¦", createImageIcon("add_index.gif"), new JLabel("°èÁÂ»èÁ¦ È­¸éÀÔ´Ï´Ù.."));
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






