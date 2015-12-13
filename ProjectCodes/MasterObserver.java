
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cihan
 */
public class MasterObserver {
    
    private ArrayList<Observer> observers = new ArrayList<Observer>() {};
    
    public void add(Observer obs)
    {
        observers.add(obs);
    }
    
    public void notifyObservers()
    {
        for(Observer obs : observers )
        {
            obs.update();
        }
    }
    
}
