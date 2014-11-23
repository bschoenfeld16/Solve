package waterjug;

import java.util.List;
import framework.Problem;
import framework.State;
import framework.Move;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugProblem class. You should use the
 * BridgeProblemTest class as a model.
 *
 * @author Ben Schoenfeld
 */
public class WaterJugProblemTest {

    // You should use the BridgeProblemTest class as a model for setting up
    // the tests with private instance fields and methods here.
    private Problem problem = new WaterJugProblem();

    private List<Move> moves = problem.getMoves();

    private Move findMove(String moveName) {
        for (Move move : moves) {
            if (move.getMoveName().equals(moveName)) {
                return move;
            }
        }
        return null;
    }

    private Move fillX;
    private Move fillY;
    private Move emptyX;
    private Move emptyY;
    private Move transferXtoY;
    private Move transferYtoX;
    
    private void tryMove(Move move) {
        State state = problem.getCurrentState();
        State next = move.doMove(state);
        problem.setCurrentState(next);
    }

    private void initializeMoves() {
        fillX = findMove("Fill Jug X");
        fillY = findMove("Fill Jug Y");
        emptyX = findMove("Empty Jug X");
        emptyY = findMove("Empty Jug Y");
        transferXtoY = findMove("Transfer Jug X to Jug Y");
        transferYtoX = findMove("Transfer Jug Y to Jug X");
    }

    /**
     * Tests to be sure the problem represents all the moves.
     */
    @Test
    public void testMoves() {
        initializeMoves();
        assertTrue(fillX != null);
        assertTrue(fillY != null);
        assertTrue(emptyX != null);
        assertTrue(emptyY != null);
        assertTrue(transferXtoY != null);
        assertTrue(transferYtoX != null);
        

    }

    /**
     * Tests the 4-move solution to the water jug problem
     */
    @Test
    public void testSolution1() {
        initializeMoves();
       
        assertFalse(problem.success());
        tryMove(fillX);
        //System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(transferXtoY);
        //System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(fillX);
        //System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(transferXtoY);
        //System.out.println(problem.getCurrentState().toString());
        
        assertTrue(problem.success());
        
       
    }

    /**
     * Tests the 6-move solution to the water jug problem
     */
    @Test
    public void testSolution2() {
        
       initializeMoves();
        assertFalse(problem.success());
        tryMove(fillY);
        System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(transferYtoX);
        System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(emptyY);
        System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(transferXtoY);
        System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(fillX);
        System.out.println(problem.getCurrentState().toString());
        
        assertFalse(problem.success());
        tryMove(transferXtoY);
        System.out.println(problem.getCurrentState().toString());
        
        assertTrue(problem.success());
        
        
    }

    /**
     * Tests the problem's introduction string.
     */
    @Test
    public void testIntro() {
        
        assertTrue(problem.getIntroduction().equals("Welcome to the Water Jug Problem.\n\n"
                + "You are given two empty jugs: jug X holds 3 gallons, jug Y holds 4.\n"
                + "Neither has any measuring markers on it. You have a ready supply\n"
                + "of water. You can fill either jug, empty either jug on the ground,\n"
                + "or pour all or some of either jug into the other. The goal is to\n"
                + "get exactly 2 gallons of water into either jug.\n\n"));
    }
}
