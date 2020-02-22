/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingfromnwritingw2;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
import java.io.*;
public class Warning
{
// --------------------------------------------------------------------
// Reads student data (name, semester hours, quality points) from a
// text file, computes the GPA, then writes data to another file
// if the student is placed on academic warning.
// --------------------------------------------------------------------
public static void main (String[] args)
{
    int creditHrs; // number of semester hours earned
    double qualityPts; // number of quality points earned
    double gpa; // grade point (quality point) average
    String line, name, inputName = "D:\\students.dat";
    String outputName = "warning.dat";
    try
    {
    // Set up scanner to input file
    File infile = new File(inputName);
    Scanner scfile = new Scanner(infile);
    // Set up the output file stream
    PrintWriter outFile = new PrintWriter(outputName);
    // Print a header to the output file
    outFile.println ();
    outFile.println ("Students on Academic Warning");
    outFile.println ();
    // Process the input file, one token at a time
    while (scfile.hasNextLine())
    {
    // Get the credit hours and quality points and
           name = scfile.next();
           creditHrs = scfile.nextInt();
           qualityPts = scfile.nextDouble();
    // determine if the student is on warning. If so,
    gpa = qualityPts/creditHrs;
    if((gpa < (1.5) && creditHrs<=30) || (gpa < (1.75) && creditHrs <=60) || (gpa < 2.0 && creditHrs>60)){
        // write the student data to the output file.
        outFile.println(name + " " + creditHrs + " " + gpa);
    }
    
    }
    // Close output file
    outFile.close();
    }
    catch (FileNotFoundException exception)
    {
        System.out.println ("The file " + inputName + " was not found.");
    }
    catch (IOException exception)
    {
        System.out.println (exception);
    }
    catch (NumberFormatException e)
    {
        System.out.println ("Format error in input file: " + e);
    }
    }
}
