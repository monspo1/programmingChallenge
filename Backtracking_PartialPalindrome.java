import java.util.*;
import java.lang.*;
import java.io.*;  

class TestClass {          

    public static void displayList(ArrayList<ArrayList<String>> a){               
        for(int i = 0; i < a.size(); i++){             
            for(int j = 0; j < a.get(i).size(); j++){                 
                System.out.print(a.get(i).get(j) + " | ");
            }             
            System.out.println();         
        }     
    }      
    
    public static ArrayList<ArrayList<String>> palinPart(String S){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(S == null || S.length() == 0) return res;

        ArrayList<String> cur = new ArrayList<String>(); 
        palinPartHelper(S, res, cur, 0);  
        return res;
    }
    
    public static void palinPartHelper(String s, ArrayList<ArrayList<String>> res, 
                                    ArrayList<String> cur, int start){
        
        if(start == s.length()){
            ArrayList<String> tmp = new ArrayList<String>(cur);
            res.add(tmp);
            return;
        }    
        
        for(int i = start; i < s.length(); i++){
            String str = s.substring(start, i+1);
            System.out.println("Step: " + start + " | str: " + str);
            if(isPalindrome(str)){
                cur.add(str);
                palinPartHelper(s, res, cur, start+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    public static boolean isPalindrome(String str){
        int left = 0, right = str.length()-1;
        
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String args[] ) throws Exception {         
        Scanner sc = new Scanner(System.in);         
        String s = sc.next();
        
        displayList(palinPart(s));
    }
    // Testcase:
    // Input: aab
    
    // http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
}