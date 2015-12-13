public class ExtendingBait extends Bait{
  
  public ExtendingBait(Piece piece){
    
    super.color = "Blue";
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
  @Override
  public Piece retrievePiece() {
      return baitPiece;
  }
}
