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
  @Override
  public Piece retrievePiece() {
      return baitPiece;
  }
}
