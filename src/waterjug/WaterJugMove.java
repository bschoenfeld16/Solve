package waterjug;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the Water Jug problem. A move object stores
 * its move name and knows how to apply itself to a water jug state to create a
 * new state representing the result of the move. Note that this class extends
 * the abstract class <b>Move</b> and therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent and thus
 * it should not have an instance field for the move name.
 *
 * @author your name here
 */
public class WaterJugMove extends Move {

    /**
     * Constructs a new water jug move object. Note that the move name is passed
     * to the parent constructor using <b>super</b>.
     *
     * @param moveName the name of this move. It is an error if the name is not
     * one of the following:
     * <ul>
     * <li> "Fill Jug X" </li>
     * <li> "Fill Jug Y" </li>
     * <li> "Empty Jug X" </li>
     * <li> "Empty Jug Y" </li>
     * <li> "Transfer Jug X to Jug Y" </li>
     * <li> "Transfer Jug Y to Jug X" </li>
     * </ul>
     */
    public WaterJugMove(String moveName) {
        super(moveName);
        // You must provide the rest
    }

    /**
     * Attempts to perform this move on a given water jug state. Note that this
     * method implements the abstract <b>doMove</b> method declared in the
     * parent. Thus the argument of type <b>State</b> must be cast to type
     * <b>WaterJugState</b> before processing. The move to perform is determined
     * by this object's move name. If the move can be performed a new water jug
     * state object is returned that reflects this move. A move cannot be
     * performed if trying to fill or transfer to an already full jug, or if
     * trying to empty or transfer from an empty jug. If the move cannot be
     * performed <b>null</b> is returned.
     *
     * @param otherState the water jug state on which this move is to be
     * performed
     * @return a new water jug state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    @Override
    public State doMove(State otherState) {
        if (otherState instanceof WaterJugState) {
            WaterJugState oldState = (WaterJugState) otherState;
            WaterJugState newState = null;
            if ("Fill Jug X".equals(getMoveName())) {
                if (oldState.getAmountOfWaterX() < 3) {
                    newState = new WaterJugState(3, oldState.getAmountOfWaterY());
                } else {
                    return null;
                }

            } else if ("Fill Jug Y".equals(getMoveName())) {
                if (oldState.getAmountOfWaterY() < 4) {
                    newState = new WaterJugState(oldState.getAmountOfWaterX(), 4);
                } else {
                    return null;
                }

            } else if ("Empty Jug X".equals(getMoveName())) {
                if (oldState.getAmountOfWaterX() > 0) {
                    newState = new WaterJugState(0, oldState.getAmountOfWaterY());
                } else {
                    return null;
                }
            } else if ("Empty Jug Y".equals(getMoveName())) {
                if (oldState.getAmountOfWaterY() > 0) {
                    newState = new WaterJugState(oldState.getAmountOfWaterX(), 0);
                } else {
                    return null;
                }
            } else if ("Transfer Jug X to Jug Y".equals(getMoveName())) {
                if (oldState.getAmountOfWaterX() > 0 && oldState.getAmountOfWaterY() < 4) {                  
                    int newX = oldState.getAmountOfWaterX() - ((4 - oldState.getAmountOfWaterY()));
                    if (newX < 0) {
                        newX = 0;
                    }
                    int newY = oldState.getAmountOfWaterY() + oldState.getAmountOfWaterX();
                    if (newY > 4) {
                        newY = 4;
                    }
                    newState = new WaterJugState(newX, newY);

                } else {
                    return null;
                }
            } else if ("Transfer Jug Y to Jug X".equals(getMoveName())) {
                if (oldState.getAmountOfWaterX() < 3 && oldState.getAmountOfWaterY() > 0) {
                    int newX = oldState.getAmountOfWaterY() + oldState.getAmountOfWaterX();
                    if (newX > 3) {
                        newX = 3;
                    }
                    int newY = oldState.getAmountOfWaterY() - (3 - oldState.getAmountOfWaterX());
                    if (newY < 0) {
                        newY = 0;
                    }

                    newState = new WaterJugState(newX, newY);
                
            } else {
                return null;
            }
        }
        return newState;
    }

    
        else {
            return null;
    }
}
}
