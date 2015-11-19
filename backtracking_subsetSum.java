import java.util.*;
import java.lang.*;
import java.io.*;

class TestClass {    
    
    public static void findSubsetSum(ArrayList<Integer> arr, int target){
        if(arr == null) return;
        ArrayList<Integer> table = new ArrayList<Integer>();
        for(int i = 0; i < arr.size(); i++) table.add(0);
        
        subsetSum(arr, 0, target, 0, table);
    }
    
    public static void subsetSum(ArrayList<Integer> a, int curSum, int sum, int index, 
        ArrayList<Integer> table) {
        
        if(curSum == sum){
            System.out.print("\nSum found: ");
            for(int i = 0; i < table.size(); i++){
                if(table.get(i) == 1){
                    System.out.print(a.get(i) + " ");   
                }
            }
        } else if(index == a.size()){
            return;
            
        } else{
            // include the current element            
            table.set(index, 1);
            curSum += a.get(index);  
            subsetSum(a, curSum, sum, index+1, table);    
            
            // Do not include the current element
            table.set(index, 0);
            curSum -= a.get(index); 
            subsetSum(a, curSum, sum, index+1, table);    
        }
    }
    
    public static void displayList(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < t; i++){
            arr.add(sc.nextInt());
        }
        
        t = sc.nextInt();
        System.out.println("arr.size: " + arr.size() + " | target sum: " + t);
        
        findSubsetSum(arr, t);
    }
}