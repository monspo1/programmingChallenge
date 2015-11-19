import java.util.*;
import java.lang.*;
import java.io.*;

class TestClass {
    
    public static void displayList(final List<String> a){
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
        System.out.println();
    }
    
    public static int isValidSudoku(final List<String> a) {

        if (a == null) return 0;
        HashSet<Character> hsetForRow, hsetForCol, boxset;
        int n = a.size();
        
        for(int i = 0; i < n; i++){
            hsetForRow = new HashSet<Character>();
            hsetForCol = new HashSet<Character>();
            
            // Check row & Col
            for(int j = 0; j < n; j++){
                if(!hsetForRow.add(a.get(i).charAt(j)) && a.get(i).charAt(j) != '.') return 0;
                if(!hsetForCol.add(a.get(j).charAt(i)) && a.get(j).charAt(i) != '.') return 0;
            }
        }
        
        // Checking 9 boxes
        for(int r = 0; r < n; r += 3){
            for(int c = 0; c < n; c += 3){
                
                boxset = new HashSet<Character>();
                
                for(int i = r; i < r+3; i++){
                    for(int j = c; j < c+3; j++){
                        if(!boxset.add(a.get(i).charAt(j)) && a.get(i).charAt(j) != '.') return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        List<String> arr = new ArrayList<String>();

        while(sc.hasNext()){
            for(int i = 0; i < t; i++){
                arr.add(sc.next());
            }
        }
        //System.out.println("arr.size: " + arr.size() );
        displayList(arr);     

        System.out.println("isValid?? " + isValidSudoku(arr));
        
    }
}

/* Testcases
- testcase #1:
  Input: 
    9
    53..7....
    6..195...
    .98....6.
    8...6...3
    4..8.3..1
    7...2...6
    .6....28.
    ...419..5
    ....8..79
  Output: 1

- testcase #2:
  Input: 
    9
    53..7....
    6..195...
    .98....6.
    8...6...3
    4..8.3..1
    7...2....
    .6....68.
    ...419..5
    ....8..79
  Output: 0
//*/

