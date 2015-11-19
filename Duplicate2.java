/* Duplicate 2 (내 Amazon online assessment 문제)... system.in parsing하는 것에서 폭망.
// 아래는 완성 코드. 

* Problem statement
  정확하게 기억나지 않지만, 입력 받은 n x n인 2차원 array와 정수 k가 있다고 하자.
  여기서 row와 column index가 k까지(row <= k; col <= k) 일때 중복되는 원소 있으면 중복 있다고 출력.
  근데 중요한 거는 첫 라인은 n (= row수 = column 수).
  그 다음부터 n라인까지 각 row의 elements들을 나타냄. (각 line은 n elements를 가짐)
  여기서 element수가 n이 아니면 "NO" 출력.
  
  그래서 포인트는 k index까지 중복된 수가 있는지 체크하고 있으면  "YES" 출력.
  
* Input
- Testcase #00
    3
    1 2 3
    4 5 6
    7 8 9 
    2

- Testcase #02
    4
    1 2 3 4
    5 6 7 8
    9 5 10 11
    12 13 14 15
    2

- Testcase #03
    4
    1 2 3 
    4 5 6 
    9 11 12 
    13 14 15
    3
//*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    // 요 코드 자체는 쉬움. 근데 문제는 입력 받는 input 처리하는게 애매 & 복잡....
    static boolean duplicate2(int[][] arr, int k){
        
        HashSet<Integer> hset = new HashSet<>();
        
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(!hset.contains(arr[i][j]))
                    hset.add(arr[i][j]);
                else
                    return true;
            }
        }
        return false;
    }
    

    public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n = Integer.parseInt(br.readLine());  // String으로 받은 거 parseInt()해줌.
		int[][] arr = new int[n][n];
		boolean correctInput = true;
        
        for(int i = 0; i < n; i++){
			line = br.readLine();
            line = line.trim();
            String[] strArr = line.split(" ");
            
			int h = 0;
			for(int j = 0; j < strArr.length; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
			}
            if(strArr.length != n) correctInput = false;
		}
        
        /* 밑의 코드는 (위와 같은 목적인데) char array 써서 한 문자씩 받아들여 각 문자를 int[][] 배열에 저장. 
        // 근데 문제는 한 문자씩 하므로 10 이상의 수는 엉뚱하게 저장됨.. 즉, 11이 1,1 이렇게 따로 받아들임.
		for(int i = 0; i < n; i++){
			line = br.readLine();
            char[] chArr = new char[n]; // correctInput 확인하기 위함
            
			int h = 0;
			for(int j = 0; j < line.length(); j++){
				if(line.charAt(j) != ' '){  // 주의: 한 문자씩 하므로 10 이상에서 에러 발생.(문자는 1자리수만)
                    chArr[h++] = line.charAt(j);
				} 
			}
            if(chArr.length != n) correctInput = false;
            
            for(int j = 0; j < chArr.length; j++){
            	arr[i][j] = chArr[j]-'0';	// -'0' 해줘야 숫자(문자)를 int로 (변환) 계산.	
            }
		}
        //*/
		
        String lastStr = null;
		while((line = br.readLine()) != null){
            line = line.trim();
            lastStr = line;     // line은 while문 끝나면 null이 되기에 lastStr에 이전 line값 저장.
			//System.out.println("> " + line);
		}
        int k = Integer.parseInt(lastStr);
        System.out.println("k: " + k);
        
        if(correctInput){
            if(duplicate2(arr, k)){
                System.out.println("YES");    
            } else{
                System.out.println("NO");   
            }
        } else{
            //System.out.println("WRONG INPUT");
            System.out.println("NO");    
        }
	}
}