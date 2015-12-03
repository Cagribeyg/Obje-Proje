
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
    
    public Snake(Piece head)
    {
        length = 1;
        score = 0;
        direction = 1;
        snakeParts = new LinkedList<Piece>();
        
        snakeParts.add(head);
    }
    
    public void die(boolean isSuperSnake)
    {
        if(isSuperSnake)
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
    
    public void moveRegular() //regular movement of the snake. Simply get the last piece and put it to the end so it is like movement.
    {
        snakeParts.addFirst(snakeParts.pollLast());//we should change the coordinates
        
        //We must change the arena according to this
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
}
