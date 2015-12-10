import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameOverPanel extends JPanel{
	
	public GameOverPanel(int dim1, int dim2){
		setLayout (new BorderLayout());
                JPanel panel = new JPanel();
                JLabel title = new JLabel("GAME OVER !");
                title.setFont(new Font("Buxton Sketch", Font.PLAIN, 40));
                title.setBackGround(Color.GRAY);
                
                
	}
}
