/* MaxSum SubArray (Continous & Discrete)

* Problem Statement
  Given an array A={a1,a2,…,aN} of N elements, find the maximum possible sum of a
  1.Contiguous subarray
  2. Non-contiguous (not necessarily contiguous) subarray.
  Empty subarrays/subsequences should not be considered.

  This Youtube video by Ben Wright (https://youtu.be/EK71U-vTOt4) might be useful to understand the Kadane algorithm 
  for the maximum subarray in a 1-D sequence.

* Input Format
  First line of the input has an integer T. T cases follow. 
  Each test case begins with an integer N. In the next line, N integers follow representing the elements of array A.

* Constraints:
    1≤T≤10
    1≤N≤105
    −104≤ai≤104
  The subarray and subsequences you consider should have at least one element.

* Output Format
  Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. 
  At least one integer should be selected and put into the subarrays 
  (this may be required in cases where all elements are negative).

* Sample Input
    2 
    4 
    1 2 3 4
    6
    2 -1 2 3 4 -5

* Sample Output
    10 10
    10 11

* Explanation
  In the first case: 
  The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

  In the second case: 
  [2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
  For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
//*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // Approach 1
    public static void maxSubSum(int[] arr){
        int n = arr.length;
        if(n == 0) return ;
        if(n == 1) {
            System.out.print(arr[0]);
            return ;
        }
        
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        
        for(int i = 0; i < n; i++){
            curSum += arr[i];
            maxSum = Math.max(maxSum, curSum);
            if(curSum < 0) curSum = 0;
        }
        System.out.print(maxSum);
    }
    //*/
    
    //* Approach #2
    public static void maxSubSum2(int[] arr){
        int n = arr.length;
        if(n == 0) return ;
        if(n == 1) {
            System.out.print(arr[0]);
            return;
        }
        
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        
        for(int i = 0; i < n; i++){
            curSum = arr[i] > (curSum + arr[i])? arr[i] : (curSum + arr[i]);
            maxSum = curSum > maxSum ? curSum : maxSum;
        }
        System.out.print(maxSum);
    }
    
    //*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            maxSubSum(arr);
            //maxSubSum2(arr);
            Arrays.sort(arr);
            System.out.print(" ");
            maxSubSum(arr);
            System.out.println();
        }
    }
}

/* testcase #01
6
1
1
6
-1 -2 -3 -4 -5 -6
2
1 -2
3
1 2 3
1
-10
6
1 -1 -1 -1 -1 5
//*/