/* Only for NxN array */

import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static ArrayList<ArrayList<Integer>> spiral(ArrayList<ArrayList<Integer>> arr){
		int n = arr.size();
		int until = n/2;
		int idx = 0;
		//int i = 0, j = 0;
		
		while(idx < until){
			for(int i = idx; i < n-1-idx; i++)
				System.out.print(arr.get(idx).get(i) + " ");
			
			for(int i = idx; i < n-1-idx; i++)
				System.out.print(arr.get(i).get(n-1-idx) + " ");
			
			for(int i = idx; i < n-1-idx; i++)
				System.out.print(arr.get(n-1-idx).get(n-1-i) + " ");
				
			for(int i = idx; i < n-1-idx; i++)
				System.out.print(arr.get(n-1-i).get(idx) + " ");
				
			//System.out.println();
			idx++;
		}
        if(n%2 == 1) System.out.print(arr.get(idx).get(idx));
    	return arr;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		
        while(sc.hasNext()){
        	ArrayList<Integer> sub = new ArrayList<>();
        	for(int i = 0; i < t; i++){
            	sub.add(sc.nextInt());
        	}
        	arr.add(sub);
        }
		//displayList(spiral(arr));
		spiral(arr);
	}
}
/*
* Input #1
3
1 2 3 
4 5 6
7 8 9
=> Output: 1 2 3 6 9 8 7 4 

* Input 32
4
1 2 3 4 
5 6 7 8 
9 10 11 12
13 14 15 16
=> Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
=> 1 2 3 4 5 10 15 20 25 24 23 22 21 16 11 6 7 8 9 14 19 18 17 12 13

*/