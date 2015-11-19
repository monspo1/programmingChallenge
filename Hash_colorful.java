import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {    
    
    //http://algorithms.tutorialhorizon.com/colorful-numbers/
    public static int colorful(int a){
    	
    	Hashtable<Integer, Integer>  htable = new Hashtable<Integer, Integer>();
    	int[] arr = getDigits(a);
    	boolean[] used = new boolean[arr.length];
    	return (powerSet(htable, arr, used, 0)) ? 1 : 0;
    }
    
    public static int[] getDigits(int num){
    	int len = String.valueOf(num).length();
    	int[] arr = new int[len];
    	int i = len-1;
    	
    	while(num > 0){
    		int r = num%10;
    		num /= 10;
    		arr[i] = r;
    		i--;
    	}
    	return arr;
    }
    
    public static boolean powerSet(Hashtable<Integer, Integer>  htable, int[] arr, boolean[] used, int x){
    	if(x == used.length-1){
    		used[x] = false;
    		boolean b = insertInHash(htable, arr, used);
    		if(b){
    			used[x] = true;
    			return insertInHash(htable, arr, used);
    		} else{
    			return false;
    		}
    	}
		used[x] = false;
		boolean p = powerSet(htable, arr, used, x+1);
		used[x] = true;
		return p & powerSet(htable, arr, used, x+1);
    }
    
    public static boolean insertInHash(Hashtable<Integer, Integer>  htable, int[] arr, boolean[] used){
    	int sum = 0;
    	for(int i = 0; i < used.length; i++){
    		if(used[i]){
    			if(sum == 0) sum = arr[i];
    			else sum *= arr[i];
    		} 
    	}
    	if(htable.containsKey(sum)){
    		return false;
    	} else{
    		htable.put(sum, 1);
    		return true;
    	}
    }
    /* Testcases
    - case 
    Input: 
    Output: 
    
    - case 
    Input: 
    Output: 
    
    - case 
    Input: 
    Output: 
    
    - case 
    Input: 
    Output: 
    
    - case 
    Input: 
    Output: 
    
    //*/
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();         
        
		System.out.println(colorful(n));
	}
}