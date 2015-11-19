import java.util.*;
import java.lang.*;
import java.io.*;
 
//http://www.geeksforgeeks.org/next-greater-element/
class Ideone
{
	public static void displayList(ArrayList<Integer> a){ //String
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		
	}
	public static ArrayList<Integer> prevGreater(ArrayList<Integer> arr) {
    	if(arr == null || arr.size() == 0) return null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr.get(0));
        int popped = -1;
        int cur = -1;
        
        for(int i = 1; i < arr.size(); i++){
        	cur = arr.get(i);
        	
        	if(!stack.isEmpty()){
        		popped = stack.pop();
        		
        		while(popped < cur ){
        			System.out.print(popped + " --> " + cur + " ");
        			res.add(cur);
        			if(stack.isEmpty()) break;
        			popped = stack.pop();
        		}
        		if(popped > cur){
	        		stack.push(popped);
	        	}
        	}
        	stack.push(cur);
        }
        
        while(!stack.isEmpty()){
        	popped = stack.pop();
        	cur = -1;
        	System.out.print(popped + " --> " + cur + " ");
        	res.add(cur);
        }
        return res;
	}
    /* Test cases for Next Smaller Element
    - case 1:
    Input: 
    Output: 
    
    - case 2:
    Input: 10 3 5 4 3 2 1 7 4 6 9 
    Output: -1 3 3 -1 -1 -1 1 1 4 6
    
    - case 3:
    Input: 
    Output:
    
    /* Test cases for Next Greater Element
    - case 
    Input: 4 11 13 21 3
    Output: 5 5 10 -1
    
    - case :
    Input: 4 11 13 21 3 
    Output: 13, 21, -1, -1
    
    //*/
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < t; i++){
            arr.add(sc.nextInt());
        }
        
        System.out.println("arr.size: " + arr.size() );
        displayList(arr);     
        System.out.println("Nearest: " + prevSmaller(arr));
	}
}