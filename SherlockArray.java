import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(sc.hasNext()){

            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            if(sherlockBetter(arr)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
              
    
    public static boolean sherlockBetter(int[] arr){
        int n = arr.length;
        if(n == 1) return true;
        
        int[] sumFromLeft = new int[n]; 
        int[] sumFromRight = new int[n];   
        sumFromLeft[0] = arr[0];    
        sumFromRight[n-1] = arr[n-1];    
        int i = 1, j = n-2;    

        while(i < n){  
            sumFromLeft[i] = arr[i] + sumFromLeft[i-1]; 
            i++;
        }
        while(j >= 0){
            sumFromRight[j] = arr[j] + sumFromRight[j+1];
            j--;
        }
        
        int m = 1;
        while(m + 1 < n){
            if(sumFromLeft[m-1] == sumFromRight[m+1]) return true;  
            m++;
        }
        return false;
    }  
    
    public static boolean sherlockNaive(int[] arr){
        int i = 1, n = arr.length, leftSum, rightSum;
        if(arr.length < 1){ 
            return true;
        }
        while(i < n){ 
            leftSum = 0;  rightSum = 0;
            for(int j = 0; j < i; j++) leftSum += arr[j];
            for(int j = i+1; j < n; j++) rightSum += arr[j]; 

            if(leftSum == rightSum) return true;
            i++;
        }
        //*/
        return false;
    }
}