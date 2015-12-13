import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener,ActionListener{
	
	//properties
	GameManager manager;
	private Timer timer; //for updating the panel
	
	public GamePanel(int dim1, int dim2){
		
		//initializations
		manager = new GameManager();
		addKeyListener(this);
//		timer = new Timer(,this);
//		timer.start();
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.GRAY);
	}
	
	//*****************************************************************
	//  Represents a listener for key (action) events.
	//*****************************************************************
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) // for moving the left
            manager.changeDirection(false);
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) // for moving the right
            manager.changeDirection(true);
    }
   
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    //unused methods of KeyListener
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
}
