/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static class Interval {
		int start;
      	int end;
      	Interval() { start = 0; end = 0; }
      	Interval(int s, int e) { start = s; end = e; }
  	}
  	
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		ArrayList<Interval> res = new ArrayList<Interval>();
		int start = newInterval.start;
		int end = newInterval.end;
		
		for(int i = 0; i < intervals.size(); i++){
			Interval civ = intervals.get(i);
			if(Math.max(civ.start, start) < Math.min(civ.end, end)){ // overlap
				start = Math.min(civ.start, start);
				end = Math.max(civ.end, end);
			} else{
				
				res.add(new Interval(Math.min(start, civ.start), Math.min(civ.end, end)));
				start = Math.max(civ.start, start);
				end = Math.max(civ.end, end);
			}
		}
		res.add(new Interval(start, end));
		
		return res;
    }
    
    public static int findIdxQuick(ArrayList<Interval> intervals, int idx, int start, int end){
        // For testing using quickSort approach. 
    	int lo = start;
    	int hi = end;
    	int res = 0;
    	
    	while(lo <= hi){
    		int mid = (lo+hi)/2;
    		
	    	if( intervals.get(mid-1).start <= idx && idx < intervals.get(mid).start  ){ 
	    		//System.out.println("0-mid.start: " + intervals.get(mid).start + " | mid: " + mid + " | idx: " + idx);
	    		res = mid-1;
	    		break;
		    } else if(intervals.get(mid).start >= idx){
		    	//System.out.println("A-mid.start: " + intervals.get(mid).start + " | idx: " + idx);
		    	hi = mid-1; 
		    } else if(intervals.get(mid).start < idx){
		    	//System.out.println("B-mid.start: " + intervals.get(mid).start + " | mid: " + mid + " | idx: " + idx);
		    	lo = mid+1;
		    }
    	}
    	if(lo > hi) return lo;
    	return res;
    	
    }
    
    public static void displayList(ArrayList<Interval> intervals){
    	
    	for(int i = 0; i < intervals.size(); i++){
    		System.out.println(intervals.get(i).start + " | " + intervals.get(i).end);
    	}
    	//System.out.println();
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] strArr = line.split(" "); 
        //System.out.println("count: " + strArr.length);
        
        ArrayList<Interval> arr = new ArrayList<Interval>();
        //int t = Integer.parseInt(strArr[0]);
        int t = (strArr.length-1)/2;
        int i = 1; 

        while( i < (t*2) ){
        	int start = Integer.parseInt(strArr[i]);
        	int end = Integer.parseInt(strArr[++i]);
        	Interval temp = new Interval(start, end);    	
            arr.add(temp);
            i++;
        }
        
        int st = Integer.parseInt(br.readLine().trim());
        int ed = Integer.parseInt(br.readLine().trim());
        
        Interval newP = new Interval(st, ed);
        
        //displayList(arr);
        displayList(insert(arr, newP));
	}
	
}

/*
Testcase #01
5 1 2 3 5 6 7 8 10 12 16
4 
9


Testcase #02
29 6037774 6198243 6726550 7004541 8842554 10866536 11027721 11341296 11972532 14746848 16374805 16706396 17557262 20518214 22139780 22379559 27212352 28404611 28921768 29621583 29823256 32060921 33950165 36418956 37225039 37785557 40087908 41184444 41922814 45297414 48142402 48244133 48622983 50443163 50898369 55612831 57030757 58120901 59772759 59943999 61141939 64859907 65277782 65296274 67497842 68386607 70414085 73339545 73896106 75605861 79672668 84539434 84821550 86558001 91116470 92198054 96147808 98979097
36210193 
61984219

//*/