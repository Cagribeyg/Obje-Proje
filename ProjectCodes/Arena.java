
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.event.*;
import java.awt.Graphics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
public class Arena extends Observer{
	//Properties
    private Snake snake;
    private Piece[][] board;
    private ArrayList<Bait> baits;
    private Random generator;
    private int baitIndex;
    
    //CONSTANTS
    private final int BAIT_NUM = 30;
    private final int sizeOfArena = 100;
    
    //constructor
    public Arena(MasterObserver master)
    {
        //creating the board
        board = new Piece[sizeOfArena][];//Size may be change
        for(int i=0;i<sizeOfArena;i++)
            board[i] = new Piece[sizeOfArena];
        
        //creating walls
        createWalls();
        
        //creating snake
        snake = createSnake();
        
        //Random generator
        generator = new Random();
        //creating 30 baits
        createBaits();
        
        //initializing observers
        super.master = master;
        super.master.add(this);
        
        
    }
    
    public void createWalls()
    {
        for(int i=0;i<sizeOfArena;i++)
            for(int j=0;j<sizeOfArena;j++)
            {
                if(i==0 || i==sizeOfArena)//put wall through the row
                {
                    board[i][j] = new Piece(i,j,0);//put the wall
                }
                else//only 2 walls
                {
                    board[i][0] = new Piece(i,0,0);//put the wall at the beginning of the row
                    board[i][sizeOfArena-1] = new Piece(i,sizeOfArena-1,0);//put the wall at the end of the row
                    break;
                }
            }
        
    }
    
    public void createBaits()//creates the baits and fills the list with them
    {  
        //this list is bait occurence order.
        ArrayList<Integer> occurence = new ArrayList<Integer>();
        for (int i=1; i<BAIT_NUM; i++) {
            occurence.add(new Integer(i));
        }
        Collections.shuffle(occurence);
        
        //Creating x locations of the baits
        ArrayList<Integer> xLocations = new ArrayList<Integer>();
        for (int i=2; i<sizeOfArena-2; i++) {
            xLocations.add(new Integer(i));
        }
        Collections.shuffle(xLocations);
        
        //Creating y locations of the baits
        ArrayList<Integer> yLocations = new ArrayList<Integer>();
        for (int i=2; i<sizeOfArena-2; i++) {
            yLocations.add(new Integer(i));
        }
        Collections.shuffle(yLocations);
        
        //creating pieces for baits
        Piece[] baitPieces = new Piece[30];
        
        for(int i=0; i<sizeOfArena; i++)
        {
            baitPieces[i] = new Piece(xLocations.get(i),yLocations.get(i),2);
        }
        
        //create one special bait and fill other with regularBaits
        Bait tmp = new BonusPointBait(baitPieces[0]);
        baits.add(occurence.get(0),tmp);
        tmp = new ExtendingBait(baitPieces[1]);
        baits.add(occurence.get(1),tmp);
        tmp = new PoisonousBait(baitPieces[2]);
        baits.add(occurence.get(2),tmp);
        tmp = new ShorteningBait(baitPieces[3]);
        baits.add(occurence.get(3),tmp);
        tmp = new SuperSnakeBait(baitPieces[4]);
        baits.add(occurence.get(4),tmp);
        tmp = new UpsideDownBait(baitPieces[5]);
        baits.add(occurence.get(5),tmp);
        
        for(int i=6; i<BAIT_NUM;i++)
        {
            tmp = new RegularBait(baitPieces[i]);
            baits.add(occurence.get(i),tmp);
        }
            
    }
    
    //Places a random bait into the arena
    public Bait giveBait(){
    	baitIndex = generator.nextInt(BAIT_NUM);
    	board[baits.get(baitIndex).retrievePiece().getX()][baits.get(baitIndex).retrievePiece().getY()] = baits.get(baitIndex).retrievePiece();
    	return baits.get(baitIndex);
    }
    
    public Snake createSnake()
    {
        Piece head = new Piece(sizeOfArena/2,sizeOfArena/2,1);//middle of the arena
        Piece part2 = new Piece((sizeOfArena/2)-1,sizeOfArena/2,1);//secondPart
        Piece part3 = new Piece((sizeOfArena/2)-2,sizeOfArena/2,1);//third part
        
        board[head.getX()][head.getY()] = head;//save the snake to the arena
        board[part2.getX()][part2.getY()] = part2;
        board[part3.getX()][part3.getY()] = part3;
        
        Piece[] parts = new Piece[3];// pass it to the snake
        parts[0] = head;
        parts[1]= part2;
        parts[2] = part3;
        
        return new Snake(parts);
        
    }
    
    public Snake getSnake()
    {
        return this.snake;
    }
    
    public ArrayList<Bait> getBaits()
    {
        return this.baits;
    }
    
    //returns the bait which is current on the arena
    public Bait getActiveBait(){
    	return baits.get(baitIndex);
    }
    
    public boolean moveSnake()
    {
        Piece tail = snake.getTail();
        Piece newHead = snake.moveRegular();
        if(newHead == null)
            return false;
        board[tail.getX()][tail.getY()] = null;
        board[newHead.getX()][newHead.getY()] = newHead;
        return true;
    }
    
    //controls whether the snake has eaten the current bait or not
    public boolean eat(){ //todo
        return true;
    }

    //updates the view of the arena
    public void update(Graphics g) {
    	
    	//moving the snake
    	moveSnake();
    	
    	//redrawing the arena
        for (int i = 0; i < sizeOfArena; i++ ){
        	for(int j = 0; j < sizeOfArena; j++){
        		board[i][j].draw(g);
        		//repaint();
        	}
        }
    }
}
