
public class UpsideDownBait extends Bait{
    
  public UpsideDownBait(Piece piece){
    
    super.color = "Yellow";
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
