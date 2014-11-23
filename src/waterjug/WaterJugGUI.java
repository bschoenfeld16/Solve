package waterjug;

import bridge.BridgeCanvas;
import bridge.BridgeProblem;
import framework.GUI;
import javax.swing.JFrame;

/**
 * A class to test your GUI class on the water jug problem.
 *
 * @author tcolburn
 */
public class WaterJugGUI extends JFrame {

    public WaterJugGUI() {
        add(new GUI(new WaterJugProblem()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * This method launches the gui.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        new WaterJugGUI();
    }

}
