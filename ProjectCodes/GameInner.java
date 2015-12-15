
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameInner extends JPanel implements KeyListener,ActionListener{
	
	private GameManager manager;
	private Timer timer;
	
	public GameInner(int dim1, int dim2){
		manager = new GameManager();
		addKeyListener(this);
		timer = new Timer(100, this);
		timer.start();
		
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.gray);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		requestFocusInWindow(true);
	    manager.notify(g);  
	}
	
	//*****************************************************************
	//  Represents a listener for key (action) events.
	//*****************************************************************
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT) // for moving the left
            manager.changeDirection(false);
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) // for moving the right
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
