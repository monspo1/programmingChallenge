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
    
    public static ArrayList<ArrayList<Integer>> permutations(int[] S){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) return res;

        ArrayList<Integer> cur = new ArrayList<Integer>(); 
        permuteHelper(S, res, cur, 0);  
        return res;
    }

    public static void permuteHelper(int[] S, ArrayList<ArrayList<Integer>> res,
                                              ArrayList<Integer> cur, int step){
        if(step == S.length){
            res.add(new ArrayList<Integer>(cur));
            return ;
        } 

        for(int i = step; i < S.length; i++){
            cur.add(S[i]); 
            swap(S, step, i);
            
            permuteHelper(S, res, cur, step+1); 
            
            cur.remove(cur.size()-1);
            swap(S, step, i);
            
        }
    }
    
    private static void swap(int[] e, int i, int j) {     
       int temp = e[i];     
       e[i] = e[j];     
       e[j] = temp;   
    }



    public static void main(String args[] ) throws Exception {         
        Scanner sc = new Scanner(System.in);         
        int n = sc.nextInt();                  
        int[] arr = new int[n];
        
        for(int i= 0; i < n; i++ ){
            arr[i] = sc.nextInt();    
        }
        
        displayList(permutations(arr));
    }
    // Testcase:
    // Input: 4 2
}