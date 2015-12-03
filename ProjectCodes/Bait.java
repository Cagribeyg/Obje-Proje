/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
public abstract class Bait {
    
    protected String color;
    protected Snake snake;
    protected Piece baitPiece;
    
    
    public abstract void affect();
    public abstract void setSnake(Snake snake);
    
    
    
}