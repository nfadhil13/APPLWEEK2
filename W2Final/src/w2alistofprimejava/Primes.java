/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2alistofprimejava;

import java.awt.*;
import javax.swing.*;
public class Primes
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Primes");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        PrimePanel primePanel = new PrimePanel ();
        frame.getContentPane().add(primePanel);
        frame.pack();
        frame.setVisible(true);
    }
}
