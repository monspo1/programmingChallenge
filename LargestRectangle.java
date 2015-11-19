/* Largest rectangle area in histogram
http://www.informatik.uni-ulm.de/acm/Locals/2003/html/histogram.html

* Problem statement:
  A histogram is a polygon composed of a sequence of rectangles aligned at a common base line. 
  The rectangles have equal widths but may have different heights. 
  For example, the figure on the left shows the histogram that consists of rectangles with the heights 
  2, 1, 4, 5, 1, 3, 3, measured in units where 1 is the width of the rectangles:

  Usually, histograms are used to represent discrete distributions, e.g., the frequencies of characters in texts. 
  Note that the order of the rectangles, i.e., their heights, is important. 
  Calculate the area of the largest rectangle in a histogram that is aligned at the common base line, too. 
  The figure on the right shows the largest aligned rectangle for the depicted histogram.

* Input Specification
  The input contains several test cases. Each test case describes a histogram and starts with an integer n, 
  denoting the number of rectangles it is composed of. You may assume that 1<=n<=100000. 
  Then follow n integers h1,...,hn, where 0<=hi<=1000000000. 
  These numbers denote the heights of the rectangles of the histogram in left-to-right order. 
  The width of each rectangle is 1. A zero follows the input for the last test case.

* Output Specification
  For each test case output on a single line the area of the largest rectangle in the specified histogram. 
  Remember that this rectangle must be aligned at the common base line.

* Sample Input
    7 2 1 4 5 1 3 3
    4 1000 1000 1000 1000
    0
    
* Sample Output
    8
    4000
    
//*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int MaxAreaNaive(int[] h){
        int maxArea = 0, area = 0;
        int n = h.length;
        
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while(left >= 0 && h[left] >= h[i] ) left--;
            while(right < n && h[right] >= h[i]) right++;
            area = h[i] * (right - left - 1);
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }
    
    /*
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        int[] h = new int[n];
        for(int i=0;i<n;i++){
            h[i] = sc.nextInt();
        }
        
        Stack<Integer> s = new Stack<Integer>();
        long maxArea = 0;

        // Vizualise all buildings as a histogram
        // Run through all bars of given histogram
        int i=0;
        for(;i<n;i++){
            // If this bar is higher than the bar on top stack, push it to stack
            if(s.isEmpty() || h[s.peek()]<=h[i]){
                s.push(i);
                
            } else{
                // If this bar is lower than top of stack, then calculate area of rectangle 
                // with stack top as the smallest (or minimum height) bar. 'i' is 
                // 'right index' for the top and element before top in stack is 'left index' i.e x.
                while(!s.isEmpty() && h[s.peek()]>h[i]){
                    int x = s.pop();
                    // int leftIndex = s.peek();
                    // Calculate the area with h[x] stack as smallest bar
                    long ar =  h[x]*(s.isEmpty()?i:i-s.peek()-1);
                    if(ar>maxArea){
                        maxArea = ar;
                    }
                }
                s.push(i);
            }
                     
        }
        
        while(!s.isEmpty()){
            int x = s.pop();
            //int leftIndex = s.peek();
            long ar = h[x]*(s.isEmpty()?i:i-s.peek()-1);
            if(ar>maxAr){
                maxAr = ar;
            }
        }
        System.out.print(maxAr);
    }
    //*/
}