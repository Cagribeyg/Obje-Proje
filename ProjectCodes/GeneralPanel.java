/*
 * GeneralPanel : Handles the panel switches between the panels of the game
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class GeneralPanel extends JPanel{ 
	
	//Properties
	private HelpPanel help;
	private CreditsPanel credits;
	public GamePanel gamePanel;
	//public GameOverPanel gameOver;
	private WelcomingPanel welcome;
	public JPanel GENERAL; 
	public JButton backButton1, backButton2, backButton3;
	private CardLayout card;
	
	//CONSTANTS
	int PANEL_DIM1 = 800;
	int PANEL_DIM2 = 800;
	
	
	//CONSTRUCTOR
	public GeneralPanel(){
		
		//Initializing Back Buttons
		backButton1 = new JButton("BACK TO MAIN");
		backButton1.setFont(new Font ("Comic Sans MS", Font.ITALIC, 12));
		backButton1.addActionListener(new BackButtonListener());
		backButton2 = new JButton("BACK TO MAIN");
		backButton2.setFont(new Font ("Comic Sans MS", Font.ITALIC, 12));
		backButton2.addActionListener(new BackButtonListener());
		backButton3 = new JButton("BACK MAIN");
		backButton3.setFont(new Font ("Comic Sans MS", Font.ITALIC, 12));
		backButton3.addActionListener(new BackButtonListener());
		
		//Initializing the Inner Panels
		welcome = new WelcomingPanel(this,PANEL_DIM1, PANEL_DIM2);
		help = new HelpPanel(PANEL_DIM1,PANEL_DIM2);
		help.add(backButton1, BorderLayout.PAGE_START);
		credits = new CreditsPanel(PANEL_DIM1,PANEL_DIM2);
		credits.add(backButton2, BorderLayout.PAGE_START);
		gamePanel = new GamePanel(PANEL_DIM1,PANEL_DIM2);
		gamePanel.add(backButton3, BorderLayout.PAGE_START);
		
		//gameOver = new GameOverPanel(PANEL_DIM1, PANEL_DIM2);
		
		
		//Initialization of Outer Panel
		GENERAL = new JPanel();
		card = new CardLayout();
		GENERAL.setPreferredSize(new Dimension(PANEL_DIM1,PANEL_DIM2));
		GENERAL.setBackground(Color.gray);
		GENERAL.setLayout(card);
		
		//cards into GENERAL
		GENERAL.add(welcome, "Welcome");
		GENERAL.add(help, "Help");
		GENERAL.add(credits, "Credits");
		GENERAL.add(gamePanel, "GamePanel");

		add(GENERAL);
		card.show(GENERAL, "Welcome");
	    setPreferredSize (new Dimension(PANEL_DIM1, PANEL_DIM2));
	    setBackground (Color.GRAY);
	}
	
	/*
	 * Determines the action of the backButton, changes the panel back to cellView
	 */
	private class BackButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			
			removeAll();
			add ( new GeneralPanel());
			card.show(GENERAL, "Welcome");
			revalidate();
			repaint();
		}
	}
	
	/*
	 * Updates the view of General Panel
	 */
	public void updateView(int ins, JPanel oldPanel){
		
		//opens up helpPanel
		if(ins == 1){
			card.show(GENERAL, "Help");
			revalidate();
			repaint();
		}
		
		else if (ins == 2){
			card.show(GENERAL, "Credits");
			revalidate();
			repaint();
		}
		else if (ins == 3){
			card.show(GENERAL, "GamePanel");
			revalidate();
			repaint();
		}
		else
			return;
		
	}
}
