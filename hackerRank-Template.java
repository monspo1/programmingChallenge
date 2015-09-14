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
}