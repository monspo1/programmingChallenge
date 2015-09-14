public class MyClass {
 
    static class PriorityQueueComparator implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
    
    /* Input example
    10
    1
    2
    4
    3
    6
    10
    8
    5
    7
    9
    //*/
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        int i = 0;

        PriorityQueueComparator pqc=new PriorityQueueComparator();

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(t,pqc);

        while(sc.hasNext()){
            arr[i] = sc.nextInt();
            i++;
        }

        System.out.println("pq1: " + pq1); // pq1: [1, 2, 4, 3, 6, 10, 8, 5, 7, 9]
		System.out.println("pq2: " + pq2); // pq2: [10, 9, 8, 5, 7, 2, 6, 1, 4, 3]
		
		System.out.print("Polling pq1: ");
		while(!pq1.isEmpty()){
			System.out.print(pq1.poll() + " "); // Polling pq1: 1 2 3 4 5 6 7 8 9 10 
		}
		
		System.out.print("\nPolling pq2: ");
		while(!pq2.isEmpty()){
			System.out.print(pq2.poll() + " "); // Polling pq2: 10 9 8 7 6 5 4 3 2 1 
		}
    }
}