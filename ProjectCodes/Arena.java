
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.Graphics;
import javax.swing.Timer;


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
    private Timer timer;
    private int status; //0 for moving, 1 for eating , -1 for dying
    private Bait current;
    
    //CONSTANTS
    private final int BAIT_NUM = 20;
    private final int sizeOfArena = 70;
    private final int WIDTH=10;
    private final int HEIGHT=10;
    
    //constructor
    public Arena(MasterObserver master)
    {
    	status=0;
        //creating the board
        board = new Piece[sizeOfArena][];//Size may be change
        for(int i=0;i<sizeOfArena;i++)
            board[i] = new Piece[sizeOfArena];
        
        //creating walls
        createWalls();
        
        //creating snake
        snake = createSnake();
        snake.initBoard(board);
        
        //Random generator
        generator = new Random();
        
        //creating 30 baits and putting one to board
        baits = new ArrayList<Bait>();
        createBaits();
        current  = giveBait(); 
        
        //initializing observers
        super.master = master;
        super.master.add(this);
        
        //initializing timer
        
    }
    
    //creates the initial screen of the game
	public void createScreen(Graphics g){            
            //coordinates
            int x=0;
            int y=0;   	
            //creating the arena View
            for (int i = 0; i < sizeOfArena; i++ ){                            
                for(int j = 0; j < sizeOfArena; j++){
                    if(board[i][j] != null)
                    {   
                        board[i][j].setFactors(x,y);   
                        board[i][j].draw(g);
                        
                    }
                    y += HEIGHT;
                    
	    	}
	    	y = 0;
	    	x += WIDTH;
	    }
	}
    
    public void createWalls()
    {
        for(int i=0;i<sizeOfArena;i++)
            for(int j=0;j<sizeOfArena;j++)
            {
                if(i==0 || i==sizeOfArena-1)//put wall through the row
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
        //Creating x locations of the baits
        ArrayList<Integer> xLocations = new ArrayList<Integer>();
        for (int i=1; i<sizeOfArena-2; i++) {
            xLocations.add(new Integer(i));
        }
        Collections.shuffle(xLocations);
        
        //Creating y locations of the baits
        ArrayList<Integer> yLocations = new ArrayList<Integer>();
        for (int i=1; i<sizeOfArena-2; i++) {
            yLocations.add(new Integer(i));
        }
        Collections.shuffle(yLocations);
        
        //creating pieces for baits
        Piece[] baitPieces = new Piece[BAIT_NUM];
        
        for(int i=0; i< BAIT_NUM; i++)
        {
            baitPieces[i] = new Piece(xLocations.get(i),yLocations.get(i),2);
        }
        
        //create one special bait and fill other with regularBaits
        baitPieces[0].setType(3);
        baitPieces[0].setImage(3);
        Bait tmp = new BonusPointBait(baitPieces[0]);
        baits.add(tmp);
        baitPieces[1].setType(4);
        baitPieces[1].setImage(4);
        tmp = new ExtendingBait(baitPieces[1]);
        baits.add(tmp);
        baitPieces[2].setType(5);
        baitPieces[2].setImage(5);
        tmp = new PoisonousBait(baitPieces[2]);
        baits.add(tmp);
        baitPieces[3].setType(6);
        baitPieces[3].setImage(6);
        tmp = new ShorteningBait(baitPieces[3]);
        baits.add(tmp);
        baitPieces[4].setType(7);
        baitPieces[4].setImage(7);
        tmp = new SuperSnakeBait(baitPieces[4]);
        baits.add(tmp);
        baitPieces[5].setType(8);
        baitPieces[5].setImage(8);
        tmp = new UpsideDownBait(baitPieces[5]);
        baits.add(tmp);
        
        for(int i=6; i<BAIT_NUM;i++)
        {
            tmp = new RegularBait(baitPieces[i]);
            baits.add(tmp);
        }
        //for(int i=0;i<BAIT_NUM;i++)
        //	System.out.println(baits.get(i).retrievePiece().getType());
        Collections.shuffle(baits);
            
    }
    
    //Places a random bait into the arena
    public Bait giveBait(){
        if(baits.size() == 0) //if there are no baits then create some
            createBaits();
        
    	board[baits.get(0).retrievePiece().getX()][baits.get(0).retrievePiece().getY()] = baits.get(0).retrievePiece();
        Bait tmp = baits.get(0);
        System.out.println("Bait"+tmp.retrievePiece().getType());
        baits.remove(0);
        
        return tmp;
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
    
    public void moveSnake()
    {
       status = snake.moveRegular();
       
    }
    
    //controls whether the snake has eaten the current bait or not
    public boolean eat(){ //todo
        return true;
    }

    //updates the view of the arena
    public void update(Graphics g) {
    	//moving the snake   	
    	createScreen(g);
    	moveSnake();
    	System.out.println(status);
    	if (status == 1) //eat
    	{
            snake.eatBait(current);
            current.affect();
            current  = giveBait();
    	}
    	status = snake.getStatus(); //this is because if the bait was poisonous or not
    	if(status == -1)//die
    	{
            endGame();
    	}
    	
    	status=0;
    	
    }
    
    //for ending the game
    public void endGame(){
    //	timer.stop();
    	System.exit(0);
    }
}
