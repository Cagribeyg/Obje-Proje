
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameInner extends JPanel implements KeyListener,ActionListener{
	
	private GameManager manager;
	private Timer timer;
	
	public GameInner(){
		manager = new GameManager();
		addKeyListener(this);
		timer = new Timer(30, this);
		timer.start();
		
		setPreferredSize(new Dimension(1000,1000));
		setBackground(Color.red);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	    manager.getArena().createScreen(g);  
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
        //repaint();
    }
    
    //unused methods of KeyListener
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
}
