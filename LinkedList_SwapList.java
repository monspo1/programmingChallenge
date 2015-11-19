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
	
	public static ListNode swapList(ListNode a) {
		if(a == null || a.next == null) return a;
		
		ListNode head = new ListNode(0);
		head.next = null;
		
		ListNode cur = null;
		ListNode sec = null;
		ListNode prev = null;
		
		while(a != null && a.next != null){
			cur = a;
			sec = a.next;
			System.out.println("cur: " + cur.val + " | sec: " + sec.val);
			if(head.next == null) head.next = sec;
			
			cur.next = (sec.next == null) ? null : sec.next;
			sec.next = cur;
			
			if(prev != null) prev.next = sec;
			prev = cur;
			
			a = cur.next;
		}
		return head.next;
	}
    /* TESTCASES
    case 1:
    2 1 3
    - Output: 3 -> 1 -> NULL
    
    case 2:
    6 1 2 3 4 5 7
    2 -> 1 -> 4 -> 3 -> 7 -> 5 -> NULL
    
    case 3:
    5 1 2 3 4 5
    2 -> 1 -> 4 -> 3 -> 5 -> NULL
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
        
		printList(swapList(head));
	}
}