
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static boolean checkSortCol(char[][] arr){
        int n = arr.length;

        for(int j = 0; j <= n-1; j++){  // NOT (j < n-1 ) <-- this will not pass testcase #10
            for(int i = 0; i < n-1; i++){
                if(arr[i][j] > arr[i+1][j]) return false;
            }
        }
        return true;   
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(sc.hasNext()){

            int n = sc.nextInt();
            char[][] arr = new char[n][n];

            for(int i = 0; i < n; i++){
                String input = sc.next();
                arr[i] = input.toCharArray(); // We don't need another for loop for(j= 0..n){ arr[i][j]=input.charAt(j) }
                Arrays.sort(arr[i]);
            }

            if(checkSortCol(arr)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    /* 
    Input

    1 5
    ebacdz
    fghijz
    olmknz
    trpqsz
    xywuvz
    
    1 3 
    ppp
    ypp
    wyw
   
    1 2
    ad 
    bc
    
    //*/
}

/*
* Problem Statement

  Given a squared sized grid G of size N in which each cell has a lowercase letter. 
  Denote the character in the ith row and in the jth column as G[i][j].

  You can perform one operation as many times as you like: 
  Swap two column adjacent characters in the same row G[i][j] and G[i][j+1] for all valid i,j.

  Is it possible to rearrange the grid such that the following condition is true?

  G[i][1]≤G[i][2]≤⋯≤G[i][N] for 1≤i≤N and 
  G[1][j]≤G[2][j]≤⋯≤G[N][j] for 1≤j≤N
  In other words, is it possible to rearrange the grid such that every row and every column is lexicographically sorted?

  Note: c1≤c2, if letter c1 is equal to c2 or is before c2 in the alphabet.


* Input Format
  The first line begins with T, the number of testcases. In each testcase you will be given N. 
  The following N lines contain N lowercase english alphabet each, describing the grid.


* Output Format
  Print T lines. On the ith line print YES if it is possible to rearrange the grid in the ith testcase or NO otherwise.

* Constraints 
  1≤T≤100 
  1≤N≤100 
  Gij will be a lower case letter


* Sample Output
  YES

* Explanation
  The grid in the first and only testcase can be reordered to

    abcde
    fghij
    klmno
    pqrst
    uvwxy

  This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all lexicographically sorted.

//*/