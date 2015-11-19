/* package whatever; // don't place package name! */

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
	
    // Can be more optimized
	public static ListNode partition(ListNode head, int x) {
		if(head == null) return head;
		
		ListNode shead = null;
		ListNode lhead = null;
		ListNode smaller = null;
		ListNode larger = null;
		ListNode cur = null;
		
		while(head != null){
			cur = new ListNode(head.val);
			
			if(head.val < x){
				if(smaller == null){
					smaller = cur;
					shead = smaller;
				} else{
					smaller.next = cur;
					smaller = cur;
				}
			} else{
				if(larger == null){
					larger = cur;
					lhead = larger;
				} else{
					larger.next = cur;
					larger = cur;
				}
			}
			head = head.next;
		}
		if(smaller != null) smaller.next = lhead;
		return shead;
	}
	/* Test cases
    * Testcase 1: 
    Input 1: 8 1 2 8 13 7 3 4 5 7
    Output: 1 -> 2 -> 3 -> 4 -> 5 -> 8 -> 13 -> 7 -> NULL
    
    * testcase 2:
    Input: 7 1 4 3 2 5 2 3
    Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5 -> 8 -> NULL
    
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
		int b = sc.nextInt();
		printList(partition(head, b));
		
	}
}