/*  AND Product
* Problem Statement
  You will be given two integers A and B. You are required to compute the bitwise AND 
  amongst all natural numbers lying between A and B, both inclusive.

* Input Format
  First line of the input contains T, the number of testcases to follow. 
  Each testcase in a newline contains A and B separated by a single space.

* Constraints
    1≤T≤200 
    0≤A≤B<232

* Output Format
  Output one line per test case with the required bitwise AND.

* Sample Input
    3 
    12 15 
    2 3 
    8 13

* Sample Output
    12 
    2 
    8

* Explanation
  For the first testcase, 
    12 & 13 & 14 & 15 = 12
  
  For second testcase, 
    2 & 3 = 2

  For the third testcase,
    8 & 9 & 10 & 11 & 12 & 13 = 8

//*/




/* Editorial
  In order to solve this problem, we just need to focus on the occurrences of each power 2, 
  which turn out to be cyclic. Now for each 2i (the length of the cycle will be 2i+1 having 2i zeros 
  followed by same number of ones) we just need to compute if 1 remains constant in the given interval, 
  which is done by simple arithmetics. If so, that power of 2 will be present in the answer, otherwise it won't. 
  See sample solution for more details. 

* Another solution
  Write A and B in binary form, and pad leading zeroes to the bits of A so that A and B have the same number of bits.
  Now, let 2i be the most significant bit where A and B differ (set i=−1 if A and B are the same). 
  Since A≤B, it means that 2i is in B but not in A. Obviously, the 2i bit is not present in the answer. 

  Now, all bits larger than 2i is, by definition, either present in both A and B, or absent in both. 
  But if such a bit is present in A and B, then it is sure to appear in all integers between A and B. 
  Thus, any bit larger than 2i present in A and B will be in the answer too. 

  Now, consider a bit 2j smaller than 2i. If 2j is not present in B, then obviously 2j is not in the final answer.
  Otherwise (if 2j is present in B), then let B′=B−2j. Then 2j is not in B′, and A≤B′≤B. 
  This means that 2j is also not present in the final answer. 

  The above arguments describe the final answer completely. If 2i is the most significant bit where A and B differ,
  then: 

  Every bit larger than 2i is present in the final answer if and only if it is present in A (and thus in B)
  Every bit smaller than or equal to 2i is not present in the answer.

  This means that the final answer can be calculated with the following simple algorithm:

    def answer(A, B):

        # 'diff' is the bits where A and B differ
        diff = A ^ B

        # mask out all lower bits than the max bit of 'diff'
        # (the snippet works when diff < 2^64)
        diff |= diff >> 1
        diff |= diff >> 2
        diff |= diff >> 4
        diff |= diff >> 8
        diff |= diff >> 16
        diff |= diff >> 32

        # remove those bits
        return A & ~diff


  Set by shaka_shadows

    #include <cstdio>
    using namespace std;

    int main() {
        int N, i;
        long long A, B, answer;
        scanf("%d", &N);
        while (N--) {
            scanf("%lld%lld", &A, &B);
            answer = 0;
            for (i = 0; i < 32; ++i) {
                long long k = (A + (1ll << i)) >> i;
                long long P = (k << i) - 1;
                if (P >= B) {
                    if ((k & 1) == 0) answer |= 1ll << i;
                }
            }
            printf("%lld\n", answer);
        }
        return 0;
    }
//*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            long min = sc.nextLong();
            long max = sc.nextLong();
            System.out.println(andProduct(min, max));
        }
    }
    // 요 솔루션 틀린 듯
    private static long andProduct(long min, long max) {
        if(min == max) {
            return min;
        }
        long range = max-min;
        long powerOfTwo = 1;
        while(powerOfTwo < range) {
            powerOfTwo *= 2;
        }
        powerOfTwo /= 2;
        return min & ~powerOfTwo;
    }
}
