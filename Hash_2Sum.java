import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void displayList(ArrayList<Integer> a){
    	for(int i = 0; i < a.size(); i++){
    		System.out.print(a.get(i) + " ");
    	}
    	System.out.println();
    }
    
    //http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
    public static ArrayList<Integer> twoSum(ArrayList<Integer> a, int b){
    	if(a == null || a.size()== 0) return a;
    	
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    	int prev = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < a.size(); i++){
    		
    		if(!hmap.containsKey(a.get(i))){
    			hmap.put(b-a.get(i), i);
    			
    		} else{ // containsKey 
    			if(a.get(i) < prev){
    				int index = hmap.get(a.get(i));
	    			res.add(index+1);
	    			res.add(i+1);	
	    			prev = a.get(i);
    			}
    		}
    	}
    	return res;
    }
    /* Testcases
    - case 
    Input: 6 2 3 6 7 9 11 9
    Output: 2 3
    
    - case 
    Input: 17 2 2 2 2 3 3 3 3 6 6 6 7 7 7 7 9 11 9 
    Output: 5 9
    
    - case 
    Input: 4 2 7 11 15 9
    Output: 1 2
    
    - case 
    Input: 9 2 2 2 3 6 7 8 10 11 9 
    Output: 4 5
    
    - case 
    Input: 
    Output: 
    //*/
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();         
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
		for(int i = 0; i < n; i++){
    	    arr.add(sc.nextInt());    
		}
		n = sc.nextInt();
		
		displayList(twoSum(arr, n));
	}
}