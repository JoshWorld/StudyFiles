package kr.or.kosta.swings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JSplitePaneFrame extends JFrame {
	JSplitPane splitePane;
	JSplitPane rightSplitePane;
	
	public JSplitePaneFrame() {
		this("스윙컴포넌트들...");
	}

	public JSplitePaneFrame(String title) {
		super(title);
		splitePane = new JSplitPane();
		//splitePane.setOneTouchExpandable(true);
		rightSplitePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rightSplitePane.setTopComponent(new JButton("위쪽"));
		rightSplitePane.setBottomComponent(new JButton("아래쪽"));
		//splitePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitePane.setLeftComponent(new JButton("임시버튼"));
		splitePane.setRightComponent(rightSplitePane);
		
	}

	public void setContents() {
		add(splitePane, BorderLayout.CENTER);
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
		JSplitePaneFrame frame = new JSplitePaneFrame();
		frame.setContents();
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






