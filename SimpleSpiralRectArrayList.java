import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static void print2dArr(ArrayList<ArrayList<Integer>> arr){
		if(arr.size() == 0) return;
		int top = 0, left = 0;
		int bottom = arr.size()-1;
		int right = arr.get(0).size()-1;
		
		while(true){
			
			for(int i = left; i <= right; i++){
				System.out.print( arr.get(top).get(i) + " ");
			} top++;
			if(left > right || top > bottom) break;
			
			for(int i = top; i <= bottom; i++){
				System.out.print( arr.get(i).get(right) + " ");
			} right--;
			if(left > right || top > bottom) break;
			
			for(int i = right; i >= left; i--){
				System.out.print( arr.get(bottom).get(i) + " ");
			} bottom--;
			if(left > right || top > bottom) break;
			
			for(int i = bottom; i >= top; i--){
				System.out.print( arr.get(i).get(left) + " ");
			} left++;
			if(left > right || top > bottom) break;
		}
        /* 
        //[참고]: if(left>right || top > bottom) 4번 나와서 요거 다 줄이고 while문을 줄여서 해봤는데 마지막에 추가로 하나 더 출력됨
            while(left <= right && top <= bottom){  // <== 요 줄 추가됨
			   // if문 제외한 거 빼곤 나머지 동일
            }
            - Output 1 2 3 4 5 6 7 8 9 2 4 9 4 (마지막 4가 출력됨)
        //*/
	}
    
	
	public static void displayList(ArrayList<ArrayList<Integer>> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		for(int j = 0; j < a.get(i).size(); j++){
    			System.out.print(a.get(i).get(j));
    		}
    		System.out.println();
    	}
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		while(sc.hasNext()){
			ArrayList<Integer> tma = new ArrayList<>();
			for(int i = 0; i < col; i++){
				tma.add(sc.nextInt());
			}
			arr.add(tma);
		}
		//displayList(arr);
		print2dArr(arr);
	}
}
/*
* Testcase #01
- Input 
3 4
1 2 3 4
2 4 9 5
9 8 7 6

- Output: 1 2 3 4 5 6 7 8 9 2 4 9 

* Testcase #02
- Input
4 3
1 2 3 
4 5 6 
7 8 9 
10 11 12

- Output: 1 2 3 6 9 12 11 10 7 4 5 8 

//*/