/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import framework.Canvas;
import framework.State;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Ben Schoenfeld
 */
public class BridgeCanvas extends Canvas {

    public BridgeCanvas(State initialState) {
        super(initialState);

        bridgeState = (BridgeState) initialState;
        setPreferredSize(new Dimension(300, 300));
        bridgePath = new GeneralPath();
        leftSide = new Rectangle2D.Double(0, 0, 100, 300);
        water = new Rectangle2D.Double(100, 0, 100, 300);
        rightSide = new Rectangle2D.Double(200, 0, 100, 300);

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        bridgeState = (BridgeState) this.getCanvasState();

        String time = Integer.toString(bridgeState.getTimeSoFar());

        g2.setPaint(new Color(34, 139, 34));
        g2.fill(leftSide);
        g2.setPaint(new Color(0, 0, 255));
        g2.fill(water);
        g2.setPaint(new Color(34, 139, 34));
        g2.fill(rightSide);

        BasicStroke stroke = new BasicStroke(5);
        g2.setStroke(stroke);
        g2.setPaint(new Color(139, 69, 19));
        bridgePath.moveTo(x0, y0);
        bridgePath.lineTo(x1, y1);
        bridgePath.lineTo(210, 175);
        bridgePath.lineTo(90, 175);
        bridgePath.closePath();

        g2.draw(bridgePath);

        g2.fill(bridgePath);

        g2.setPaint(Color.BLACK);
        g2.setFont(new Font("SANSERIF", Font.BOLD, 20));

        if (bridgeState.getP1Position() == Position.WEST) {
            g2.drawString("P1", 50, 80);
        } else {
            g2.drawString("P1", 250, 80);
        }
        if (bridgeState.getP2Position() == Position.WEST) {
            g2.drawString("P2", 50, 120);
        } else {
            g2.drawString("P2", 250, 120);
        }
        if (bridgeState.getFlashlightPosition() == Position.WEST) {
            g2.drawString("f", 50, 160);
        } else {
            g2.drawString("f", 250, 160);
        }
        if (bridgeState.getP5Position() == Position.WEST) {
            g2.drawString("P5", 50, 200);
        } else {
            g2.drawString("P5", 250, 200);
        }
        if (bridgeState.getP10Position() == Position.WEST) {
            g2.drawString("P10", 50, 240);
        } else {
            g2.drawString("P10", 250, 240);
        }

        g2.setPaint(Color.white);
        g2.drawString(time + " min", 117, 165);

    }

     @Override
    public void render(State state) {
    repaint();
    }

    private int x0 = 90;
    private int y0 = 150;
    private int x1 = 210;
    private int y1 = 150;

    private GeneralPath bridgePath;
    private Rectangle2D.Double leftSide;
    private Rectangle2D.Double water;
    private Rectangle2D.Double rightSide;
    private BridgeState bridgeState;
}
