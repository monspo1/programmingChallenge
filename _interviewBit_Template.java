class Solution
{
 
    public static void displayList(ArrayList<Integer> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		System.out.print(a.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public static void displayList(ArrayList<ArrayList<Integer>> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		for(int j = 0; j < a.get(i).size(); j++){
    			System.out.print(a.get(i).get(j));
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String [] args) throws Exception
    {
        // 1. Scanner
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        
        while(sc.hasNext()){
        	ArrayList<Integer> sub = new ArrayList<>();
        	for(int i = 0; i < t; i++){
            	sub.add(sc.nextInt());
        	}
        	arr.add(sub);
        }
        System.out.println("arr.size: " + arr.size() );
		displayList(arr);
		
        
        // 2. BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] strArr = line.split(" "); 
		int row = Integer.parseInt(strArr[0]);
		int col = Integer.parseInt(strArr[1]);
		
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
        
        System.out.println("arr.size: " + arr.size() );
		displayList(arr);
		//displayList(diagonal(arr));
        
        // Remove Comma
        String str = new String("894, 314, 715, 148, 376, 878, 483, 408, 804, 585, 79, 644, 621, 221, 345");
        String strNew = str.replaceAll(", ", " ");
        System.out.println(strNew);
    }
}
    
