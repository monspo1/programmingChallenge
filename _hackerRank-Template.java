public static void main(String[] args) {
        
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
}