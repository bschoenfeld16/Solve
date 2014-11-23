package bridge;

import framework.Canvas;
import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Bridge Crossing problem. It provides an
 * introductory message describing the problem, stores the problem's possible
 * moves and current state, and checks for whether the problem has been
 * successfully solved. Note that this class extends the abstract class
 * <b>Problem</b> and therefore imports <b>framework.Problem</b>. This class
 * inherits the <b>setIntroduction(), setCurrentState()</b>, and
 * <b>setMoves()</b> methods from its parent and thus it should not have any
 * instance fields for these attributes.
 *
 * @author your name here
 */
public class BridgeProblem extends Problem {

    /**
     * Constructs a new bridge problem object. A new bridge state object should
     * be constructed with P1, P2, P5, P10, and the flashlight all on the west
     * side of the bridge with zero time elapsed. This state should be set as
     * the current state of the problem using the inherited
     * <b>setCurrentState()</b> method. The ten valid bridge moves should be
     * created and stored on a list using the inherited <b>setMoves()</b>
     * method. The appropriate introduction string for this problem should be
     * stored using the inherited <b>setIntroduction()</b>.
     */
    public BridgeProblem() {
        setIntroduction("Welcome to the Bridge Crossing Problem.\n\n" +
                "Person Pn can cross the bridge in n minutes.\n" +
                "Only one or two persons can cross at a time because it is dark,\n" +
                "and the flashlight must be taken on every crossing.\n" +
                "When two people cross, they travel at the speed of the slowest person.\n" +
                "Devise a sequence of crossings so that all four people get across\n" +
                "the bridge in no more than 17 minutes.\n");
        
        List<Move> bridgeMoves = new ArrayList<Move>();

        setCurrentState(new BridgeState(Position.WEST,
                Position.WEST,
                Position.WEST,
                Position.WEST,
                Position.WEST,
                0));
        BridgeMove p1 = new BridgeMove("P1 crosses alone");
        bridgeMoves.add(p1);

        BridgeMove p2 = new BridgeMove("P2 crosses alone");
        bridgeMoves.add(p2);

        BridgeMove p5 = new BridgeMove("P5 crosses alone");
        bridgeMoves.add(p5);

        BridgeMove p10 = new BridgeMove("P10 crosses alone");
        bridgeMoves.add(p10);

        BridgeMove p1p2 = new BridgeMove("P1 crosses with P2");
        bridgeMoves.add(p1p2);

        BridgeMove p1p5 = new BridgeMove("P1 crosses with P5");
        bridgeMoves.add(p1p5);

        BridgeMove p1p10 = new BridgeMove("P1 crosses with P10");
        bridgeMoves.add(p1p10);

        BridgeMove p2p5 = new BridgeMove("P2 crosses with P5");
        bridgeMoves.add(p2p5);

        BridgeMove p2p10 = new BridgeMove("P2 crosses with P10");
        bridgeMoves.add(p2p10);

        BridgeMove p5p10 = new BridgeMove("P5 crosses with P10");
        bridgeMoves.add(p5p10);

        setMoves(bridgeMoves);

    }
    
    

    /**
     * Returns whether the current state of this problem is a success. Note that
     * this method implements the abstract <b>success</b> method declared in the
     * parent. Note also that the current state of the problem must be gotten
     * using the inherited <b>getCurrentState()</b> method. Since that method
     * returns a value of type <b>State</b>, it must be cast to
     * <b>BridgeState</b> before processing. The current state is a success if
     * P1, P2, P5, and P10 are all on the east side of the bridge and the time
     * taken to cross is less than 18 minutes.
     *
     * @return <b>true</b> if the current state is a success, <b>false</b>
     * otherwise
     */
    @Override
    public boolean success() {
        Object object = getCurrentState();
        if (object instanceof BridgeState) {
            BridgeState currentState = (BridgeState) object;
            return currentState.getP1Position() == Position.EAST && currentState.getP2Position() == Position.EAST
                    && currentState.getP5Position() == Position.EAST
                    && currentState.getP10Position() == Position.EAST
                    && currentState.getTimeSoFar() <= 17;
        } else {
            return false;
        }
    }
    
    public Canvas getCanvasState() {
        BridgeCanvas bridgeCanvas = new BridgeCanvas(this.getCurrentState());
        return bridgeCanvas;
    }
    
    
  
   

    // Private instance fields are not necessary since they are inherited.

}
