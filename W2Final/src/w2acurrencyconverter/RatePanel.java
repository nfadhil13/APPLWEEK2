/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2acurrencyconverter;

/**
 *
 * @author ASUS
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel
{

    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    private JComboBox currencyList;
    private JTextField textfield;
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel ()
    {
    JLabel title = new JLabel ("How much is that in dollars?");
    title.setAlignmentX (Component.CENTER_ALIGNMENT);
    title.setFont (new Font ("Helvetica", Font.BOLD, 20));
    this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    // Set up the arrays for the currency conversions
    currencyName = new String[] {"Select the currency..",
    "European Euro", "Canadian Dollar",
    "Japanese Yen", "Australian Dollar",
    "Indian Rupee", "Mexican Peso"};
    JPanel forInput = new JPanel();
    JLabel tflabel = new JLabel("cost");  
    textfield = new JTextField();
    textfield.setText("1.0");
    textfield.setColumns(20);
    rate = new double [] {0.0, 1.2103, 0.7351,
    0.0091, 0.6969,
    0.0222, 0.0880};
    currencyList = new JComboBox(currencyName);
    currencyList.setMaximumSize(new Dimension(Integer.MAX_VALUE, currencyList.getMinimumSize().height));
    currencyList.addActionListener(new ComboListener());
    result = new JLabel (" ------------ ");
    forInput.add(tflabel);
    forInput.add(textfield);
    add (title);
    add(forInput);
    add (result);
    add (currencyList);
    

    
   
    }
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener
    {
    // --------------------------------------------------
    // Determines which currency has been selected and
    // the value in that currency then computes and
    // displays the value in U.S. Dollars.
    // --------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
    int index = currencyList.getSelectedIndex();
    String costString = textfield.getText();
    double cost = Double.parseDouble(costString);
    result.setText (costString + currencyName[index] +
    " = " + rate[index]*cost + " U.S. Dollars");
        
    }
 
}
}
