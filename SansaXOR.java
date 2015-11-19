import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int SansaXOR(int[] arr){
        int n = arr.length;
        int res = 0;

        if(n % 2 == 0) return 0;
        else{
            for(int i = 0; i < n; i= i+2){
                res ^= arr[i];
            }    
        }
        return res;   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(sc.hasNext()){

            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.println(SansaXOR(arr));
        }
    }
}