public class ExtendingBait extends Bait{
  
  public ExtendingBait(Piece piece){
    
    super.color = "Blue";
    super.snake = null;
    super.baitPiece = piece;
    
  }
  
  @Override 
  public void affect(){
	  //Getting current length
	  int currentLength = snake.getLength();
	  //Getting current score
	  int currentPoint = snake.getScore();
	  //growing snake by 3 piece
	  snake.grow(3);
	  //increasing length by 3
	  snake.setLength(currentLength+3);
	  //increasing score by 3
	  snake.setScore(currentPoint+3);

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
