
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
    private Piece[][] board;//this board is need for the movement of the snake and eating and stuff like that very crucial
    
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
            
        this.printScore();
    }
    public void printScore()
    {
        int curr_score = this.getScore();
        String str = Integer.toString(curr_score); 
        PrintWriter outputStream = null;
        
        try
        {
            outputStream = new PrintWriter (new FileOutputStream("high_scores.txt"));   
        }
        catch(FileNotFoundException e)
                {
                    System.out.println("Error Opening File high_scores.txt");
                }
        outputStream.println(str);
        outputStream.close();
        
    }
    public void initBoard(Piece[][] board)
    {
        this.board = board;
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
                    board[last.getX()][last.getY()] = last;
                }
            }
            else if(direction==1)
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setX(last.getX()-i);
                    snakeParts.addLast(last);
                    board[last.getX()][last.getY()] = last;
                }
            }
            else if(direction==2)
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setX(last.getX()-i);
                    snakeParts.addLast(last);
                    board[last.getX()][last.getY()] = last;
                }
            }
            else
            {
                for(int i=1;i<length+1;i++)
                {
                    last.setX(last.getX()+i);
                    snakeParts.addLast(last);
                    board[last.getX()][last.getY()] = last;
                }
            }    
        }
        else//lenth<0
        {
                for(int i=1;i<(-1)*length+1;i++)
                {
                    board[snakeParts.getLast().getX()][snakeParts.getLast().getY()] = null;
                    snakeParts.removeLast();
                    
                }
        }
    }
    
    public int moveRegular() //regular movement of the snake. Simply get the last piece and put it to the end so it is like movement.
    {                           //also checks collision //to do     
        Piece last = snakeParts.getLast();
        int xCoordinate = snakeParts.getFirst().getX();
        int yCoordinate = snakeParts.getFirst().getY();
        Piece dest = snakeParts.getFirst();
        if(direction==0)
        {
            if(board[dest.getX()][dest.getY()-1] == null) //empty go johnny go
            {
                board[last.getX()][last.getY()] = null;//free the prev location
                last.setY(yCoordinate-1);
                last.setX(xCoordinate);
                
                board[last.getX()][last.getY()] = last;
            }  
            else if(board[dest.getX()][dest.getY()-1].getType() != 0 && board[dest.getX()][dest.getY()-1].getType() != 1)//bait!
            {
                if(board[dest.getX()][dest.getY()-1].getType() == 2)//regular
                {
                                        
                }
            }           
            else //Collision!
                return -1;
                
        }
        else if(direction==1)
        { 
 			       
            if(board[dest.getX()+1][dest.getY()] == null) //empty go johnny go
            {
                board[last.getX()][last.getY()] = null;
                last.setX(xCoordinate+1);
                last.setY(yCoordinate);
                board[last.getX()][last.getY()] = last;
            }
        	else if(board[dest.getX()+1][dest.getY()].getType() == 2)//bait!
            {
                //to do
            }           
            else //Collision!
                return -1;
                     
	            
        }
        else if(direction==2)
        {
            if(board[dest.getX()][dest.getY()+1] == null) //empty go johnny go
            {
                board[last.getX()][last.getY()] = null;
                last.setY(yCoordinate+1);
                last.setX(xCoordinate);
                board[last.getX()][last.getY()] = last;
            }
            
            else if(board[dest.getX()][dest.getY()+1].getType() != 2)//bait!
            {
                //to do
            }           
            else //Collision!
                return -1;
        }
        else//direction 3
        {
            if(board[dest.getX()-1][dest.getY()] == null) //empty go johnny go
            {
                board[last.getX()][last.getY()] = null;
                last.setX(xCoordinate-1);
                last.setY(yCoordinate);
                board[last.getX()][last.getY()] = last;
            }
            
            else if(board[dest.getX()-1][dest.getY()].getType() == 2)//bait!
            {
                //to do
            }           
            else //Collision!
                return -1;
        }
        snakeParts.remove(snakeParts.size()-1);
        snakeParts.addFirst(last);//we should change the coordinates
        
        return 0;
        
        //We must change the arena according to this //done!
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
    public void reverse()
    {
        LinkedList<Piece> tmp = new LinkedList<Piece>();
        while(!snakeParts.isEmpty())
        {
            tmp.addLast(snakeParts.pollLast());
        }
        snakeParts = tmp;
    }
    //makes the snake SuperSnake by bait's affect method
    public void makeSuper(){
    	this.isSuperSnake = true;
    }
}
