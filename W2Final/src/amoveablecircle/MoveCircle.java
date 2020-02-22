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
public class MoveCircle
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame ("MoveCircle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.getContentPane().add(new CirclePanel(400,300));
        frame.setVisible(true);
    }
}