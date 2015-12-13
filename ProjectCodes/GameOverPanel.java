import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameOverPanel extends JPanel{
	
	public GameOverPanel(int dim1, int dim2){
		setLayout (new BorderLayout());
                JPanel panel = new JPanel();
                JLabel title = new JLabel("GAME OVER !");
                title.setFont(new Font("Buxton Sketch", Font.PLAIN, 40));

                title.setBackground(Color.GRAY);
                
                StringBuilder sb = new StringBuilder(500);
                StringBuilder sb2 = new StringBuilder(500);
                sb.append("<html><br></br>").
                        append("The Game is over.").
                        append("<br></br>").
                        append("<br>Your Score is:</br>").
                        append("<br></br>");
                String result = sb.toString();
                
               
                String currentLine;
                String temp = "";
                try
                {
                    BufferedReader reader = new BufferedReader(new FileReader("high_scores.txt"));
                    while((currentLine=reader.readLine())!=null)
                    {
                        temp="";
                        temp=currentLine;                    
                    }
                }
                catch(IOException e)
                        {}
                
                result = result.concat(temp);
                
                JLabel gameOver = new JLabel(result);
                gameOver.setFont(new Font("Buxton Sketch", Font.PLAIN, 18));
                panel.setPreferredSize(new Dimension(dim1,dim2));
		panel.add(title);
		panel.add(gameOver);
		
        add(panel, BorderLayout.CENTER);
		setPreferredSize(new Dimension(dim1,dim2));
		setBackground(Color.GRAY);
        title.setBackground(Color.GRAY);
 
	}
}
