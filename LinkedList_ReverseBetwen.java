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
	
	public static ListNode reverseBetween(ListNode a, int m, int n) {
		if(a == null || m > n) return null;
		
		ListNode head = a;
		ListNode reverse = null;
		ListNode lefttail = null;
		ListNode righttail = null;
		ListNode cur = null;
		
        // traverse m times (a = a.next)
		int i = 0;
		while(a != null && i < m-1){
			lefttail = a;
			a = a.next;
			i++;
		}
		
        // Reverse the list between m and n.
        while(a != null && i < n){
			cur = new ListNode(a.val);
			
			if(reverse == null){
				reverse = cur;
				righttail = reverse;
			} else{
				cur.next = reverse;
				reverse = cur;
			}
			
			a = a.next;
			i++;
		}
        
        // Connect left side (until m) & reverse list
		if(lefttail == null){
			head = reverse;	
		} else{
			lefttail.next = reverse;
		}
        
        // Connect reverse list to the right side (after n to the end of the list)
		righttail.next = (a == null)? null : a;
        
		return head;
	}
    
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
		
		int m = sc.nextInt();
		n = sc.nextInt();
		printList(head);
        
		printList(reverseBetween(head, m, n));
	}
}