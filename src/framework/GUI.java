package framework;

import bridge.BridgeCanvas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javafx.scene.paint.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * A class that creates GUI components for solving search problems.
 *
 * @author Ben Schoenfeld
 */
public class GUI extends JComponent {

    public GUI(Problem problem) {

        // You must write
        initialState = problem.getCurrentState();

        this.canvas = problem.getCanvasState();

        setPreferredSize(new Dimension(800, 700));
        setLayout(new BoxLayout(this, Y_AXIS));
        wrapperPanel.setLayout(new BorderLayout());

        getIntroMessage(problem);
        getCurrentState(problem);

        stateAndButtonPanel.add(makeButtons(problem), canvas);

        wrapperPanel.add(stateAndButtonPanel, BorderLayout.CENTER);

        southPanel(problem);
        add(wrapperPanel);

    }

    // private methods and instance fields go here
    private void getIntroMessage(Problem problem) {
        introPanel.setPreferredSize(new Dimension(300, 200));
        JTextArea introMessage = new JTextArea(problem.getIntroduction());
        introMessage.setFont(new Font("SANSERIF", Font.BOLD, 15));
        introMessage.setEditable(false);

        introPanel.add(introMessage);

        wrapperPanel.add(introPanel, BorderLayout.NORTH);

    }

    private void getCurrentState(Problem problem) {
        JPanel statePanel = new JPanel();

        statePanel.setBorder(new TitledBorder("Current State"));
        statePanel.add(canvas);

        stateAndButtonPanel.add(statePanel);
    }

    private JPanel makeButtons(final Problem problem) {
        JPanel buttonPanel = new JPanel(new GridLayout(problem.getMoves().size(), 1, 20, 5));
        List tempList = problem.getMoves();
        buttonPanel.setBorder(new TitledBorder("Possible Moves"));
        for (int i = 0; i < (problem.getMoves().size()); i++) {
            final Move move = (Move) tempList.get(i);
            JButton button = new JButton(move.getMoveName());

            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    State newState = move.doMove(problem.getCurrentState());
                    if (newState != null) {
                        problem.setCurrentState(newState);
                        canvas.setCanvasState(newState);

                        canvas.render(newState);
                        moveCount++;
                    } else {
                        JOptionPane.showMessageDialog(null, "illegal move");
                    }

                    if (problem.success()) {
                        JOptionPane.showMessageDialog(null, "Congratulations. You solved the problem in " + moveCount + "  moves!");

                    }
                }
            });

            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    private void southPanel(final Problem problem) {
        JPanel southPanel = new JPanel(new GridLayout(2, 3, 1, 1));

        JButton reset = new JButton("reset");

        resetPanel.add(reset);
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                problem.setCurrentState(initialState);
                canvas.setCanvasState(initialState);

                canvas.render(initialState);
                moveCount = 0;

            }

        });

        JPanel radioButtonPanel = new JPanel();
        JRadioButton depthFirst = new JRadioButton("Deapth-first");
        JRadioButton breadthFirst = new JRadioButton("Breadth-first");
        radioButtonPanel.setBorder(new TitledBorder("Search Types"));
        radioButtonPanel.add(depthFirst);
        radioButtonPanel.add(breadthFirst);

        southPanel.add(resetPanel);
        southPanel.add(radioButtonPanel);

        JButton solve = new JButton("Solve");
        JButton showNextMove = new JButton("Show Next Move");
        JButton showAllMoves = new JButton("Show All Moves");
        southPanel.add(solve);
        southPanel.add(showNextMove);
        southPanel.add(showAllMoves);

        JTextArea stats = new JTextArea("Solution length: \n"
                + "Num of DEQUE OPS: \n"
                + "Max DEQUE size: ");
        stats.setEditable(false);

        //git test       
        southPanel.add(stats);

        wrapperPanel.add(southPanel, BorderLayout.SOUTH);
    }

    private int moveCount = 0;
    private JPanel introPanel = new JPanel();
    private JPanel stateAndButtonPanel = new JPanel();
    private JPanel resetPanel = new JPanel();
    private JPanel wrapperPanel = new JPanel();
    private State initialState;
    private Canvas canvas;
}
