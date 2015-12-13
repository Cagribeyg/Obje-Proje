/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;

/**
 *
 * @author Cihan
 */
public abstract class Observer{
    protected MasterObserver master;
    public abstract void update(Graphics g);
}
