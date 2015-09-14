/** Find Median

* link: 
https://www.hackerrank.com/challenges/find-median-1

* Problem Statement
The median of a finite list of numbers can be found by arranging all the integers from lowest to highest value and picking the middle one. For example, the median of {3,3,5,9,11} is 5. If there is an even number of integers, then there is no single middle value, and the median is then usually defined to be the mean of the two middle values. For examples, the median of {3,5,7,9} is (5+7)2=6.

Given that integers are read from a data stream, find the median of elements read so far in an efficient way.

* Input Format

The first line of input will contain integer N, i.e. the number of integers in the data stream.
Each of the next N lines will contain an integer ai.
Constraints 
1≤N≤105 
0≤ai≤105
Output Format

Print N integers, i.e. the median after each of the input. Report it with precision up to 10−1.

* Sample Input
10
1
2
3
4
5
6
7
8
9
10

* Sample Output

1.0
1.5
2.0
2.5
3.0
3.5
4.0
4.5
5.0
5.5
//*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
	static class PriorityQueueComparator implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = new int[t];
		int j = 0;
		
		PriorityQueueComparator pqc=new PriorityQueueComparator();
		
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		PriorityQueue<Integer> rPQ = new PriorityQueue<>(t, pqc);
		
		while(sc.hasNext()){
		    arr[j] = sc.nextInt();
		    j++;
		}
        
        for(int i = 0; i < arr.length; i++){
        	if(rPQ.isEmpty()) rPQ.offer(arr[0]);
        	else{
	            if(arr[i] < rPQ.peek()){
	                rPQ.offer(arr[i]);
	                if(rPQ.size() - PQ.size() > 1){
	                    PQ.offer(rPQ.poll());    
	                }    
	            } else {
	                PQ.offer(arr[i]);
	                if(PQ.size() - rPQ.size() > 1){
	                    rPQ.offer(PQ.poll());
	                }
	            }
        	}
            if((PQ.size() + rPQ.size())%2 == 0){
            	System.out.println( (((float)PQ.peek() + (float)rPQ.peek())/2) );
            } else{
            	if(PQ.size() > rPQ.size()){
            		System.out.println((float)PQ.peek());
            	} else {
            		System.out.println((float)rPQ.peek());
            	}
            }
            
        }
	}
}