import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public Solution() {}
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
		int t = scanner.nextInt();
		while (scanner.hasNext()) {
        //if(t < 1 || t > 10) System.out.println("Not proper testcases");  // <-- Don't include any unnecessary comments. It will NOT make pass some testcases.   

			String s = scanner.next();  
			int len = s.length();
            
			if (len % 2 == 1) System.out.println( -1);
			else{
				int mid = len/2;
				String s1 = s.substring(0, mid);
				String s2 = s.substring(mid, len);
				
				int[] counts = new int[26];
				
				for (int i = 0; i < s1.length(); ++i) {
				    char ch = Character.toLowerCase(s1.charAt(i));
				    ++counts[ch - 'a'];
				}
				
				for (int i = 0; i < s2.length(); ++i) {
				    char ch = Character.toLowerCase(s2.charAt(i));
				    --counts[ch - 'a'];
				}

				int cnt = 0;
				for (int i = 0; i < counts.length; ++i) {
				    cnt += Math.abs(counts[i]);
				}
				System.out.println( cnt/2 );
	        }
		}
    }
}
