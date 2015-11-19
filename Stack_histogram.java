import java.util.*;
import java.lang.*;
import java.io.*;

class TestClass {
    
    public static void displayList(ArrayList<Integer> a){ //String
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

	public static int maxArea(ArrayList<Integer> a) {
	    if(a == null || a.size() < 2) return 0;
	    
	    int left = 0;
	    int right = a.size()-1;
	    int max = Integer.MIN_VALUE;
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    while(left < right){
	    	int s = (right-left+1) * Math.min(a.get(right), a.get(left));
            
	    	max = (s > max)? s : max;
	    	if(a.get(left) < a.get(right)){
	    		left++;
	    	} else right--;
	    }
	    return max;
	}

    public static int largestRectMax(ArrayList<Integer> a) {
	    if(a == null || a.size() < 2) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;

        while(i < a.size()){
            if(stack.isEmpty() || a.get(i) >= a.get(stack.peek().intValue())){
                stack.push(i);
                i++;
            } else{
                int p = stack.pop().intValue();
                int h = a.get(p);
                int w = stack.isEmpty() ? i : i - stack.peek().intValue() -1;
                max = Math.max(h*w, max);
            }
        }
        
        while(!stack.isEmpty()){
            int p = stack.pop().intValue();
            int h = a.get(p);
            int w = stack.isEmpty() ? i : i - stack.peek().intValue() - 1;
            max = Math.max(h*w, max);
        }
        
        return max;
    }
    
    public static int largestRectangleArea(ArrayList<Integer> a) {
        if(a == null || a.size() == 0) return 0;
        
	    Stack<Integer> stack = new Stack<Integer>();
	    int maxS = 0;
	    int i = 0;
	    
	    while(i < a.size()){
	        if(stack.isEmpty() || a.get(i) >= a.get(stack.peek().intValue())){
	            stack.push(i);
	            i++;
	        } else{
	            int t = stack.pop().intValue();
	            int width = (stack.isEmpty() ? i : i - stack.peek().intValue() -1);
	            int s = a.get(t) * width;
	            maxS = Math.max(maxS, s);
	        }
	    }
	    
	    while(!stack.isEmpty()){
	        int t = stack.pop().intValue();
            int width = (stack.isEmpty() ? i : i - stack.peek().intValue() -1);
            int s = a.get(t) * width;
            maxS = Math.max(maxS, s);
	    }
	    
	    return maxS;
    }
    
    /* Testcases
    - case 1:
    4 1 5 4 3
    Output: 9
    
    - case 2:
    6 2 1 5 6 2 3
    Output: 10
    
    - case 3:
    5 4 3 2 5 1
    Output: 8
    
    - case 4:
    2 1 0 6 2 3
    
    - case 5:
    11 2 1 2 6 1 7 1 0 6 2 3 
    Output: 7
    
    - case 6: 
    7 5 2 1 0 6 2 3 
    Output: 6
    
    - case 7:
    7 5 2 1 4 6 2 3 
    Output: 8
    //*/
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < t; i++){
            arr.add(sc.nextInt());
        }
        
        System.out.println("arr.size: " + arr.size() );
        displayList(arr);     
        System.out.println("maxArea: " + maxArea(arr));
        System.out.println("largestRectMax: " + largestRectMax(arr));
        System.out.println("largestRectangleArea: " + largestRectangleArea(arr));
    }
}