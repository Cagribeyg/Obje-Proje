/*
 *  GAME_GENERAL: Has the top level panel and the driver of the game
 */


import javax.swing.JFrame;


public class GAME_GENERAL {
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GeneralPanel game = new GeneralPanel();
		frame.getContentPane().add(game);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
