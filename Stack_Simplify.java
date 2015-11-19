/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static String simplify(String path){		
        if(path == null || path.length() == 0) return path;
		
        /*
		while(path.length() > 0 && path.charAt(path.length()-1) == '/'){
			path = path.substring(0, path.length()-1);
		}
		//*/
		//* same as above
		int len = path.length();
		while(len > 0 && path.charAt(len-1) == '/'){
			len--;
		}	
		path = path.substring(0, len);
		//*/
		
        String[] strarr = path.split("/");
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<String>();
		
        for(String str : strarr){
            if(str.length() == 0 || str.equals(".")){
                // do nothing
            } else if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else{
                stack.push(str);
            }
        }
        if(stack.isEmpty()){
            res.append('/');
        } else{
            while(!stack.isEmpty()){
                /*
                res.append(stack.pop());
                res.append('/');
                //*/
                res.insert(0, stack.pop());
                res.insert(0, '/');
            }
            
        }
        
		/* 
        return res.reverse().toString(); // <== This doesn't work 
        // Input:  /home/abc/cde///
        // Output: /emoh/cba/edc */
        
        return res.reverse().toString();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();         
        
		System.out.println(simplify(s));
	}
    /* Testcases
    - case 1
    Input: /../
    Output: /
    
    - case 2
    Input: /home//foo/
    Output:
    
    - case 3
    Input: /a/./b/../../c/
    Output:
    
    - case 4
    Input: /home//foo/
    Output:
    
    - case 
    Input: /home/abc/../.../.././a/b/../cde///
    Output: /home/a/cde
    
    //*/
}