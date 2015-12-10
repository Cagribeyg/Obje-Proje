/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class RegularBait extends Bait{
  
  public RegularBait(Piece piece){
    
    super.color = "Black";
    super.snake = null;
    super.baitPiece = piece;
    
  }
  
  
  
  @Override
  public void setSnake(Snake snake){
	super.snake = snake;  
  }
