package kr.or.kosta.swings.mvc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 * 사용자 정의 ListCellRenderer
 * @author 김기정
 *
 */
public class ImageCellRender implements ListCellRenderer<Student> {

	@Override
	// 컨트롤러에 의해 자동 호출되는 콜백메소드
	public Component getListCellRendererComponent(JList<? extends Student> list,
			Student student, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel render = new JLabel();
		render.setText(student.getName()+ "("+student.getSsn()+")");// 김기정(학번);
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
