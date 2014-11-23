package waterjug;

import framework.State;

/**
 * This class represents states of the Water Jug problem. It creates new water
 * jug states, tests states for equality, and produces string representations of
 * them. Note that this class implements the <b>State</b> interface and
 * therefore imports <b>framework.State</b>.
 */
public class WaterJugState implements State {

    /**
     * Creates a new water jug state.
     *
     * @param amountOfWaterX
     * @param amountOfWaterY
     */
    public WaterJugState(int amountOfWaterX, int amountOfWaterY) {
        if(amountOfWaterX < 0 || amountOfWaterX > 3) {
            System.out.println("value out of bounds for x" + amountOfWaterX);
            System.exit(0);
        }
        if(amountOfWaterY < 0 || amountOfWaterY > 4) {
            System.out.println("value out of bounds for y" + amountOfWaterY);
            System.exit(0);
        }
        this.amountOfWaterX = amountOfWaterX;
        this.amountOfWaterY = amountOfWaterY;
    }

    /**
     * Tests for equality between this state and the argument state. Two states
     * are equal if the X jugs have the same amount of water and the Y jugs have
     * the same amount of water.
     *
     * @param other the state to test against this state
     * @return whether the states are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof WaterJugState) {
            WaterJugState state = (WaterJugState) other;
            return this.getAmountOfWaterX() == state.getAmountOfWaterX() && this.amountOfWaterY == state.getAmountOfWaterY();
        } else {
            return false;
        }
    }

    /**
     * Creates a primitive, non-GUI representation of this WaterJugState object.
     *
     * @return the string representation of this water jug state
     */
    public String toString() {
        return "       |" + showThisGallon(false, 4) + "|\n"
                + "|" + showThisGallon(true, 3) + "|  |" + showThisGallon(false, 3) + "|\n"
                + "|" + showThisGallon(true, 2) + "|  |" + showThisGallon(false, 2) + "|\n"
                + "|" + showThisGallon(true, 1) + "|  |" + showThisGallon(false, 1) + "|\n"
                + "+---+  +---+\n"
                + "  X      Y  \n";
    }

    // Private methods and instance fields should go here
    private int amountOfWaterX;
    private int amountOfWaterY;

    public int getAmountOfWaterX() {
        return amountOfWaterX;
    }

    public void setAmountOfWaterX(int amountOfWaterX) {
        this.amountOfWaterX = amountOfWaterX;
    }

    public int getAmountOfWaterY() {
        return amountOfWaterY;
    }

    public void setAmountOfWaterY(int amountOfWaterY) {
        this.amountOfWaterY = amountOfWaterY;
    }

    private String showThisGallon(boolean isJugX, int gallonPosition) {
        if (isJugX) {
            if (gallonPosition <= amountOfWaterX) {
                return "***";
            } else {
                return "   ";
            }
        } else {
            if (gallonPosition <= amountOfWaterY) {
                return "***";
            } else {
                return "   ";
            }
        }

    }
}
