
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
            
        //this.printScore();
    }
    private BufferedWriter writer;
    private BufferedReader reader;
    private FileReader file;
    private FileWriter fileWriter;
    public void  writeScoreToFile(String name,String score){
        String temp ="";
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        StringTokenizer tokenizer ;
        try{
            file = new FileReader("scores.txt");
        reader = new BufferedReader(file);
        while (reader.ready()){
            temp = reader.readLine();
            tokenizer = new StringTokenizer(temp);
            names.add(tokenizer.nextToken());
            scores.add(Integer.parseInt(tokenizer.nextToken()));
        }
        reader.close();
        names.add(name);
        scores.add(Integer.parseInt(score));
        int tempInt;
        String tempString;
        for(int i = 0; i < scores.size() - 1; i++){
            for(int j = i+1 ; j < scores.size(); j++)
            {
                if(scores.get(i)> scores.get(j))
                {
                    tempInt = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, tempInt);
                    tempString = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, tempString);

                }
            }
        }
        fileWriter = new FileWriter("scores.txt");
        temp ="";
        if(names.size() <=  10)
        {
            for (int i = 0; i < names.size(); i++)
                temp = temp + names.get(i) + " " + scores.get(i) + "\n";
        }
        else
         {
            for (int i = 0; i < 10; i++)
                temp = temp + names.get(i) + " " + scores.get(i) + "\n";
        }

        writer = new BufferedWriter(fileWriter);
        writer.write(temp);
        writer.close();
        }catch(IOException e){

        }

    }

    //this method clears the high score list
    public void clearAllScores(){
        try{
        fileWriter = new FileWriter("scores.txt");
        String temp ="";
        writer = new BufferedWriter(fileWriter);
        writer.write(temp);
        writer.close();
        }catch(IOException e){

        }


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
        Piece first = snakeParts.getFirst();
        Piece tmp;
        if(length>0)
        {     
            if(direction==0)
            {   
                tmp = new Piece(first.getX(),first.getY()-1,1);
                snakeParts.addFirst(tmp);
                board[first.getX()][first.getY()] = tmp;              
                        
                if(length>1){
                    for(int i=1;i<length;i++)
                    {
                        tmp = new Piece(last.getX(),last.getY()+i,1);
                        snakeParts.addLast(tmp);
                        board[last.getX()][last.getY()] = tmp;
                    }
            }
            }
            else if(direction==1)
            {
                tmp = new Piece(first.getX()+1,first.getY(),1);
                snakeParts.addFirst(tmp);
                board[first.getX()][first.getY()] = tmp;              
                        
                if(length>1){
                    for(int i=1;i<length;i++)
                    {
                        tmp = new Piece(last.getX()-i,last.getY(),1);
                        snakeParts.addLast(tmp);
                        board[last.getX()][last.getY()] = tmp;
                    }
                }
            }
            else if(direction==2)
            {
                tmp = new Piece(first.getX(),first.getY()+1,1);
                snakeParts.addFirst(tmp);
                board[first.getX()][first.getY()] = tmp;              
                        
                if(length>1){
                    for(int i=1;i<length;i++)
                    {
                        tmp = new Piece(last.getX(),last.getY()-i,1);
                        snakeParts.addLast(tmp);
                        board[last.getX()][last.getY()] = tmp;
                    }
                }
            }
            else
            {
                tmp = new Piece(first.getX()-1,first.getY(),1);
                snakeParts.addFirst(tmp);
                board[first.getX()][first.getY()] = tmp;              
                        
                if(length>1){
                    for(int i=1;i<length;i++)
                    {
                        tmp = new Piece(last.getX()+i,last.getY(),1);
                        snakeParts.addLast(tmp);
                        board[last.getX()][last.getY()] = tmp;
                    }
                }
            } 

        }
        else if(length<snakeParts.size())//lenth<0 // todo
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
         board[last.getX()][last.getY()] = null;//free the prev location
        if(direction==0)
        {
            if(board[dest.getX()][dest.getY()-1] == null) //empty go johnny go
            {
                last.setY(yCoordinate-1);
                last.setX(xCoordinate);
                
                board[last.getX()][last.getY()] = last;
            }  
            else if(board[dest.getX()][dest.getY()-1].getType() != 0 && board[dest.getX()][dest.getY()-1].getType() != 1)//bait!
            {

                board[dest.getX()][dest.getY()-1] = null;
                return 1;
                
            }           
            else //Collision!
                return -1;
                
        }
        else if(direction==1)
        { 
 			       
            if(board[dest.getX()+1][dest.getY()] == null) //empty go johnny go
            {
                last.setX(xCoordinate+1);
                last.setY(yCoordinate);
                board[last.getX()][last.getY()] = last;
            }
            else if(board[dest.getX()+1][dest.getY()].getType() != 0 && board[dest.getX()+1][dest.getY()].getType() != 1)//bait!
            {

                board[dest.getX()+1][dest.getY()]=null;
                return 1;
                
            }           
            else //Collision!
                return -1;
                     
	            
        }
        else if(direction==2)
        {
            if(board[dest.getX()][dest.getY()+1] == null) //empty go johnny go
            {
                last.setY(yCoordinate+1);
                last.setX(xCoordinate);
                board[last.getX()][last.getY()] = last;
            }
            
            else if(board[dest.getX()][dest.getY()+1].getType() != 1 && board[dest.getX()][dest.getY()+1].getType() != 0)//bait!
            {

                board[dest.getX()][dest.getY()+1]=null;
                return 1;
                
            }           
            else //Collision!
                return -1;
        }
        else//direction 3
        {
            if(board[dest.getX()-1][dest.getY()] == null) //empty go johnny go
            {
                last.setX(xCoordinate-1);
                last.setY(yCoordinate);
                board[last.getX()][last.getY()] = last;
            }
            
            else if(board[dest.getX()-1][dest.getY()].getType() != 0 && board[dest.getX()-1][dest.getY()].getType() !=1)//bait!
            {

                board[dest.getX()-1][dest.getY()] = null;
                return 1;
                
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
