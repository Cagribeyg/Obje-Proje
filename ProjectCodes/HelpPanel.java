import javax.swing.*;

import java.awt.*;


public class HelpPanel extends JPanel{
	public HelpPanel(int dim1, int dim2){
		
		setLayout(new BorderLayout());
		ImageIcon image = new ImageIcon("C:/Users/user/Desktop/SNAKE/SNAKE/snake.png");
		JLabel imageLabel = new JLabel(image);
		imageLabel.setBackground(Color.gray);
		
		JPanel panel = new JPanel();
		JLabel title = new JLabel("HOW TO PLAY");
		title.setFont(new Font("Buxton Sketch", Font.PLAIN, 40));
		title.setBackground(Color.GRAY);
		
		StringBuilder sb = new StringBuilder(500);
		sb.append("<html><br></br>").
			append("Snake - An Extraordinary Adventure is inspired by Snake game but with different aspects, various events and more fun.").
			append("<br>The Snake can be directed by the LEFT and RIGHT buttons of the keyboard.</br>").
			append("<br>Instead of just normal baits, there will be six different baits with different colors.</br>").
			append("<br></br>").
			append("<br>Here is the list: </br>").
			append("<br></br>").
			append("<br>Black Bait:		Regular</br>").
			append("<br>Purple Bait:	Shortening</br>").
			append("<br>Cyan Bait:		Bonus Point</br>").
			append("<br>Green Bait:		Poisonous</br>").
			append("<br>Yellow Bait:	Upside Down</br>").
			append("<br>Blue Bait:		Extending</br>").
			append("<br>Red Bait:		SuperSnake</br></html>");
		
		JLabel help = new JLabel(sb.toString());
		help.setFont(new Font("Buxton Sketch", Font.PLAIN, 18));
		panel.setPreferredSize(new Dimension(dim1,dim2));
		panel.add(title);
		panel.add(imageLabel);
		panel.add(help);
		add(panel, BorderLayout.CENTER);
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.GRAY);
	}
}
