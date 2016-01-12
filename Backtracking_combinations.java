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
    
    public static ArrayList<ArrayList<Integer>> combinations(int n, int k){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || k > n) return res;

        ArrayList<Integer> cur = new ArrayList<Integer>(); 
        combHelper(n, k, res, cur, 1);  // num starts from 1
        return res;
    }

    public static void combHelper(int n, int k, ArrayList<ArrayList<Integer>> res,
                                               ArrayList<Integer> cur, int cur){
        if(item.size() == k){
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i = cur; i <= n; i++){
            cur.add(i); 
            combHelper(n, k, res, cur, cur+1); 
            cur.remove(cur.size()-1);
        }
    }


    public static void main(String args[] ) throws Exception {         
        Scanner sc = new Scanner(System.in);         
        int n = sc.nextInt();                  
        int k = sc.nextInt(); 
        
        combinations(n, k); 
        
    }
    // Testcase:
    // Input: 4 2
}