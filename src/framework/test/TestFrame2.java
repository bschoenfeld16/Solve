package framework.test;

import bridge.BridgeProblem;
import framework.GUI;
import framework.ProblemPane;
import javax.swing.JFrame;
import puzzle.PuzzleProblem;
import waterjug.WaterJugProblem;

/**
 * A class to display the bridge crossing and water jug problems in a tabbed pane
 * within an application frame.
 * @author tcolburn
 */
public class TestFrame2 extends JFrame {
    
    public TestFrame2() {
        super("Testing Bridge and Water Jug Problems");
        ProblemPane problemPane = new ProblemPane();
        problemPane.add("Bridge", new GUI(new BridgeProblem()));
        problemPane.add("Water Jug", new GUI(new WaterJugProblem()));
        problemPane.add("8 Puzzle", new GUI(new PuzzleProblem()));
        add(problemPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TestFrame2();
    }
    

}
