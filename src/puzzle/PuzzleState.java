/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import framework.State;
import puzzle.PuzzleMove.Coordinates;

/**
 *
 * @author Schoen
 */
public class PuzzleState implements State {

    public PuzzleState(int[][] state) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.state[i][j] = state[i][j];
            }
        }

    }
    
    public PuzzleState(PuzzleState puzzleState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.state[i][j] = (puzzleState.getState())[i][j];
            }
        }
    }

    public int[][] getState() {
        return state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }

    public int getTile(int i, int j) {
        return state[i][j];
    }
    
    public void setTile(int tileNumber, Coordinates coordinates) {
        state[coordinates.i][coordinates.j] = tileNumber;        
    }

    int[][] state = new int[][]{
        {2, 8, 3},
        {1, 6, 4},
        {7, 0, 5}
    };

}
