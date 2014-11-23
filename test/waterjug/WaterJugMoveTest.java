package waterjug;

import framework.Move;
import framework.State;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A class to test the WaterJugMove class.
 *
 * @author Ben Schoenfeld
 */
public class WaterJugMoveTest {

    // You should use the BridgeMoveTest class as a model for setting up
    // the tests with private instance fields here.
    private State start = new WaterJugState(0, 0);
    private State state1 = new WaterJugState(3, 4);
    private State state2 = new WaterJugState(3, 2);
    private State state3 = new WaterJugState(1, 3);
    private State state4 = new WaterJugState(2,1);

    private Move fillX = new WaterJugMove("Fill Jug X");
    private Move fillY = new WaterJugMove("Fill Jug Y");
    private Move emptyX = new WaterJugMove("Empty Jug X");
    private Move emptyY = new WaterJugMove("Empty Jug Y");
    private Move transferXtoY = new WaterJugMove("Transfer Jug X to Jug Y");
    private Move transferYtoX = new WaterJugMove("Transfer Jug Y to Jug X");

    /**
     * Tests filling jug X
     */
    @Test
    public void testFillX() {
        // You must provide
        WaterJugState next = (WaterJugState) fillX.doMove(start);
        assertTrue(next.equals(new WaterJugState(3, 0)));
    }

    /**
     * Tests filling jug Y
     */
    @Test
    public void testFillY() {
        // You must provide
        WaterJugState next = (WaterJugState) fillY.doMove(start);
        assertTrue(next.equals(new WaterJugState(0, 4)));
    }

    /**
     * Tests emptying jug X
     */
    @Test
    public void testEmptyX() {
        // You must provide
        WaterJugState next = (WaterJugState) emptyX.doMove(state1);
        assertTrue(next.equals(new WaterJugState(0, 4)));
    }

    /**
     * Tests emptying jug Y
     */
    @Test
    public void testEmptyY() {
        // You must provide
        WaterJugState next = (WaterJugState) emptyY.doMove(state1);
        assertTrue(next.equals(new WaterJugState(3, 0)));

    }

    /**
     * Tests transferring jug X to jug Y
     */
    @Test
    public void testXToY() {
        // You must provide
        System.out.println(state4.toString());
        WaterJugState next = (WaterJugState) transferXtoY.doMove(state2);
       assertTrue(next.equals(new WaterJugState(0, next.getAmountOfWaterY()+next.getAmountOfWaterX())));
       
        
    }

    /**
     * Tests transferring jug Y to jug X
     */
    @Test
    public void testYToX() {
        // You must provide
        WaterJugState next = (WaterJugState) transferYtoX.doMove(state3);
        assertTrue(next.equals(new WaterJugState(next.getAmountOfWaterX()+next.getAmountOfWaterY(), 0)));
        
    }
}
