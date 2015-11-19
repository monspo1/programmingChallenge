import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static BigInteger fibonacciModified(BigInteger[] arr, int a, int b, int n){
        if(arr == null || n < 1) return BigInteger.valueOf(0);
        if(n == 1) return BigInteger.valueOf(a);

        arr[0] = BigInteger.valueOf(a);
        arr[1] = BigInteger.valueOf(b); 

        int i = 0;

        if(arr.length == 2){
            return BigInteger.valueOf((a * a) + b);

        } else if(arr.length > 2){
            i = 2;    
            while(i < n){
                BigInteger bi2 = arr[i-1];
                BigInteger bi1 = arr[i-2];
                BigInteger bres = bi2.multiply(bi2);
                bres = bres.add(bi1);
                //System.out.print(bres + " ");
                arr[i] = bres;
                i++;
            }
        }
        //return BigInteger.intValue(arr[n-1]);
        return arr[n-1];
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
	
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            BigInteger[] arr = new BigInteger[n];
            //fibonacciModified(arr, a, b, n);
            System.out.println(fibonacciModified(arr, a, b, n));
        }
    }
}