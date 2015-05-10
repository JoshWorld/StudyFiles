package kr.or.kosta.notepad;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI���� ����� ���� �޼ҵ��..
 * @author �����
 *
 */
public class GUIUtil {
	public static final String STYLE_METAL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String STYLE_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String STYLE_MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String STYLE_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String STYLE_OS = UIManager.getSystemLookAndFeelClassName();
	
	
	// ȭ�� �߾� ��ġ
	public static void setCenterScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		//toolkit.beep();
		int x = (dim.width - container.getSize().width) / 2;
		int y = (dim.height - container.getSize().height) / 2;
		container.setLocation(x, y);
	}
	
	// ȭ�� Ǯ��ũ�� ��ġ
	public static void setFullScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		container.setSize(dim.width, dim.height);
		//container.setBounds(0, 0, dim.width, dim.height);
	}
	
	// ȭ�� �����(�׸�) ����
	public static void setLookNFeel(Container container, String lookNFeelName){
		try {
			UIManager.setLookAndFeel(lookNFeelName);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		SwingUtilities.updateComponentTreeUI(container);
	}

}







