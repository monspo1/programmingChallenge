import java.util.*;
import java.lang.*;
import java.io.*;  

class TestClass {          

    // 요 문제는 (앞의 combination sum 1 문제와 달리) 같은 원소가 중복적으로 합해지는 것을 허용하지 않음. 
    
    public static void displayList(ArrayList<ArrayList<Integer>> a){               
        for(int i = 0; i < a.size(); i++){             
            for(int j = 0; j < a.get(i).size(); j++){                 
                System.out.print(a.get(i).get(j) + " ");             
            }             
            System.out.println();         
        }     
    }      
    
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] S, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) return res;
        
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(S);
        
        combSum2Helper(S, target, res, cur, 0);
        
        //*
        //remove duplicate lists
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(res);
        res.clear();
        res.addAll(set);
        //*/
        return res;
    }
    
    public static void combSum2Helper(int[] S, int target, ArrayList<ArrayList<Integer>> res, 
                                      ArrayList<Integer> cur, int step){
        if(target == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>(cur);
            res.add(tmp);
            return;
        }
        
        for(int i = step; i < S.length; i++){
            if(target < S[i]) return;
            cur.add(S[i]);
            combSum2Helper(S, target-S[i], res, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
    
    public static void main(String args[] ) throws Exception {         
        Scanner sc = new Scanner(System.in);         
        int t = sc.nextInt();                  
        
        
        int[] arr = new int[t];
        for(int i = 0; i < t; i++){
            arr[i] = sc.nextInt();
        }
        
        t = sc.nextInt();
        displayList(combinationSum(arr, t)); 
        
    }
    // Testcase:
    // Input: 6 3 2 2 7 4 5 7
}