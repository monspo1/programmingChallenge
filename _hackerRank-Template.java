import java.io.*;
import java.util.*;

class Solution
{
    public static void displayList(ArrayList<Integer> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		System.out.print(a.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String [] args) throws Exception
    {
        // 1. Scanner 이용 (밑에 BufferedReader 사용 나옴)
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(sc.hasNext()){

            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            if(SomeMethod(arr)) System.out.println("YES");
        }

        /* Another template 
        int sum, a, b;
        for(int i = 0; i < t; i++){
            a = in.nextInt();
            b = in.nextInt();
            sum = sumTheseNum(a,b);
            System.out.println(sum);
        }
        //*/

        /* BigInteger input
        while(sc.hasNext()){
            // int a = sc.nextInt(); 한 후 BigInteger bi = BigInteger.valueOf(a) 이렇게 할 필요 없음
            BigInteger bi = sc.nextBigInteger(); 
            System.out.println(bia.add(bi));
        }
        //*/

        /* skip unnecessary characters
        /* // From the inut example below, you want to only read numbers, not escape characters
                3
              /   \
             5     2
            / \    /
           1   4  6

        String line;

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while ((line = r.readLine()) != null) {
            r.readLine();  // skip lines with / or \
            line = line.replaceAll(" ", "");    // remove all spaces
            System.out.print(line); // print 352146 
        }
        //*/
        
        // 2. BufferedReader 이용
        /* input 예제 (첫 줄은 array의 row / column이 될 n. 즉, 밑 3줄이 3x3 array가 됨. 그리고 1,34,12 받음)
            3
            4 5 6
            1 2 3 
            7 8 9 
            1
            34
            12
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n = Integer.parseInt(br.readLine());  // String으로 받은 거 parseInt()해줌.
		int[][] arr = new int[n][n];
		
        // 2-1: space 기준으로 나누어 뭉텡이로 저장됨.. (문자 1개씩 받아들이는 게 아님)
        for(int i = 0; i < n; i++){
			line = br.readLine();
            String[] strArr = line.split(" "); // " " space 기준으로 각각 저장 (길이가 1인 문자일 필요 없음)
            
			int h = 0;
			for(int j = 0; j < strArr.length; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
			}
		}
        
        /* 2-2: 각 문자 1개씩을 받아들 때 (10 이상의 수는 1,0 처럼 하나의 문자씩 따로 받아들임. 
		for(int i = 0; i < n; i++){
			line = br.readLine();
			int h = 0;
			for(int j = 0; j < line.length(); j++){
				if(line.charAt(j) != ' '){
					arr[i][h++] = line.charAt(j)-'0';	// -'0' 해줘야 숫자를 int로 (변환) 계산.
				} 
			}
		}
		//*/
        
        String lastStr = null;
		while((line = br.readLine()) != null){
            lastStr = line;     // line은 while문 끝나면 null이 되기에 lastStr에 이전 line값 저장.
			System.out.println("> " + line);
		}
        
    }
}

