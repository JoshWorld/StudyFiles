package kr.or.kosta.swings.mvc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 * ����� ���� ListCellRenderer
 * @author �����
 *
 */
public class ImageCellRender implements ListCellRenderer<Student> {

	@Override
	// ��Ʈ�ѷ��� ���� �ڵ� ȣ��Ǵ� �ݹ�޼ҵ�
	public Component getListCellRendererComponent(JList<? extends Student> list,
			Student student, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel render = new JLabel();
		render.setText(student.getName()+ "("+student.getSsn()+")");// �����(�й�);
		//render.setIcon(student.getIcon());
		if(isSelected){
			render.setOpaque(true);
			render.setBackground(Color.yellow);
			String message = student.getName()+ "," + student.getMajor();
			render.setToolTipText(message);
		}
		return render;
	}

}
