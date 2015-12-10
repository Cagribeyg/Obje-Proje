public class SuperSnakeBait extends Bait{
  
  public SuperSnakeBait(Piece piece){
    
    super.color = "Red";
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
