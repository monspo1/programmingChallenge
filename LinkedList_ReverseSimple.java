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
    
    // Recursive solution
    public static ListNode reverseListRecursive(ListNode head) {     
	    if(head==null || head.next == null) return head;       
	
	    ListNode second = head.next;     //get second node         
	    head.next = null;                //set first's next to be null          
	
	    ListNode rest = reverseListRecursive(second);     
	    second.next = head;       
		printList(second);
	    return rest; 
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
        
		printList(reverseList(head));
	}
}