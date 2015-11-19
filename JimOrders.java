/* 
* Problem Titie: Jim and the Orders

* Problem Statement
    In Jim's Burger, n hungry burger fans are ordering burgers. 
    The ith order is placed by the ith fan at ti time and it takes di time to procees. 
    What is the order in which the fans will get their burgers?

* Input Format 
    On the first line you will get n, the number of orders. 
    Then n lines will follow. On the (i+1)th line, you will get ti and di separated by a single space.

* Output Format 
    Print the order ( as single space separated integers ) in which the burger fans get their burgers. 
    If two fans get the burger at the same time, then print the smallest numbered order first.
    (remember, the fans are numbered 1 to n).

* Constraints 
    1≤n≤103 
    1≤ti,di≤106

* Sample Input #00
    3
    1 3
    2 3
    3 3
    
* Sample Output #00
    1 2 3
    
* Explanation #00
    The first order is placed at time 1 and it takes 3 units of time to process, 
    so the burger is sent to the customer at time 4. 
    The 2nd and 3rd are similarly processed at time 5 and time 6. Hence the order 1 2 3.

* Sample Input #01
    5
    8 1
    4 2
    5 6
    3 1
    4 3

* Sample Output #01
    4 2 5 1 3

* Explanation #01
    The first order is placed at time 3 and it takes 1 unit of time to process, 
    so the burger is sent to the customer at time 4. 
    The second order is placed at time 4 and it takes 2 units of time to process, 
    the burger is sent to customer at time 6. 
    The third order is placed at time 4 and it takes 3 units of time to process, 
    the burger is sent to the customer at time 7. 
    Similarly, the fourth and fifth orders are sent to the customer at time 9 and time 11.
    So the order of delivery of burgers is, 4 2 5 1 3.

//*/

// For hackerRank submisssion.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution { 
    
    // My initial solution (relatively less optimized)
    public static class ValueComparator implements Comparator{
        Map map;
        
        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object key1, Object key2) {
            Comparable valueA = (Comparable) map.get(key1);
            Comparable valueB = (Comparable) map.get(key2);
            int res = valueA.compareTo(valueB);
            if(res == 0){
            	int a = Integer.valueOf(key1.toString());
            	int b = Integer.valueOf(key2.toString());
            	if(a < b){   // 뒤에게 크면 -1
            		return -1;	
            	} else if(a > b){
            		return 1;
            	} else return 0;
            }
            return res;
        }
    }
    
    public static Map sortByValue(Map unsortedMap) {
		Map<Integer, Integer> sorted = new TreeMap(new ValueComparator(unsortedMap));
		sorted.putAll(unsortedMap);
		return sorted;
	}
    
    public static void main(String[] args) {
        // Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		HashMap<Integer, Integer> unsorted = new HashMap<>();
		int i = 0; 
		
		while(sc.hasNext()){
		    int ti = sc.nextInt();
		    int di = sc.nextInt();
		    unsorted.put(new Integer(i+1), new Integer(ti+di));
		    i++;
		}
	
        Map<Integer, Integer> sortedMap = sortByValue(unsorted);
        
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
		    System.out.print(entry.getKey() + " ");
		}
    }
}

//*/

// youssefhassan's solution (Optimal & Super Simple)
// https://codepair.hackerrank.com/paper/evEqZpFi?b=eyJyb2xlIjoiY2FuZGlkYXRlIiwibmFtZSI6Im1vbnNwbzIiLCJlbWFpbCI6Im1vbnNwbzJAZ21haWwuY29tIn0%3D
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int t, d;
		Map<Integer, ArrayList<Integer>> timeToFans = new TreeMap<Integer, ArrayList<Integer>>(); 
		for (int i = 1; i <= num; i++) {
			t = in.nextInt();
			d = in.nextInt();
			if (!timeToFans.containsKey(t + d))
				timeToFans.put(t + d, new ArrayList<Integer>()); // TreeMap은 저장될 때 key를 자동적으로 정렬한다.
			timeToFans.get(t + d).add(i);
		}
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, ArrayList<Integer>> e : timeToFans.entrySet()) {
			for (Integer fan : e.getValue()) {
				sb.append(fan);
				sb.append(" ");
			}
		}
		System.out.println(sb.toString().trim());
	}
}


// 요것도 봐
// https://codepair.hackerrank.com/paper/MciDbGKl?b=eyJyb2xlIjoiY2FuZGlkYXRlIiwibmFtZSI6Im1vbnNwbzIiLCJlbWFpbCI6Im1vbnNwbzJAZ21haWwuY29tIn0%3D
class Pair implements Comparable{
    int i;
    long t;
    public Pair(int i, long t){
        this.i = i;
        this.t = t;
    }

    public int compareTo(Object o){
        Pair p=(Pair) o;
        if(this.t < p.t){
            return -1;
        } else if(this.t > p.t){
            return 1;   
        } else {
            return this.i < p.i? this.i: p.i;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        Set<Pair> set = new TreeSet<Pair>();
        for(int i=0;i<T;i++){
            long t = sc.nextLong();
            long d = sc.nextLong();
            
            set.add(new Pair(i+1, t + d));
        }
        for(Pair p: set){
            System.out.print(p.i + " ");
        }
        sc.close();                
    }
}


/* Testing at Ideone
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static class ValueComparator implements Comparator{
        Map map;
        
        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object key1, Object key2) {
            Comparable valueA = (Comparable) map.get(key1);
            Comparable valueB = (Comparable) map.get(key2);
            int res = valueA.compareTo(valueB); 
            //System.out.println("res: " + res + " | valueA(" + valueA + ") vs valueB(" + valueB + ")");	// 0 -1 1
            if(res == 0){
            	int a = Integer.valueOf(key1.toString()); 
            	int b = Integer.valueOf(key2.toString());
            	if(a < b){   // 뒤에게 크면 -1
            		return -1;	
            	} else if(a > b){
            		return 1;
            	} else return 0;
            }
            return res;
        }
    }
    
    public static Map sortByValue(Map unsortedMap) {
		Map<Integer, Integer> sorted = new TreeMap(new ValueComparator(unsortedMap));
		sorted.putAll(unsortedMap);
		return sorted;
	}
    
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		HashMap<Integer, Integer> unsorted = new HashMap<>();
		int i = 0; 
		
		while(sc.hasNext()){
		    int ti = sc.nextInt();
		    int di = sc.nextInt();
		    unsorted.put(new Integer(i+1), new Integer(ti+di));
		    i++;
		}
	
        Map<Integer, Integer> sortedMap = sortByValue(unsorted);
        
        //for(i = 0; i < sortedMap.size(); i++)
        //	System.out.println(sortedMap.keySet());
        
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
		    //System.out.println(entry.getKey() + " | " + entry.getValue());
		    System.out.print(entry.getKey() + " ");
		}
	
	}
}
//*/