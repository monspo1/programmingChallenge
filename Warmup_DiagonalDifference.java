// Diagonal Difference (Warmup: Easy Question)
/*
* Problem Statement
  You are given a square matrix of size N×N. 
  Calculate the absolute difference of the sums across the two main diagonals.

* Input Format
  The first line contains a single integer N. The next N lines contain N integers (each) describing the matrix.

* Constraints 
    1 ≤ N ≤ 100 
   −100 ≤ A[i] ≤ 100

* Output Format
  Output a single integer equal to the absolute difference in the sums across the diagonals.

* Sample Input

    3
    11 2 4
    4 5 6
    10 8 -12

* Sample Output
    15

* Explanation
  The first diagonal of the matrix is:
    11
        5
            -12          
  Sum across the first diagonal = 11+5-12= 4

  The second diagonal of the matrix is:
            4
        5
    10
  Sum across the second diagonal = 4+5+10 = 19 
  
  Difference: |4-19| =15
//*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int DiagonalDifference(int[][] arr){
        int n = arr.length;
        int dsum1 = 0;
        int dsum2 = 0;
        
        for(int i = 0; i < n; i++){
            dsum1 += arr[i][i];   
            dsum2 += arr[i][n-1-i];
        }
        return Math.abs(dsum1 - dsum2);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String line = null;
        int[][] arr = new int[n][n];
        
        int i = 0;
        while((line = br.readLine()) != null){
            line = line.trim();
            String[] strArr = line.split(" ");
            
            for(int j = 0; j < strArr.length; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
            i++;
        }
        System.out.println(DiagonalDifference(arr));
        
    }
}