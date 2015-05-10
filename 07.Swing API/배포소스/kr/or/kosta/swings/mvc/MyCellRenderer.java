package kr.or.kosta.swings.mvc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
/**
 * ����� ���� ListCellRenderer
 * @author �����
 *
 */
public class MyCellRenderer implements ListCellRenderer<String> {

	@Override
	// JList�� ���� �ڵ� ȣ��Ǵ� �ݹ�޼ҵ�
	public Component getListCellRendererComponent(JList<? extends String> list,
			String value, int index, boolean isSelected, boolean cellHasFocus) {
		JButton render = new JButton();
		render.setText(value);
		render.setIcon(new ImageIcon("classes/images/add_index.gif"));
		if(isSelected){
			render.setOpaque(true);
			render.setBackground(Color.red);
			render.setForeground(Color.yellow);
		}
		return render;
	}

}
