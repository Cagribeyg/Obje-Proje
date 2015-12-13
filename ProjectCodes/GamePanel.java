import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel{
	
	//properties
	GameManager manager;
	private Timer timer; //for updating the panel
	private GeneralPanel generalIns; //for returning to GeneralPanel at the end of the game
	private GameInner general;
	
	public GamePanel(GeneralPanel panel, int dim1, int dim2){
		
		//initializations
		this.generalIns = panel;
		general = new GameInner();
		general.setPreferredSize(new Dimension(dim1,dim2));
	
		setLayout(new BorderLayout());
		add(general, BorderLayout.CENTER);
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.GRAY);
	}
	
	//creates the view on the screen
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//	    manager.getArena().createScreen(g);  
//	}

	//for opening the GameOverPanel on the GeneralPanel----------------------HANDLE!!!!!
	private void openGameOver(){
		this.generalIns.updateView(4,this);
	}
	
	//*****************************************************************
	//  Represents a listener for key (action) events.
	//*****************************************************************
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode() == KeyEvent.VK_LEFT) // for moving the left
//            manager.changeDirection(false);
//        if(e.getKeyCode() == KeyEvent.VK_RIGHT) // for moving the right
//            manager.changeDirection(true);
//    }
//   
//    public void actionPerformed(ActionEvent e) {
//        //repaint();
//    }
//    
//    //unused methods of KeyListener
//    public void keyReleased(KeyEvent e) {
//    }
//    public void keyTyped(KeyEvent e) {
//    }
}
