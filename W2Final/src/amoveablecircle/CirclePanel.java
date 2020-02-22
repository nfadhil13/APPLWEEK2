/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoveablecircle;

/**
 *
 * @author ASUS
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    private int width;
    private int height;
    private JButton left = new JButton("Left");
    private JButton right = new JButton("Right");
    private JButton up = new JButton("Up");
    private JButton down = new JButton("Down");
    private JPanel buttonPanel = new JPanel();

    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height)
    {
        this.width = width;
        this.height = height;
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        down.addActionListener(new MoveListener(0,20));
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);
        left.setToolTipText("MOVE 20 to the left");
        right.setToolTipText("MOVE 20 to the right");
        up.setToolTipText("MOVE 20 to the top");
        down.setToolTipText("MOVE 20 to the bottom");
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));

        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {

        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
    //---------------------------------------------------------------
    // Parameters tell how to move circle at click.
    //---------------------------------------------------------------
    public MoveListener(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }
    //---------------------------------------------------------------
    // Change x and y coordinates and repaint.
    //---------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
     {
     if(dx!=0){
        if((x+dx)<=width-CIRCLE_SIZE) {
            if((x+dx)>0){
                x += dx;
                left.setEnabled(true);
                right.setEnabled(true);
            }else{
                left.setEnabled(false);
            }
        }else{
            right.setEnabled(false);
        } 
     }
     if(dy!=0){
        int panelHeight = buttonPanel.getSize().height;
        if((y+dy)<=(height-2*panelHeight-CIRCLE_SIZE)) {
            if((y+dy)>0){
                y += dy;
                up.setEnabled(true);
                down.setEnabled(true);
            }else{
                up.setEnabled(false);
            }
        }else{
            down.setEnabled(false);
        }         
     }
         
     repaint();
     }
    }
}