/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import framework.Canvas;
import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schoen
 */
public class PuzzleProblem extends Problem {

    public PuzzleProblem() {
        setIntroduction("Welcome to the 8-Puzzle Problem\n\n" +
                        "You are given a 3x3 board in which 8 numbered tiles can slie around.\n" +
                        "There is one blank space that hold no tile. A legal move consists\n" + 
                        "of sliding a tile into the blank space if the tile is adjacent ot it.\n" + 
                        "The goal is to move the tiles around until the board looks like the final\n" + 
                        "state below.\n" + 
                        "1 2 3\n" + 
                        "8   4\n" + 
                        "7 6 5");
        List<Move> puzzleMoves = new ArrayList<Move>();

        setCurrentState(new PuzzleState(new int[][]{
            {2, 8, 3},
            {1, 6, 4},
            {7, 0, 5}
        }));

        PuzzleMove t1 = new PuzzleMove("Slide Tile 1");
        puzzleMoves.add(t1);

        PuzzleMove t2 = new PuzzleMove("Slide Tile 2");
        puzzleMoves.add(t2);

        PuzzleMove t3 = new PuzzleMove("Slide Tile 3");
        puzzleMoves.add(t3);

        PuzzleMove t4 = new PuzzleMove("Slide Tile 4");
        puzzleMoves.add(t4);

        PuzzleMove t5 = new PuzzleMove("Slide Tile 5");
        puzzleMoves.add(t5);

        PuzzleMove t6 = new PuzzleMove("Slide Tile 6");
        puzzleMoves.add(t6);

        PuzzleMove t7 = new PuzzleMove("Slide Tile 7");
        puzzleMoves.add(t7);

        PuzzleMove t8 = new PuzzleMove("Slide Tile 8");
        puzzleMoves.add(t8);

        setMoves(puzzleMoves);

    }

    @Override
    public boolean success() {
        Object object = getCurrentState();
        if (object instanceof PuzzleState) {
            PuzzleState currentState = (PuzzleState) object;
            return currentState.getTile(0, 0) == 1
                    && currentState.getTile(0, 1) == 2
                    && currentState.getTile(0, 2) == 3
                    && currentState.getTile(1, 0) == 8
                    && currentState.getTile(1, 1) == 0
                    && currentState.getTile(1, 2) == 4
                    && currentState.getTile(2, 0) == 7
                    && currentState.getTile(2, 1) == 6
                    && currentState.getTile(2, 2) == 5;

        } else {
            return false;
        }

    }

    @Override
    public Canvas getCanvasState() {
        PuzzleCanvas puzzleCanvas = new PuzzleCanvas(this.getCurrentState());
        return puzzleCanvas;
    }

}
