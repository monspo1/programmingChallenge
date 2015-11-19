/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int findRank(String A) {
		char[] charArr = A.toCharArray();
		Arrays.sort(charArr);
		int n = A.length();
		int count = 0;
		
		int i = 0, j = 0;
		while(j < n){
			while(i < n){
				if(A.charAt(j) != charArr[i] ){
					if(j < n-1) count += factorial(n-1-j);
					i++;
				} else{
					j++;
					i = 0;
					break;
				}
				if(i >= n) i= 0;
			} 
			//j++;
		}
		return count+1;
	}
	
	public static int factorial(int a){
		if(a == 1) return 1;
		if(a == 0) return 0;
		return a * factorial(a-1);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//System.out.println(findRank("DTNGJPE"));
		System.out.println("acd: " + findRank("acd"));
		System.out.println("cba: " + findRank("cba"));
		System.out.println("VIEW: " + findRank("VIEW"));
		//System.out.println(findRank("dfab"));
	}
}