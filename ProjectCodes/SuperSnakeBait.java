public class SuperSnakeBait extends Bait{
  
  public SuperSnakeBait(Piece piece){
    
    super.color = "Red";
    super.snake = null;
    super.baitPiece = piece;
    
  }
  
  @Override 
  public void affect(){
  	snake.setScore(snake.getScore()+1);
        snake.setLength(snake.getLength()+1);
        snake.grow(1);
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
