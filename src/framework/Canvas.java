/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Ben Schoenfeld
 */
public abstract class Canvas extends JComponent {
   
    
    public Canvas(State state) {
        
        currentCanvasState = state;
       
    }
    
    private State currentCanvasState;
   

     public State getCanvasState() {
         return currentCanvasState;
    }

    public void setCanvasState(State canvasState) {
        this.currentCanvasState = canvasState;
    }
    
    public void resetWater() {};
    
    public void render(State state) {}
    
    
    
}
