package kr.or.kosta.swings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class JProgressBarFrame extends JFrame {
	JProgressBar pb;
	JSlider slier;
	JSpinner spinner;
	
	public JProgressBarFrame() {
		this("����������Ʈ��...");
	}

	public JProgressBarFrame(String title) {
		super(title);
		//pb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		pb = new JProgressBar(0, 100);
		pb.setValue(50);
		//pb.setForeground(Color.cyan);
		pb.setStringPainted(true);
		
		slier = new JSlider(0, 100, 50);
		slier.setPaintTicks(true);
		slier.setPaintLabels(true);
		slier.setMajorTickSpacing(100);
		//slier.setMinorTickSpacing(10);
		
		spinner = new JSpinner();
	}
	
	public void progress(){
		for(int i=0; i<=100; i++){
			pb.setValue(i);
			pb.setString(i+"% ������");
			if(i==100){
				pb.setString("����Ϸ�");
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setContents() {
		setLayout(new FlowLayout());
		add(pb);
		add(slier);
		add(spinner);
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
		JProgressBarFrame frame = new JProgressBarFrame();
		frame.setContents();
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.eventRegist();
		frame.progress();
	}
}






