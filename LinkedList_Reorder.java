import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class ListNode{
	    int val;
	    ListNode next;
	    ListNode(int val){
	        this.val = val;
	        next = null;
	    }
	}

	// PrintList
	public static void printList(ListNode head){
	        while(head != null){
	            System.out.print(head.val + " -> ");
	            head = head.next;
	        }
	        System.out.print("NULL\n");
	}
	
	public static ListNode reverseList(ListNode a) {
		ListNode newHead = null;
		ListNode cur = null;
		
		while(a != null){
			
			if(newHead == null){
				newHead = new ListNode(a.val);;
			} else{
				cur = new ListNode(a.val);
				cur.next = newHead;
				newHead = cur;
			}
			a = a.next;
		}
		
		return newHead;
	}
    
    
    public static ListNode reorderListMine(ListNode head) {     
        // My own implmentation. didn't use 'head'. 
        if(head == null || head.next == null) return head;
	    
        ListNode rhead = null;
    	ListNode slow = head;
    	
    	int i = 0;
    	while(slow != null){
    		slow = slow.next;
    		i++;
    	}
    	
    	ListNode rev = head;
    	rev = reverseList(rev);
    	
    	ListNode rtail = null;
    	ListNode cur = null;
    	
    	if(i % 2 == 0) i = i/2;
    	else i = i/2 + 1;
    	
    	while(i > 0){
    		cur = new ListNode(head.val);
    		
    		if(rtail == null){
    			rtail = cur;
    			rhead = rtail;
    		} else{
    			rtail.next = cur;
    			rtail = cur;
    		}
    		head = head.next;
    		
    		cur = new ListNode(rev.val);
    		if(rtail.val != cur.val){
	    		rev = rev.next;
	    		rtail.next = cur;
	    		rtail = cur;
    		}
    		i--;
    	}
    	//printList(rhead);
    
	    return rhead;
	}

    //http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
	public static void reorderList(ListNode head) {    // Didn't return anything, but use 'head'.
	    if(head !=null && head.next != null) {
	    	
	    	ListNode slow = head;
	    	ListNode fast = head;
	    	
	    	while(fast != null && fast.next != null && fast.next.next != null){
	    		//System.out.println("pre "+slow.val + " " + fast.val);
				slow = slow.next;
				fast = fast.next.next;
				//System.out.println("after " + slow.val + " " + fast.val);
			}
 
			ListNode rev = slow.next;
	    	slow.next = null; 
	    	
	    	rev = reverseList(rev);
	    	printList(rev);
	    	
	    	ListNode cur1 = head;
	    	ListNode cur2 = rev;
	    	
	    	while(cur2 != null){
	    		ListNode tmp1 = cur1.next;
	    		ListNode tmp2 = cur2.next;
	    		
	    		cur1.next = cur2;
	    		cur2.next = tmp1;
	    		
	    		cur1 = tmp1;
	    		cur2 = tmp2;
	    	}
	    	printList(head);
	    } 
	}
    
        /* Testcases
    - case 1
    Input: 6 1 2 3 4 5 6
    Output: 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> NULL
    
    - case 2
    Input: 5 1 2 3 4 5
    Output: 1 -> 5 -> 2 -> 4 -> 3 -> NULL
    
    - case 3
    Input: 1 3
    Output: 3 -> NULL
    
    - case 4
    Input: 0 1
    Output: NULL
    
    - case 5
    Input: 85   90 94 25 51 45    29 55 63 48 27   72 10 36 68 16    20 31 7 95 70   89 23 22 9 74    71 35 5 80 11 
        49 92 69 6 37    84 78 28 43 64   96 57 83 13 73    97 75 59 53 52   19 18 98 12 81   24 15 60 79 34 
        1 54 93 65 44    4 87 14 67 26  30 77 58 85 33    21 46 82 76 88   66 101 61 47 8
    Output: 90 -> 8 -> 94 -> 47 -> 25 -> 61 -> 51 -> 101 -> 45 -> 66 -> 29 -> 88 -> 55 -> 76 -> 63 
        -> 82 -> 48 -> 46 -> 27 -> 21 -> 72 -> 33 -> 10 -> 85 -> 36 -> 58 -> 68 -> 77 -> 16 -> 30 
        -> 20 -> 26 -> 31 -> 67 -> 7 -> 14 -> 95 -> 87 -> 70 -> 4 -> 89 -> 44 -> 23 -> 65 -> 22 
        -> 93 -> 9 -> 54 -> 74 -> 1 -> 71 -> 34 -> 35 -> 79 -> 5 -> 60 -> 80 -> 15 -> 11 -> 24 
        -> 49 -> 81 -> 92 -> 12 -> 69 -> 98 -> 6 -> 18 -> 37 -> 19 -> 84 -> 52 -> 78 -> 53 -> 28 
        -> 59 -> 43 -> 75 -> 64 -> 97 -> 96 -> 73 -> 57 -> 13 -> 83 
    
    //*/
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();         
		
		ListNode head = new ListNode(0);         
		ListNode prev = null;                  
		
		for(int i = 0; i < n; i++){             
			int v = sc.nextInt();             
			ListNode cur = new ListNode(v);             
			if(i == 0) head = cur;             
			if(i > 0) prev.next = cur;             
			prev = cur;          
		}                  
		printList(head);
		//reorderList(head);
		printList(reorderListMine(head));
	}
}