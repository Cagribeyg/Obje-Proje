
import javax.swing.*;
import java.awt.*;

public class CreditsPanel extends JPanel{
	
	public CreditsPanel(int dim1, int dim2){
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.GRAY);
		
		StringBuilder sb = new StringBuilder(500);
		sb.append("<html><br></br>").
			append("<br></br>").
			append("<br>Authors</br>").
			append("<br></br>").
			append("<br>Cihan Eryonucu</br>").
			append("<br>�a�r�bey G�vendik</br>").
			append("<br>Serhat �etinkaya</br>").
			append("<br>Z�lal Bing�l</br>");
		JLabel label = new JLabel(sb.toString());
		label.setFont(new Font("Buxton Sketch", Font.PLAIN, 40));
		label.setBackground(Color.GRAY);
		panel.add(label);
		add(panel, BorderLayout.CENTER);
	}
}
