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
    
    public static void nextPermutation(ArrayList<Integer> a) {
		if(a == null || a.size() == 0 || a.size()==1 ) return;
		int n = a.size();
		//System.out.print("1: ");
		//displayList(a);
		
		int i = n-2;
		while(i >= 0 && a.get(i) >= a.get(i+1)) i--;
		System.out.println("a.get(" + i + "): " + a.get(i) + " < a.get(" + (i+1) + "): " + a.get(i+1));
		System.out.print("2: ");
		displayList( a);
		
		int pivot = a.get(i);
		//int j = i+2;
		//while(j < n && a.get(i) > a.get(j)) j++; // Wrong
		int j = n-1;
		while(j > i && a.get(j) <= a.get(i)) j--;
		//System.out.println("a.get(" + j + "): " + a.get(j));
		//System.out.println("a.get(" + j + "): " + a.get(j) + " || i: " + i + " | a.get(i): " + a.get(i));
		
		if(i >= 0){
			swap(a, i, j);
		}
		//System.out.print("3: ");
		//displayList( a);
		
		int start = i+1;
		int end = n-1;
		while(start < end){
			swap(a, start, end);
			start++;
			end--;
		}
		System.out.print("4: ");
		displayList(a);
	}
	
	public static void swap(ArrayList<Integer> a, int i, int j){
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
	
	/*
	1,2,3 → 1,3,2
	
	3,2,1 → 1,2,3
	
	1,1,5 → 1,5,1
	
	20, 50, 113 → 20, 113, 50
	//*/	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(sc.hasNext()){
        	arr.add(sc.nextInt());
        }
        System.out.println("arr.size: " + arr.size() );
		//displayList(arr);
		nextPermutation(arr);
	}
}


