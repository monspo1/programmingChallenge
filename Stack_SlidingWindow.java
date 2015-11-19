/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void displayList(ArrayList<Integer> a){
    	for(int i = 0; i < a.size(); i++){
    		System.out.print(a.get(i) + " ");
    	}
    	System.out.println();
    }
    
	public static ArrayList<Integer> maxSlidingWindow(ArrayList<Integer> a, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int i = 0;
		while(i < k){
			
			while(!dq.isEmpty() && a.get(dq.getLast()) <= a.get(i)){
				dq.removeLast();
			}
			dq.addLast(i++); 
		}
		
		res.add(a.get(dq.getFirst()));
		
		while(i < a.size()){
			
			while(!dq.isEmpty() && a.get(dq.getLast()) <= a.get(i)){
				dq.removeLast();
			}
			
			dq.addLast(i);
			
			while(!dq.isEmpty() && i-k >= dq.getFirst()){
				dq.removeFirst(); 
			}
			
			i++;
			res.add(a.get(dq.getFirst()));
			
		}
		
		return res;
	}
	
	 public static int[] windowMax(int[] nums, int window) {  
	 
	   int w = (nums.length < window) ? nums.length : window;  
	   // A deque allows insertion/deletion on both ends.  
	   // Maintain the first as the index of maximal of the window  
	   // and elements after it are all smaller and came later than the first.  
	   Deque<Integer> que = new ArrayDeque<Integer>();  
	   
	   // initialize window  
	   int i=0;  
	   while (i<w) {  
	     while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
	       que.removeLast();  
	     }  
	     que.addLast(i++);  
	   }  
	   
	   // sliding window  
	   int[] max = new int[nums.length - w + 1];  
	   max[i-w] = nums[que.getFirst()];  
	   while (i<nums.length) {  
	     // add new element  
	     while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
	       que.removeLast();  
	     }  
	     que.addLast(i);  
	     // remove old element if still in que  
	     if (!que.isEmpty() && i-w >= que.getFirst()) {  
	       que.removeFirst();  
	     }  
	     // get maximal  
	     ++i;  
	     max[i-w] = nums[que.getFirst()];  
	   }  
	   
	   
	   for(int j = 0; j < max.length; j++){
	   		System.out.print(max[j] + " ");
	   }
	   System.out.println();
	   
	   return max;  
	 }  
	 
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();         
        ArrayList<Integer> arr = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int[] a = new int[n];
        
		for(int i = 0; i < n; i++){
			int num = sc.nextInt();
    	    arr.add(num);    
    	    a[i] = num;
    	    list.add(num);
		}
		int k = sc.nextInt();
		
		displayList(maxSlidingWindow(arr, k));
		windowMax(a, k);
		
	}
}

/* Testcases

- case 1
9 1 2 3 1 4 5 2 3 6 3
Output: 3 3 4 5 5 5 6 

- case 2
10 8 5 10 7 9 4 15 12 90 13 4
Output: 10 10 10 15 15 90 90 

- case 3
7 12 1 78 90 57 89 56 3
Output: 78 90 90 90 89 

- case 4
Input: 2 46 56 2
Output:56

- case 5
Input: 20 3 46 2 56 3 38 93 45 6 78 7 34 76 44 6 7 86 8 44 56 5 
Output: 56 56 93 93 93 93 93 78 78 78 76 76 86 86 86 86 

- case 6
Input: 10 10 9 8 7 6 5 4 3 2 1 2
Output: 10 9 8 7 6 5 4 3 2 

- case 7
Input: 41 718 622 531 279 442 893 282 875 252 70 402 663 22 69 611 412 302 840 589 668 346 983 227 23 703 818 100 943 728 305 72 772 35 721 550 12 405 454 902 978 579 9
Output: 893 893 893 893 893 893 875 875 663 840 840 840 840 983 983 983 983 983 983 983 983 983 943 943 943 943 943 943 772 772 902 978 978 

//*/