public class BonusPointBait extends Bait{
  
  public BonusPointBait(Piece piece){
    
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
    @Override
    public Piece retrievePiece() {
        return baitPiece;
    }
}