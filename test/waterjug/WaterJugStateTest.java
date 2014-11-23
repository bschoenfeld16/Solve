package waterjug;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugState class
 * @author your name here
 */
public class WaterJugStateTest {
    
    private String state1String = "       |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    private WaterJugState state1 = new WaterJugState(0,0);
                                 
    
    private String state2String = "       |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    private WaterJugState state2 = new WaterJugState(3,4);
    
    private String state3String = "       |***|\n" +
                                  "|   |  |***|\n" +
                                  "|   |  |***|\n" +
                                  "|   |  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    private WaterJugState state3 = new WaterJugState(0,4);
    
   private String state4String =  "       |   |\n" +
                                  "|***|  |   |\n" +
                                  "|***|  |   |\n" +
                                  "|***|  |   |\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
   private WaterJugState state4 = new WaterJugState(3,0);
   
   private String state5String =  "       |   |\n" +
                                  "|   |  |***|\n" +
                                  "|   |  |***|\n" +
                                  "|   |  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
   private WaterJugState state5 = new WaterJugState(0,3);
   
   private String state6String =  "       |   |\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
   
   private WaterJugState state6 = new WaterJugState(3,3);
   private WaterJugState state6Copy = new WaterJugState(3,3);
   


    /**
     * This method tests the accessors (getters) for <b>WaterJugState</b> objects.
     */
    @Test
    public void testAccessors() {
        assertTrue(state1.getAmountOfWaterX() == 0);
        assertTrue(state1.getAmountOfWaterY() == 0);
        assertTrue(state2.getAmountOfWaterX() == 3);
        assertTrue(state2.getAmountOfWaterY() == 4);
        
        
    }

    /**
     * This method tests the <b>equals</b> method for <b>WaterJugState</b> objects.
     */
    @Test
    public void testEquals() {
       
        assertFalse(state1.equals(state2));
        assertFalse(state3.equals(state5));
        assertTrue(state6.equals(state6Copy));
    }

    /**
     * This method tests the <b>toString</b> method for <b>WaterJugState</b> objects.
     * Look at the definitions of <b>state1String</b> and <b>state2String</b> to see
     * how <b>toString</b> should format a state's string representation.
     */
    @Test
    public void testToString() {
        System.out.println(state1.toString());
        System.out.println(state1String);
        assertTrue(state1.toString().equals(state1String));
        assertTrue(state2.toString().equals(state2String));
        assertTrue(state3.toString().equals(state3String));
        assertTrue(state4.toString().equals(state4String));
        assertTrue(state5.toString().equals(state5String));
        assertTrue(state6.toString().equals(state6String));
        
    }
}
