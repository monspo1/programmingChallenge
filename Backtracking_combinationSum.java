import java.util.*;
import java.lang.*;
import java.io.*;  

class TestClass {          

    // 유의점: 이 문제에서 원소의 중복 계산을 허용해서 target sum이 될 수 있음. (즉, S = [1,2,3,4], 
    // target = 8일 때, S[0] = 2가 4번 계산되어 (8 = 2+2+2+2) 답에 포함될 수 있음. (8=4+4도 포함)

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

        combSumHelper(S, target, res, cur, 0);  // Recursion       
        return res;     
    }
    
    public static void combSumHelper(int[] S, int target,
         ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int step){     

        if(target == 0){ 
            ArrayList<Integer> tmp = new ArrayList<Integer>(cur);
            res.add(tmp); 
            return;         
        }                  

        for(int i = step; i < S.length; i++){ 
            if(target < S[i]) return; 

            cur.add(S[i]);             
            combSumHelper(S, target-S[i], res, cur, i);             
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