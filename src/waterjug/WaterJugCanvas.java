/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterjug;

import framework.Canvas;
import framework.State;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

/**
 *
 * @author Schoen
 */
public class WaterJugCanvas extends Canvas {

    public WaterJugCanvas(State initialState) {
        super(initialState);

        waterJugState = (WaterJugState) initialState;
        setPreferredSize(new Dimension(300, 300));

        background = new Rectangle2D.Double(0, 0, 300, 300);
        timer = new Timer(25, null);
        xJugPath = new GeneralPath();
        yJugPath = new GeneralPath();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        waterJugState = (WaterJugState) this.getCanvasState();

        g2.setPaint(Color.orange);

        g2.fill(background);

        g2.setPaint(Color.black);
        BasicStroke stroke = new BasicStroke(5);
        g2.setStroke(stroke);

        //draw Jug X
        xJugPath.moveTo(30, 70);
        xJugPath.lineTo(30, 220);
        xJugPath.lineTo(130, 220);
        xJugPath.lineTo(130, 70);
        g2.draw(xJugPath);
        g2.drawString("X has " + waterJugState.getAmountOfWaterX() + " gallons", 33, 233);

        //draw Jug Y
        yJugPath.moveTo(180, 20);
        yJugPath.lineTo(180, 220);
        yJugPath.lineTo(280, 220);
        yJugPath.lineTo(280, 20);
        g2.draw(yJugPath);
        g2.drawString("Y has " + waterJugState.getAmountOfWaterY() + " gallons", 183, 233);

        //draw water
        g2.setColor(Color.blue);
        g2.fillRect(32, JugXWaterHeightStart, 96, JugXWaterHeight);
        g2.fillRect(182, JugYWaterHeightStart, 96, JugYWaterHeight);

    }

    @Override
    public void render(State state) {
        waterJugState = (WaterJugState) state;

        final int newXWaterHeightStart = 218 - (waterJugState.getAmountOfWaterX() * 50);

        final int newYWaterHeightStart = 218 - (waterJugState.getAmountOfWaterY() * 50);

        timer = new Timer(1, null);

        timer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (JugXWaterHeightStart < newXWaterHeightStart) {
                    JugXWaterHeightStart = JugXWaterHeightStart + 5;
                    JugXWaterHeight = JugXWaterHeight - 5;
                    repaint();
                    if (JugXWaterHeightStart >= newXWaterHeightStart && JugYWaterHeightStart >= newYWaterHeightStart) {
                        timer.stop();
                    }
                }
                if (JugXWaterHeightStart > newXWaterHeightStart) {
                    JugXWaterHeightStart = JugXWaterHeightStart - 5;
                    JugXWaterHeight = JugXWaterHeight + 5;
                    repaint();
                    if (JugXWaterHeightStart <= newXWaterHeightStart && JugYWaterHeightStart <= newYWaterHeightStart) {
                        timer.stop();
                    }
                }
                if (JugYWaterHeightStart < newYWaterHeightStart) {
                    JugYWaterHeightStart = JugYWaterHeightStart + 5;
                    JugYWaterHeight = JugYWaterHeight - 5;
                    repaint();
                    if (JugXWaterHeightStart >= newXWaterHeightStart && JugYWaterHeightStart >= newYWaterHeightStart) {
                        timer.stop();
                    }
                }
                if (JugYWaterHeightStart > newYWaterHeightStart) {
                    JugYWaterHeightStart = JugYWaterHeightStart - 5;
                    JugYWaterHeight = JugYWaterHeight + 5;
                    repaint();
                    if (JugXWaterHeightStart <= newXWaterHeightStart && JugYWaterHeightStart <= newYWaterHeightStart) {
                        timer.stop();
                    }
                }
                
                if(JugXWaterHeightStart == newXWaterHeightStart && JugYWaterHeightStart == newYWaterHeightStart) {
                    timer.stop();
                }
                

            }

        });

        timer.start();
    }

    private GeneralPath xJugPath;
    private GeneralPath yJugPath;
    private Rectangle2D.Double background;
    private WaterJugState waterJugState;

    private int JugXWaterHeightStart = 218;
    private int JugXWaterHeight = 0;

    public void setJugXWaterHeightStart(int height) {
        JugXWaterHeightStart = height;
    }

    public void setJugYWaterHeightStart(int height) {
        JugYWaterHeightStart = height;
    }

    @Override
    public void resetWater() {
        JugXWaterHeightStart = 218;
        JugYWaterHeightStart = 218;
    }

    private int JugYWaterHeightStart = 218;
    private int JugYWaterHeight = 0;

    ///private int yWaterHeight = 0;
    private Timer timer;
}
