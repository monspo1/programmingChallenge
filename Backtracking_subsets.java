import java.util.*;
import java.lang.*;
import java.io.*;  

class TestClass {          

    public static void displayList(ArrayList<ArrayList<Integer>> a){               
        for(int i = 0; i < a.size(); i++){             
            for(int j = 0; j < a.get(i).size(); j++){                 
                System.out.print(a.get(i).get(j) + " ");             
            }             
            System.out.println();         
        }     
    }      
    
    public static ArrayList<ArrayList<Integer>> subsets(int[] S){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
        if(S == null || S.length == 0) return res;
        
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(S);
        subsetsHelper(S, res, cur, 0);
        
        // To remove duplicates
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(res);
        res.clear();
        res.addAll(set);
        
        return res;
    }

    
    public static void subsetsHelper(int[] S, ArrayList<ArrayList<Integer>> res, 
                                    ArrayList<Integer> cur, int iStart){
        if(iStart == S.length){
            //res.add(cur);
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        
        cur.add(S[iStart]);
        subsetsHelper(S, res, cur, iStart+1);
        
        cur.remove(cur.size()-1);
        subsetsHelper(S, res, cur, iStart+1);
    }
    
    public static void main(String args[] ) throws Exception {         
        Scanner sc = new Scanner(System.in);         
        int t = sc.nextInt();                  
        
        int[] arr = new int[t];
        for(int i = 0; i < t; i++){
            arr[i] = sc.nextInt();
        }
        
        displayList(subsets(arr)); 
        
        /* Test cases
        // case #01
        // Input: 4 1 2 3 3 
        
        // case #02
        // Input: 5 4 2 3 3 1
        //*/
    }
}