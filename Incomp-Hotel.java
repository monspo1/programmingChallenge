
/* Ideone 테스트용
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    	
 		sortArrQuick(arrive, depart, 0, arrive.size()-1);
    	
    	int endIdx = 0;   	
 		int count = 0;
 		
 		while(endIdx < arrive.size() && arrive.get(endIdx) <= K ) endIdx++;
    	endIdx = endIdx >= arrive.size() ? arrive.size()-1 : endIdx;
    	
    	for(int i = 0; i <= endIdx; i++){
    		if(arrive.get(i) <= K && K <= depart.get(i))
    			count++;
    	}
    	System.out.println("count : " + count + " | K: " + K);
    	
    	if(count <= K) return true;
    	else return false;
    }
    
    public static void sortArrQuick(ArrayList<Integer> arrive, ArrayList<Integer> depart, int receivedLow, int receivedHigh){
    	int lo = receivedLow;
		int hi = receivedHigh;       
 		int pivot = arrive.get( (receivedLow + receivedHigh)/2 );
        
		while (lo <= hi) {
       		while (arrive.get(lo) < pivot) lo++;     
            while (arrive.get(hi) > pivot) hi--; 
			if (lo <= hi) {                        
        		if (arrive.get(lo) > arrive.get(hi)) {  
            		int TMP = arrive.get(lo);
            		arrive.set(lo, arrive.get(hi));
            		arrive.set(hi, TMP);
            		
            		TMP = depart.get(lo);
            		depart.set(lo, depart.get(hi));
            		depart.set(hi, TMP);
            		
            	}   
            	lo++;                
            	hi--;
			}
		}
    
		if (receivedLow < hi) sortArrQuick(arrive, depart, receivedLow, hi);  
		if (lo < receivedHigh) sortArrQuick(arrive, depart, lo, receivedHigh);
    }
    
	public static boolean hotel2(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    	
    	int startIdx = 0;
 		int endIdx = arrive.size()-1;   	
 		int count = 0;
 		
 		while(endIdx >= 0 && arrive.get(endIdx) > K ) endIdx--;
    	while(startIdx < depart.size() && depart.get(startIdx) < K) startIdx++;
    	
    	System.out.println("startIdx : " + startIdx + " | endIdx: " + endIdx);
    	
    	for(int i = startIdx; i <= endIdx; i++){
    		if(arrive.get(startIdx) <= K && K <= depart.get(endIdx))
    			count++;
    	}
    	System.out.println("count : " + count + " | K: " + K);
    	if(count <= K) return true;
    	else return false;
    }
    
    public static void displayList(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    	System.out.print("Arrive: ");
    	for(int i = 0; i < arrive.size(); i++){
    		System.out.print(arrive.get(i) + " ");	
    	}
    	System.out.print("\nDepart: ");
    	for(int i = 0; i < depart.size(); i++){
    		System.out.print(depart.get(i) + " ");	
    	}
    	System.out.print("\nk: " + K);
    }
    
    public static boolean hotel3(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    	
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(int i : arrive){ if(i < min) min =i; }
    	for(int i : depart){ if(i > max) max =i; }
    	
    	sortArrQuick(arrive, depart, 0, arrive.size()-1);
    	
 		int count = 0;
 		
    	for(int i = 0; i <= arrive.size(); i++){
    		if(arrive.get(i) <= K && K <= depart.get(i))
    			count++;
    	}
    	System.out.println("count : " + count + " | K: " + K);
    	
    	if(count <= K) return true;
    	else return false;
    	
    	
    }
 
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arrive = new ArrayList<>();
		ArrayList<Integer> depart = new ArrayList<>();
 		int k = 0;
 		
        while(sc.hasNext()){
        	int amax = sc.nextInt();
        	for(int i = 0; i < amax; i++)
            	arrive.add(sc.nextInt());
 
        	int dmax = sc.nextInt();
        	for(int i = 0; i < dmax; i++)
            	depart.add(sc.nextInt());
 
        	k = sc.nextInt();
        }
 
        if(hotel(arrive, depart, k)) System.out.println("1");
        else System.out.println("0");
	}
}
//*/


/* Previous solution (문제 잘못 이해한 솔루션)
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        
        sortArrQuick(arrive, depart, 0, arrive.size()-1);

        int endIdx = 0;
        int count = 0;
        
        while(endIdx < arrive.size() && arrive.get(endIdx) <= K) endIdx++;
        endIdx = endIdx >= arrive.size() ? arrive.size()-1 : endIdx;
        
        for(int i = 0; i <= endIdx; i++){
            if(arrive.get(i) <= K && K <= depart.get(i)){
                count++;
            }
        }
        if(count <= K) return true;
        else return false;
        
    }
    
    public static void sortArrQuick(ArrayList<Integer> arrive, ArrayList<Integer> depart, int receivedLow, int receivedHigh){
        int lo = receivedLow;
        int hi = receivedHigh;
        int pivot = arrive.get((lo+hi)/2 );
        
        while(lo <= hi){
            while(arrive.get(lo) < pivot) lo++;
            while(arrive.get(hi) > pivot) hi--;
            
            if(lo <= hi){
                if(arrive.get(lo) > arrive.get(hi)){
                    int tmp = arrive.get(lo);
                    arrive.set(lo, arrive.get(hi));
                    arrive.set(hi, tmp);
                    
                    tmp = depart.get(lo);
                    depart.set(lo, depart.get(hi));
                    depart.set(hi, tmp);
                }
                lo++;
                hi--;
            }
        }
        if(receivedLow < hi) sortArrQuick(arrive, depart, receivedLow, hi);
        if(lo < receivedHigh) sortArrQuick(arrive, depart, lo, receivedHigh);
    }
}
//*/



// jdoodle 테스트용
public static void quick(int[] arrive,int[] depart, int low, int high, 
                                                    int count, int max){
    
    int i = 0;  
    count = 1;   
    max = count;     
     
    while(i < arrive.length){        
        if(arrive[i] != depart[i]) {
            int left = arrive[i];
            int right = depart[i];
            int j = i >= arrive.length ? i : i+1;
            
            while(j < arrive.length){
                    
                if(left <= arrive[j] && arrive[j] <= right ){
                    System.out.println("ar[" + j + "]: " + arrive[j] + " left: " + left + " | right: " + right + " | count: " + count + " | max: " + max);                    count++;
                    if(count >= max) max = count;
                    left = arrive[j];
                    right = depart[j];
                } 
                if(arrive[j] > right){
                    count--;
                }
                j++;
            }
        }
        count = 1; 
        i++;
    }
    
    System.out.println("max: " + max + " | count: " + count);
}

public static void main(String args[]) {
    /* Ex1-output: 3
    int[] arrive = {2, 3, 4, 8};
    int[] depart = {2, 15, 10, 50}; //*/

    /* Ex2-output: 3
    int[] arrive = {1, 3, 4};
    int[] depart = {12, 8, 6}; //*/

    /* Ex3-output: 2
    int[] arrive = {1, 3, 7};
    int[] depart = {12, 6, 14}; //*/

    /* Ex4-output: 2
    int[] arrive = {1, 3, 5};
    int[] depart = {2, 6, 8}; //*/

    //* Ex5-output: 4
    int[] arrive = {1, 2, 3, 4};
    int[] depart = {10, 2, 6, 14}; //*/

    int count = 0; 
    int max = Integer.MIN_VALUE;

    quick(arrive, depart, 0, arrive.length, count, max);
}


