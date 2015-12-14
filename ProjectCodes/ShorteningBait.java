public class ShorteningBait extends Bait{
  
  public ShorteningBait(Piece piece){
    
    super.color = "Purple";
    super.snake = null;
    super.baitPiece = piece;
    
  }
  
  @Override 
  public void affect(){
	  //Get current length
	  int currentLength = snake.getLength();
	  //Get current point
	  int currentPoint = snake.getScore();
	  //Reduce grotwh 3
	  snake.grow(-3);
	  //Decreasing length
	  snake.setLength(currentLength-3);
	  //Decreasing Point
	  snake.setScore(currentPoint-3);

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
