/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ShorteningBait extends Bait{
  
  public ShorteningBait(Piece piece){
    
    super.color = "Purple";
    super.snake = null;
    super.baitPiece = piece;
    
  }
  
  @Override 
  public void affect(){
  
  }
  
  @Override
  public void setSnake(Snake snake){
	super.snake = snake;  
  }
