public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    ArrayList<Integer> res = new ArrayList<>();
	    ArrayList<Integer> reverse = new ArrayList<>();
	    
	    if(a.size() == 0){
	        res.add(1);
	        return res;
	    } if(a.size() == 1){
	        int tmp = a.get(0) + 1;
	        if(tmp > 9){
	            res.add(1);
	            res.add(tmp%10);
	            return res;
	        }else{
	            res.add(tmp);
	            return res;
	        }
	    }
	    
	    int n = a.size();
	    int tempSum = 0;
	    int remaining = 0;
	    
	    int z = 0; 
	    while(z < a.size() && a.get(z) == 0){
	        z++;
	    }
	    
	    for(int i = n-1; i >= z; i--){
	        tempSum = a.get(i) + remaining;
	        if(i == n-1){
	            tempSum++;
	        }
	        
	        if(tempSum >9){
	            reverse.add(tempSum%10);
	            remaining=1;
	        } else{
	            reverse.add(tempSum);
	            remaining=0;
	        }
	    }
	    if(remaining != 0) reverse.add(1);
	    
	    for(int i = reverse.size()-1; i >= 0; i--){
	        res.add(reverse.get(i));
	    }
	    return res;
	}
}
