/* Rotate2 (incomplete yet!!)
NxN array에서 array 중간을 중심으로 시계 방향으로 element 하나씩 하나씩 rotate해라. 

* Input
  첫 줄은 N (배열의 row / column 수)
  그 다음 각 줄에 N개의 element가 나오고 N줄 반복됨.

* Example: 
  #Testcase #01
  - Input
    2
    12
    34

  - Output
    31
    42
   
  #Testcase #02
  - Input
    3
    1 2 3
    4 5 6
    7 8 9
    
  - Output
    4 1 2
    7 5 3
    8 9 6
    
  #Testcase #03
  - Input
    4
    1 2 3 4
    6 7 8 9
    10 11 12 13
    14 15 16 17

  - Output          (이해 편하게 하려고 스페이스 넣어보면)
    6  1   2  3
    10 11  7  4
    14 12  6  9
    15 16 17 13
    
  #Testcase #04
  - Input
    5
    1 2 3 4 5
    6 7 8 9 10
    11 12 13 14 15
    16 17 18 19 20
    21 22 23 24 25
    
//*/

/* LINKS
    - Search query: interview difficulty google amazon twitter
    https://www.quora.com/search?q=interview+difficulty+google+amazon+twitter+
    
    - Which companies have the highest standards for hiring engineers?
    https://www.quora.com/Which-companies-have-the-highest-standards-for-hiring-engineers
    
    - Which companies ask Google-like algorithm and coding interview questions during software engineer interviews?
    https://www.quora.com/Which-companies-ask-Google-like-algorithm-and-coding-interview-questions-during-software-engineer-interviews
//*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    // Maybe incorrect
	public static void Rotate2(int[][] arr){
        int n = arr.length;
        int until = n / 2;
        int tmp_tl = 0, tmp_tr = 0, tmp_br = 0, tmp_bl = 0;
        
        int s = 0;
        //while(s < until){
            
            tmp_tr = arr[s][n-1-s];
            for(int f = 0; f < n-1; f++){
                arr[s][n-1-f] = arr[s][n-1-(f+1)];
            }
            
            tmp_br = arr[n-1-s][n-1-s];
            for(int f = 0; f < n-1; f++){
            	arr[n-1-f][n-1-s] = arr[n-1-(f+1)][n-1-s];
            }
            arr[s+1][n-1-s] = tmp_tr;
            
            tmp_bl = arr[n-1-s][s];
            for(int f = 0; f < n-1; f++){
            	arr[n-1-s][f-s] = arr[n-1-s][(f+1)-s];
            }
            arr[n-1-s][n-2-s] = tmp_br;
            
            tmp_tl = arr[s][s];
            for(int f = 0; f < n-1; f++){
            	arr[f-s][s] = arr[f+1][s];
            }
            arr[n-1-(s+1)][s] = tmp_bl;
            
            //s++;
        //}
        
        for(int i= 0; i < n; i++){
        	for(int j= 0; j < n; j++){
        		System.out.print(arr[i][j] + " ");    
        	}
        	System.out.println();
        }
        
    }
                
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        while(sc.hasNext()) sc.nextInt();   // in case of unnecessary
        

        Rotate2(arr);

    }

}