/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throwingexceptionw1;

public class MathUtils
{
//-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException
    {
     if(n>=0 && n <=16){
        int fac = 1;
        for (int i=n; i>0; i--)
        fac *= i;
        return fac;
     }else if(n>16){
         throw new IllegalArgumentException("Maximum Integer is 16");
     }
     else {
         throw new  IllegalArgumentException("Factorial is not available for negative integers");
     }
    }
}