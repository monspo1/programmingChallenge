/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	public  static int romanToInt(String a) {
		a = a.toUpperCase();
		int res = 0;
		int i = 0;
		
		while(i < a.length()){
			char ch = a.charAt(i);
			int num = letterToNum(ch);
			
			if(i+1 == a.length()){
				res += num;
			} else{
				int next = letterToNum(a.charAt(i+1));
				if(next > num){
					res += (next - num);
					i++;
				} else{
					res += num;
				}
			}
			i++;
            
		}
		
		return res;
	}
	
	public static int letterToNum(char ch){
		switch (ch){
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = line.trim();
        System.out.println(line + " ==> " + romanToInt(line));
        //*/
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        line = line.trim();
        System.out.println(line + " ==> " + romanToInt(line));
	}
    
    /* 
    // 원래 코드. 요 코드는 while문 안에 i++를 먼저 넣고 nextLetter와의 비교를 해줬음. 근데 버릇처럼 단순하게 i++을 마지막에 넣으면 결과 달라짐. 
    // 주의해서 봐야 함.
    public  static int romanToInt(String a) {
		a = a.toUpperCase();
		int res = 0;
		int i = 0;
		
		while(i < a.length()){
			char ch = a.charAt(i);
			int num = letterToNum(ch);
			i++;     //XVIXX ==> 34 (정답)
            
			if(i == a.length()){
				res += num;
			} else{
				int next = letterToNum(a.charAt(i));
				if(next > num){
					res += (next - num);
					i++;
				} else{
					res += num;
				}
			}
            //next = letterToNum(a.charAt(i))에서 i를 잘 확인하지 않고 단순히 버릇처럼 여기에 i++ 넣으면 XVIXX ==> 36 나옴 (오답). 
		}
		return res;
	}
    //*/
}

