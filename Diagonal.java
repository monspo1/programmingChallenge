import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> arr){
		if(arr == null || arr.size() == 0) return null;
		
		int row = arr.size();
		int col = row;
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		int childCol = 0;
		int childRow = 0;
		int top = 0;
		
		for(int i = 0; i < col; i++){
			top = 0;
			//System.out.print(arr.get(top).get(i) + " ");
			ArrayList<Integer> curLevel = new ArrayList<Integer>();
			curLevel.add(arr.get(top).get(i));
			
			childCol = i-1;
			childRow = i+1;
			
			while(childCol >= 0  && top < arr.size()){
				top = top+1 >= arr.size() ? arr.size()-1 : top+1;
				//System.out.print(arr.get(top).get(childCol) + " ");
				curLevel.add(arr.get(top).get(childCol));
				childCol--;
			}
			res.add(curLevel);
			//System.out.println();
		}
		
		if(row > 1){
			for(int i = 1; i < row; i++){
				
				//System.out.print(arr.get(i).get(col-1) + " ");
				ArrayList<Integer> curLevel = new ArrayList<Integer>();
				curLevel.add(arr.get(i).get(col-1));
				
				childCol = col-2;
				childRow = i+1;
				
				while(childCol >= 0  && childRow < arr.size()){
					//System.out.print(arr.get(childRow).get(childCol) + " ");
					curLevel.add(arr.get(childRow).get(childCol));
					childCol--;
					childRow++;
				}
				//System.out.println();
				res.add(curLevel);
			}	
		}
		return res;
	}
    
	
	public static void displayList(ArrayList<ArrayList<Integer>> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		for(int j = 0; j < a.get(i).size(); j++){
    			System.out.print(a.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] strArr = line.split(" "); 
		int row = Integer.parseInt(strArr[0]);
		int col = Integer.parseInt(strArr[1]);
		//System.out.println("row: " + row + " | col: " + col);
		//*
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		while((line = br.readLine()) != null){
			ArrayList<Integer> tma = new ArrayList<Integer>();
			String[] str = line.split(" "); 
			int i = 0;
			while(i < str.length){
				tma.add(Integer.parseInt(str[i]));
				i++;
			}
			while(i < row){
				tma.add(0);
				i++;
			}
			arr.add(tma);
		}
		//displayList(arr);
		displayList(diagonal(arr));
		//*/
	}
}
/*
3 3
1 2 3
4 5 6
7 8 9

4 4 
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

4 3
1 2 3
4 5 6
7 8 9
10 11 12

3 4
1 2 3 4 
5 6 7 8
9 10 11 12
//*/
