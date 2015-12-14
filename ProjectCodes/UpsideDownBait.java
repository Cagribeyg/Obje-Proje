
public class UpsideDownBait extends Bait{
    
  public UpsideDownBait(Piece piece){
    
    super.color = "Yellow";
    super.snake = null;
    super.baitPiece = piece;
    
  }
  
  @Override 
  public void affect(){
  	snake.setScore(snake.getScore()+1);
        snake.setLength(snake.getLength()+1);
        snake.grow(1);
  	snake.reverse();
  }
  
  @Override
  public void setSnake(Snake snake){
	super.snake = snake;  
  }

    @Override
    public Piece retrievePiece() {
        return baitPiece;
    }
}
