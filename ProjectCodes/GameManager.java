/*
 * Author : Zulal Bingol
 */

import java.util.Scanner;

public class GameManager {
	
	//Instances
	Arena arena;
	int highestScore; // WILL BE CHANGED
	
	//constructor for the controller of the game
	public GameManager(){
		createArena();
	}
	
	//additional createArena method for updating ???????
	public void createArena(){
		arena = new Arena();
	}
	
	//controls whether the snake has crashes the walls or not
	public boolean didCollide(Snake snake){
		if(arena.getSnake().moveRegular() == null){
			arena.getSnake().die();
			return true;
		}
		else {
			return false;
		}
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