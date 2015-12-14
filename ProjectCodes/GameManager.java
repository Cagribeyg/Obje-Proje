/*
 * Author : Zulal Bingol
 */

import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class GameManager {
	
    //Instances
    private Arena arena;
    private int highestScore; // WILL BE CHANGED
    private int moveStatus;
    private MasterObserver master;
    private Timer timer;
    
    //constructor for the controller of the game
    public GameManager(){
     master = new MasterObserver();
     createArena();
    }

    //additional createArena method for updating ???????
    public void createArena(){
    arena = new Arena(master);
    }
    
    public void notify(Graphics g)
    {
    	master.notifyObservers(g);
    }
           
    public void move()
    {
        arena.moveSnake();
    }
    
    public void changeDirection(boolean toRight)
    {
        arena.getSnake().move(toRight);
    }
	//controls whether the snake has crashes the walls or not
	public boolean didCollide(Snake snake){
            if(moveStatus == -1){ // todo
                    arena.getSnake().die();
                    arena.endGame();
                    return true;
            }
            else {
                    return false;
            }
	}
	
	public Arena getArena(){
            return this.arena;
	}
	
	//controls whether the snake eats the bait or not
	public boolean didEat(Snake snake){
            if(arena.eat() == true){
                    arena.getSnake().eatBait(arena.getActiveBait());
                    return true;
            }
            else 
                    return false;
	}
}