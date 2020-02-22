/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionarenalwayserrorw2;

import java.util.Scanner;
public class CountLetters
{
    public static void main(String[] args)
    {
        int[] counts = new int[26];
        Scanner scan = new Scanner(System.in);
        //get word from user
        System.out.print("Enter a single word (letters only, please): ");
        String word = scan.nextLine();
        //convert to all upper case
        word = word.toUpperCase();
        //count frequency of each letter in string
      
            for (int i=0; i < word.length(); i++)
        try{ 
                counts[word.charAt(i)-'A']++;
        }
        catch(Exception e){
              System.out.println( word.charAt(i)) + "Is not A letter");
        }
        //print frequencies
        System.out.println();
        for (int i=0; i < counts.length; i++)
            if (counts [i] != 0)
            System.out.println((char)(i +'A') + ": " + counts[i]);
    }
}
