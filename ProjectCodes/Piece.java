
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
class Piece {
    
    private int x;
    private int y;
    private int type; //0 for arena walls, 1 for snake, 2 for baits
    private Image image;
    private final Toolkit MY_TOOLS; 
    private int xFactor,yFactor;
    
    public Piece(int x,int y,int type)
    {
        this.x=x;
        this.y=y;
        this.type=type;
        MY_TOOLS = Toolkit.getDefaultToolkit();
        
        //images are created
        final String Piece_snake = "Piece_snake.png";
        final String Piece_wall = "Piece_wall.png";
        final String Piece_regularBait = "Piece_regularBait.png";
        final String Piece_BonusPoint = "Piece_BonusPoint.png";
        final String Piece_Extending = "Piece_Extending.png";
        final String Piece_Poisonous = "Piece_Poisonous.png";
        final String Piece_ShorteningBait = "Piece_ShorteningBait.png";
        final String Piece_SuperSnake = "Piece_SuperSnake.png";
        final String Piece_UpsideDown = "Piece_UpsideDown.png";
        
        /*
         * TYPES: 0: wall, 1: snake, 2: RegularBait, 3: BonusPointBait, 4: ExtendingBait
         * 		  5: PoisonousBait, 6: ShorteningBait, 7: SuperSnakeBait, 8: Piece_UpsideDown
         */
        if(type == 0){
        	image = MY_TOOLS.getImage(Piece_wall);
        }
        else if(type == 1){
        	image = MY_TOOLS.getImage(Piece_snake);
        }
        else if (type == 2){
        	image = MY_TOOLS.getImage(Piece_regularBait);
        }
        else if (type == 3){
        	image = MY_TOOLS.getImage(Piece_BonusPoint);
        }
        else if(type == 4){
        	image = MY_TOOLS.getImage(Piece_Extending);
        }
        else if(type == 5){
        	image = MY_TOOLS.getImage(Piece_Poisonous);
        }
        else if(type == 6){
        	image = MY_TOOLS.getImage(Piece_ShorteningBait);
        }
        else if(type == 7){
        	image = MY_TOOLS.getImage(Piece_SuperSnake);
        }
        else if(type == 8){
        	image = MY_TOOLS.getImage(Piece_UpsideDown);
        }
        else 
        	image = null;
    }
    
    
   public void setX(int x)
   {
       this.x=x;
   }
   
   public void setY(int y)
   {
       this.y=y;
   }
   
   public void setFactors(int x,int y)
   {
       xFactor = x;
       yFactor = y;
   }
   
   public int getX()
   {
       return x;
   }
   
   public void setType(int x)
   {
       type = x;
   }
   
   public int getY()
   {
       return y;
   }
   
   public int getType()
   {
       return type;
   }
   
   public Image getImage()
   {
       return image;
   }
   public void setImage(Image img)
   {
       image=img;
   }
  
   public void draw(Graphics g)
   {
	   if( !(image == null))
		   g.drawImage(image, xFactor, yFactor, null);
   }
   
}
