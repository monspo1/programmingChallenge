/* Warmup Question: Plus Minus

* Problem Statement
  You're given an array containing integer values. 
  You need to print the fraction of count of positive numbers, negative numbers and zeroes 
  to the total numbers. Print the value of the fractions correct to 3 decimal places.

* Input Format
  First line contains N, which is the size of the array. 
  Next line contains N integers A1,A2,A3,⋯,AN, separated by space.

* Constraints 
    1 ≤ N ≤ 100 
    −100 ≤ Ai ≤ 100

* Output Format
  Output three values on different lines equal to the fraction of count of positive numbers, 
  negative numbers and zeroes to the total numbers respectively correct to 3 decimal places.

* Sample Input
    6
    -4 3 -9 0 4 1          

* Sample Output
    0.500
    0.333
    0.167

* Explanation
  There are 3 positive numbers, 2 negative numbers and 1 zero in the array. 
  Fraction of the positive numbers, negative numbers and zeroes are 3/6=0.500, 2/6=0.333 
  and 1/6=0.167 respectively.

* Note 
  This challenge introduces 'precision' problems. You can even print output to 4 decimal places 
  and above but only the difference at 3rd decimal digit is noted. 
  That is the reason you'll notice testcases have much higher precision (more decimal places) than required. 
  Answers with absolute error upto 10−4 will be accepted.
//*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void PlusMinus(float[] arr){
		float p_count = 0;
		float n_count = 0;
		float z_count = 0;
		int n = arr.length;
		
		for(int i = 0; i < n; i++){
			if(arr[i] > 0) p_count++;
			else if(arr[i] < 0) n_count++;
			else z_count++;
		}
		
		System.out.printf("%.3f \n", (p_count / n));
		System.out.printf("%.3f \n", (n_count / n));
		System.out.printf("%.3f \n", (z_count / n));

	}
    
    public static void printFloats(float[] arr){
		int n = arr.length;
		
		// 1. using printf(%.f)
		System.out.println("1.Using printf(%.f) ------------ ");
		for(int i = 0; i < n; i++){
            // 간단히 말해서 System.out.printf(" %.3f ", arr[i]);
			System.out.printf("arr[" + i + "]: %.3f \n", arr[i] / 3);
            
		}
		System.out.println("\n2.Using DecimalFormat ------------ ");
		
		// 2. using DecimalFormat
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(3);
		df.setMaximumFractionDigits(3);
		
		for(int i = 0; i < n; i++){
			System.out.println("[DF]: " + df.format(arr[i] / 3) );	
		}
		System.out.println();
		
		// 3. converting String to float
		System.out.println("3.String-float conversion ------------ ");
		String s = "2";
		float a = (Float.valueOf(s)).floatValue();
		a = (float) ((a + 0.001)/3);
		System.out.println(a);
		
        /* Output  (when input: float[-4 3 -9 0 4 1]
        1.Using printf(%.f) ------------ 
        arr[0]: -1.333 
        arr[1]: 1.000 
        arr[2]: -3.000 
        arr[3]: 0.000 
        arr[4]: 1.333 
        arr[5]: 0.333 

        2.Using DecimalFormat ------------ 
        [DF]: -1.333
        [DF]: 1.000
        [DF]: -3.000
        [DF]: 0.000
        [DF]: 1.333
        [DF]: 0.333

        3.String-float conversion ------------ 
        0.667
        //*/
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float arr[] = new float[n];
        
        for(int i = 0; i < n; i++){
			arr[i] = sc.nextFloat();
        }
        PlusMinus(arr);
	}
}