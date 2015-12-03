
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
    
    private double x;
    private double y;
    private int type;
    private Image image;
    
    public Piece(double x,double y,int type)
    {
        this.x=x;
        this.y=y;
        this.type=type;
    }
    
    
   public void setX(double x)
   {
       this.x=x;
   }
   
   public void setY(double y)
   {
       this.y=y;
   }
   
   public double getX()
   {
       return x;
   }
   
   public double getY()
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
