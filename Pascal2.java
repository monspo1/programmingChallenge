/*  Pascal2
Given an index k, return the kth row of the Pascal’s triangle.  
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.  
Example:  Input : k = 3  Return : [1,3,3,1]      
NOTE : k is 0 based. k = 0, corresponds to the row [1].   
Note:Could you optimize your algorithm to use only O(k) extra space?
//*/
public class Solution {
    // My solution
	public ArrayList<Integer> getRow(int a) {
	    ArrayList<Integer> res = new ArrayList<>();
	    res.add(1);
	    if(a == 0) return res; // Don't return an empty ArrayList
	    
	    for(int i = 0; i < a; i++){
	        ArrayList<Integer> prev = res;
	        res = new ArrayList<>();
	        res.add(1);
	        int j = 1;
	        
	        while(j <= prev.size()){
	            int t1 = j-1 < 0 ? 0 : prev.get(j-1);    
	            int t2 = j > prev.size()-1 ? 0 : prev.get(j);
	            res.add(t1+t2);
	            j++;
	        }
	    }
	    return res;
	}
    
    public static void displayList(ArrayList<Integer> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		System.out.print(a.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		displayList(getRow(a));
	}
}
