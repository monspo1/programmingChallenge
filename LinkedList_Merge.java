import java.util.*;
import java.lang.*;
import java.io.*;

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
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tail = null;
		ListNode cur = null;
		
		while(l1 != null || l2 != null){
			if(l1 != null && l2 != null){
				if(l1.val < l2.val){
					cur = new ListNode(l1.val);
					l1 = l1.next;
				} else{
					cur = new ListNode(l2.val);
					l2 = l2.next;
				}	
			} else if(l1 != null){
				cur = l1;	
				l1 = l1.next;
			} else if(l2 != null){
				cur = l2;
				l2 = l2.next;
			}
			//System.out.println("cur: "+ cur.val);
			if(tail == null){
				tail = cur;
				head = tail;
			} else{
				tail.next = cur;
				tail = cur;
			}
		}
		//*/
		
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

		n = sc.nextInt();         
		
		ListNode head2 = new ListNode(0);         
		prev = null;                  
		
		for(int i = 0; i < n; i++){             
			int v = sc.nextInt();             
			ListNode cur = new ListNode(v);             
			if(i == 0) head2 = cur;             
			if(i > 0) prev.next = cur;             
			prev = cur;          
		}                  
		
		printList(head2);
		
		printList(mergeTwoLists(head, head2));
	}
}