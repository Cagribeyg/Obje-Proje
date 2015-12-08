
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class WelcomingPanel extends JPanel{
	
	//Instances
	private GeneralPanel generalIns;
	
	//variables
	JPanel buttonPanel, titlePanel;
	JLabel gameTitle;
	JButton newGame, helpButton, creditsButton;
	
	//constructor
	public WelcomingPanel(GeneralPanel panel, int dim1, int dim2){
		
		this.generalIns = panel;
		
		//Initializations
		buttonPanel = new JPanel();
		gameTitle = new JLabel();
		titlePanel = new JPanel();
		newGame = new JButton("NEW GAME");
		helpButton = new JButton("HELP");
		creditsButton = new JButton("CREDITS");
		
		gameTitle.setText("<html>SNAKE<br>AN EXTRAORDINARY ADVENTURE</html>");
		gameTitle.setForeground(Color.GREEN);
		gameTitle.setFont(new Font("Buxton Sketch", Font.PLAIN, 50));			//TEXT ALIGNMENT? 
		gameTitle.setPreferredSize(new Dimension(400,400));
		titlePanel.setBackground(Color.GRAY);
		titlePanel.add(gameTitle);
		titlePanel.setPreferredSize(new Dimension(400,400));
		
		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.setPreferredSize(new Dimension(400,200));
		newGame.addActionListener(new ButtonListener());
		helpButton.addActionListener(new ButtonListener());
		creditsButton.addActionListener(new ButtonListener());
		buttonPanel.add(newGame);
		buttonPanel.add(helpButton);
		buttonPanel.add(creditsButton);
		buttonPanel.setBackground(Color.GRAY);
		
		add(titlePanel);
		add(buttonPanel);
		setPreferredSize (new Dimension(dim1, dim2));
	    setBackground (Color.GRAY);
	}
	
	
	//*****************************************************************
	//  Represents a listener for button push (action) events.
	//*****************************************************************
	private class ButtonListener implements ActionListener{
		
      public void actionPerformed (ActionEvent event)
      {
      	JButton currentButton = (JButton)event.getSource();
      	if (currentButton.equals(helpButton)){
      		openHelp();
      	}
      	else if (currentButton.equals(creditsButton)){
      		openCredits();
      	}
      	else if (currentButton.equals(newGame)){
      		openGamePanel();
      	}
      	else 
      		return;
      	
      }
	}
	
	/*
	 * ADDITIONAL PANELS FOR CALLING GENERAL PANEL TO CHANGE PANELS
	 */
	private void openHelp(){
		this.generalIns.updateView(1,this);
	}
	
	private void openCredits(){
		this.generalIns.updateView(2,this);
	}
	
	private void openGamePanel(){
		this.generalIns.updateView(3,this);
	}
}
