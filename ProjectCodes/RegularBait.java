public class RegularBait extends Bait{
  
  public RegularBait(Piece piece){
    
    super.color = "Black";
    super.snake = null;
    super.baitPiece = piece;
    
  }
   @Override
    public void affect() {
       
    }
  
  
  @Override
  public void setSnake(Snake snake){
	super.snake = snake;  
  }
