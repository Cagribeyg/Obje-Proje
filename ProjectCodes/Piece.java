
import java.awt.Image;

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
    
    public Piece(int x,int y,int type)
    {
        this.x=x;
        this.y=y;
        this.type=type;
    }
    
    
   public void setX(int x)
   {
       this.x=x;
   }
   
   public void setY(int y)
   {
       this.y=y;
   }
   
   public int getX()
   {
       return x;
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
   
}
