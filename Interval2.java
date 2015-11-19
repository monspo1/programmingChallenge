/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static class Interval {
		int start;
      	int end;
      	Interval() { start = 0; end = 0; }
      	Interval(int s, int e) { start = s; end = e; }
  	}
  	
  	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0 || intervals.size() == 1) return intervals;
        
        Collections.sort(intervals, new intervalComparator());
        
        int first = intervals.get(0).start;
        int end = intervals.get(0).end;
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            
            if(cur.start <= end){ 
                /* 이전 문제와 같이 아래와 같이 해도 동일한 결과 나옴.
                if(Math.max(civ.start, start) < Math.min(civ.end, end)){ // overlap
                //*/
                start = Math.min(start, cur.start);
                end = Math.max(end, cur.end);
            } else{
                res.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        
        res.add(new Interval(start, end));
        
        return res;
    }
    
    public static void displayList(ArrayList<Interval> intervals){
    	
    	for(int i = 0; i < intervals.size(); i++){
    		System.out.println(intervals.get(i).start + " | " + intervals.get(i).end);
    	}
    	//System.out.println();
    }
    
    public static class intervalComparator implements Comparator{
        public int compare(Object o1, Object o2){
            Interval i1 = (Interval) o1;
            Interval i2 = (Interval) o2;
            if(i1.start < i2.start) return 1;
            else if(i1.start > i2.start) return -1;
            else return 0;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        ArrayList<Interval> arr = new ArrayList<Interval>();
        
        while(sc.hasNext()){
        	int start = Integer.parseInt(strArr[i]);
        	int end = Integer.parseInt(strArr[++i]);
        	Interval temp = new Interval(start, end);    	
            arr.add(temp);
        }
        displayList(arr);
        //displayList(insert(arr, newP));
	}
}
/*
Testcase:
4 1 3 2 6 8 10 15 18 

4 1 3 2 6 7 10 8 18 

2 1 10 10 10

//*/