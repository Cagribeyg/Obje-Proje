import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
	
	public GamePanel(int dim1, int dim2){
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.GRAY);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(dim1,dim2));
		gamePanel.setBackground(Color.GRAY);
		
		add(gamePanel, BorderLayout.CENTER);
	}
}
