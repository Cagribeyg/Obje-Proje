
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
public class Arena {
    private Snake snake;
    private Piece[][] board;
    private ArrayList<Bait> baits;
    private Random generator;
    private final int sizeOfArena=100;
    
    public Arena()
    {
        //creating the board
        board = new Piece[sizeOfArena][];//Size may be change
        for(int i=0;i<sizeOfArena;i++)
            board[i] = new Piece[sizeOfArena];
        
        //creating walls
        createWalls();
        
        //creating snake
        snake = createSnake();
        
    }
    
    public void createWalls()
    {
        for(int i=0;i<sizeOfArena;i++)
            for(int j=0;j<sizeOfArena;j++)
            {
                if(i==0 || i==sizeOfArena)//put wall through the row
                {
                    board[i][j] = new Piece(i,j,0);//put the wall
                }
                else//only 2 walls
                {
                    board[i][0] = new Piece(i,0,0);//put the wall at the beggining of the row
                    board[i][sizeOfArena-1] = new Piece(i,sizeOfArena-1,0);//put the wall at the end of the row
                    break;
                }
            }
        
    }
    public Snake createSnake()
    {
        Piece head = new Piece(sizeOfArena/2,sizeOfArena/2,1);//middle of the arena
        Piece part2 = new Piece((sizeOfArena/2)-1,sizeOfArena/2,1);//secondPart
        Piece part3 = new Piece((sizeOfArena/2)-2,sizeOfArena/2,1);//third part
        
        board[head.getX()][head.getY()] = head;//save the snake to the arena
        board[part2.getX()][part2.getY()] = part2;
        board[part3.getX()][part3.getY()] = part3;
        
        Piece[] parts = new Piece[3];// pass it to the snake
        parts[0] = head;
        parts[1]= part2;
        parts[2] = part3;
        
        return new Snake(parts);
        
    }
}
