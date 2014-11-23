/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import framework.Canvas;
import framework.State;
import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Schoen
 */
public class PuzzleCanvas extends Canvas {

    public PuzzleCanvas(State initialState) {
        super(initialState);

        puzzleState = (PuzzleState) initialState;
        setPreferredSize(new Dimension(300, 300));

        tile1 = new Rectangle2D.Double(0, 0, 95, 95);
        tile2 = new Rectangle2D.Double(100, 0, 95, 95);
        tile3 = new Rectangle2D.Double(200, 0, 95, 95);
        tile4 = new Rectangle2D.Double(0, 100, 95, 95);
        tile5 = new Rectangle2D.Double(100, 100, 95, 95);
        tile6 = new Rectangle2D.Double(200, 100, 95, 95);
        tile7 = new Rectangle2D.Double(0, 200, 95, 95);
        tile8 = new Rectangle2D.Double(100, 200, 95, 95);
        tile9 = new Rectangle2D.Double(200, 200, 95, 95);

        //tileEmpty = new Rectangle2D.Double(100, 200, 95, 95);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        puzzleState = (PuzzleState) this.getCanvasState();

        g2.setPaint(blue);
        int[][] xPosition = new int[][]{
            {30, 130, 230},
            {30, 130, 230},
            {30, 130, 230}
        };

        int[][] yPosition = new int[][]{
            {60, 60, 60},
            {160, 160, 160},
            {260, 260, 260}
        };

        Rectangle2D.Double[][] tiles = new Rectangle2D.Double[][]{
            {tile1, tile2, tile3},
            {tile4, tile5, tile6},
            {tile7, tile8, tile9}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzleState.getTile(i, j) != 0) {
                    g2.fill(tiles[i][j]);
                    g2.setPaint(red);
                    g2.setFont(new Font("SANSERIF", Font.BOLD, 50));
                    g2.drawString(Integer.toString(puzzleState.getTile(i, j)), xPosition[i][j], yPosition[i][j]);
                    g2.setPaint(blue);
                }
            }
        }        
    }

    @Override
    public void render(State state) {
        repaint();
    }

    private PuzzleState puzzleState;

    private Rectangle2D.Double tile1;
    private Rectangle2D.Double tile2;
    private Rectangle2D.Double tile3;
    private Rectangle2D.Double tile4;
    private Rectangle2D.Double tile5;
    private Rectangle2D.Double tile6;
    private Rectangle2D.Double tile7;
    private Rectangle2D.Double tile8;
    private Rectangle2D.Double tile9;

}
