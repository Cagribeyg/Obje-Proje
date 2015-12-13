
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
class Snake 
{
    private int length;
    private int score;
    private LinkedList<Piece> snakeParts;
    private int direction; //0 is up, 1 is right,2 is down, 3 is left
    private boolean isSuperSnake;
    
    public Snake(Piece[] parts)
    {
        length = 3;
        score = 0;
        direction = 1;
        snakeParts = new LinkedList<Piece>();
        
        snakeParts.add(parts[0]);//add head
        snakeParts.addLast(parts[1]);//add second part
        snakeParts.addLast(parts[2]);//add third part
        isSuperSnake = false;
        
    }
    
    public void die()
    {
        if(this.isSuperSnake)
            return;//todo
    }
    
    public void setLength(int size)
    {
        length = size;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void eatBait( Bait b)
    {
        b.setSnake(this);
    }
    
    public void grow(int length)
    {
        Piece last = snakeParts.getLast();
        if(length>0)
        {
            if(direction==0)
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setY(last.getY()+i);
                    snakeParts.addLast(last);
                }
            }
            else if(direction==1)
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setX(last.getX()-i);
                    snakeParts.addLast(last);
                }
            }
            else if(direction==2)
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setX(last.getX()-i);
                    snakeParts.addLast(last);
                }
            }
            else
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setX(last.getX()+i);
                    snakeParts.addLast(last);
                }
            }    
        }
        else//lenth<0
        {
                for(int i=1;i<(-1)*length+1;i++)
                {
                    snakeParts.removeLast();
                }
        }
    }
    
    public Piece moveRegular() //regular movement of the snake. Simply get the last piece and put it to the end so it is like movement.
    {
        Piece last = snakeParts.pollLast();
        int xCoordinate = snakeParts.getFirst().getX();
        int yCoordinate = snakeParts.getFirst().getY();
        if(direction==0)
        {
            last.setY(yCoordinate-1);
        }
        else if(direction==1)
        {
            last.setX(xCoordinate+1);
        }
        else if(direction==2)
        {
            last.setY(yCoordinate+1);
        }
        else
        {
            last.setX(xCoordinate-1);
        }
        
        snakeParts.addFirst(last);//we should change the coordinates
        
        return last;
        
        //We must change the arena according to this
    }
    
    public Piece getTail()
    {
        return snakeParts.getLast();
    }
    public void move(boolean toRight)
    {
        if(toRight && direction !=3)
            direction++;
        else if(toRight && direction ==3)
            direction =0;
        else if(!toRight && direction !=0)
            direction--;
        else//!toRight && direction ==3
            direction=3;
           
    }
    
    //makes the snake SuperSnake by bait's affect method
    public void makeSuper(){
    	this.isSuperSnake = true;
    }
}
