import java.util.*;
import java.lang.*;
import java.io.*;  

class TestClass {          
    
    public static void displayList(ArrayList<ArrayList<Integer>> a){               
        for(int i = 0; i < a.size(); i++){             
            System.out.print("[");
            for(int j = 0; j < a.get(i).size(); j++){                 
                System.out.print(a.get(i).get(j) + " ");             
            }
            System.out.print("]");
            System.out.println();         
        }     
    }      
    
    public static ArrayList<ArrayList<Integer>> permut(ArrayList<Integer> a){         
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(a == null || a.size() == 0) return res;                  
    
        ArrayList<Integer> cur = new ArrayList<Integer>();                  
        permuteHelper(a, res, cur, 0); // Recurse
    
        // Remove duplicates
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(res);
        res.clear();
        res.addAll(set);
    
        return res;     
    }          
    
    public static void permuteHelper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> res, 
                                              ArrayList<Integer> cur, int start){
        if(start == a.size()){ // end case         
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);             
            res.add(temp); 
            return; 
        }                  
    
        for(int i = start; i < a.size(); i++){             
            // Include
            cur.add(a.get(i));              
            swap(a, start, i);                          
    
            permuteHelper(a, res, cur, start+1); 
    
            // Do not include (& to the original state)
            cur.remove(cur.size()-1); 
            swap(a, start, i);
        }
    }     
    
    public static void swap(ArrayList<Integer> a, int i, int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(sc.hasNext()){
            for(int i = 0; i < t; i++){
                arr.add(sc.nextInt());
            }
        }
        //System.out.println("arr.size: " + arr.size() );
        displayList(permut(arr));    
    }
}
