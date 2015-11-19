

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static ArrayList<ArrayList<Integer>> generate(int a) {
	    //if(a == 1) System.out.print(a); //<-- unnecessary (cause error)
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    
	    for(int i = 0; i < a; i++){
	        res.add(new ArrayList<Integer>());
	        res.get(i).add(1);
	    }
	    
	    for(int i = 1; i < a; i++){
	        ArrayList<Integer> prevList = res.get(i-1);
	        ArrayList<Integer> curList = res.get(i);
	        int psize = prevList.size();
	        
	        int j = 1;
	        while(j <= prevList.size()){
	        	int t1 = j-1 < 0 ? 0 : prevList.get(j-1);
	        	int t2 = j > prevList.size()-1 ? 0 : prevList.get(j);
	        	curList.add(t1+t2);
	        	j++;
	        }
	        
	        res.set(i, curList);
	    }
	    return res;
    }
       
    
    public static void displayList(ArrayList<ArrayList<Integer>> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		for(int j = 0; j < a.get(i).size(); j++){
    			System.out.print(a.get(i).get(j));
    		}
    		System.out.println();
    	}
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		displayList(generate(a));
	}
}