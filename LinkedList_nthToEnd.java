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
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		
		// 원래는 아래 for문과 같은 코드였는데, n이 listNode 사이즈보다 클 경우 처리 안해서 추가했음 (if fast == null) then break
        // for(int i = 0; i < n; i++) fast = fast.next;  //<== original code
        int i = 0; 
        while(i < n && fast != null){ 
            fast = fast.next; 
            i++;             
        }         

        if(fast == null){       // follow the description of the question 
            head = head.next;   // or ask an interviewer how to manage this case, (fast == null)
            return head;              
        }
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
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
		printList(head);
		
		int b = sc.nextInt();
		printList(removeNthFromEnd(head, b));
		
	}
}