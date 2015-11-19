import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void displayList(ArrayList<Integer> a){ //String
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

	public static int rain(ArrayList<Integer> a) {
	    if(a == null || a.size() < 2) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, sum = 0;
		while(i < a.size() && a.get(i) == 0) i++;
		
		while(i < a.size()){
			
			while(!stack.isEmpty() && a.get(i) >= a.get(stack.peek())){
				int t = stack.pop();
				if (stack.isEmpty()) break;
				
                //sum += ((i-stack.peek()-1) * (Math.min(a.get(i), a.get(stack.peek())) - a.get(t)));
                int w = i-stack.peek()-1;
				int h = Math.min(a.get(i), a.get(stack.peek())) - (a.get(t));
				sum += (w * h);
			}
			stack.push(i);
			i++;
		}
		return sum;
	}
    /* Test cases
    - case 1:
    Input: 12 0 1 0 2 1 0 1 3 2 1 2 1 
    Output: 6
    
    - case 2:
    Input: 23 0 3 4 3 5 3 2 0 1 7 7 4 3 8 1 3 4 0 3 4 9 19 9 
    Output: 55
    
    - case 3:
    Input: 
    Output:
    
    - case :
    Input: 
    Output:
    
    - case :
    Input: 
    Output:
    
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
        System.out.println("maxArea: " + rain(arr));
	}
}