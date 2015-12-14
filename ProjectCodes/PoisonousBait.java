/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
public class PoisonousBait extends Bait{
    
    public PoisonousBait(Piece piece)
    {
        super.color = "Green";
        super.snake = null;
        super.baitPiece = piece;
    }
    

    @Override
    public void affect() {
       snake.die();
    }

    @Override
    public void setSnake(Snake snake) {
        super.snake=snake;
    }
    @Override
    public Piece retrievePiece() {
        return baitPiece;
    }
    
}
