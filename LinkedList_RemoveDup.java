import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	static class ListNode {
	   public int val;
	   public ListNode next;
	   ListNode(int x) { val = x; next = null; }
 	}
 	
    public static ListNode deleteDuplicates(ListNode a) {
        if(a == null) return null; 
        if(a.next == null) return a; 
        ListNode cur = a; 
        while(cur != null && cur.next != null){             
            if(cur.val == cur.next.val){                 
                cur.next = cur.next.next;             
            } else{                 
                cur = cur.next;             
            }         
        }         
        return a;     
    }

	public static ListNode deleteDuplicates2(ListNode a) {
		ListNode cur = a;
		ListNode head = cur;
		
		while(cur.next != null && cur.next.next != null){
			if(cur.next.val == cur.next.next.val){
				int curVal = cur.next.val;
				while(cur.next != null && cur.next.val == curVal){
					cur.next = cur.next.next;
				}
			} else{
				cur = cur.next;
			}
		}
		return head;
	}
	
	public static void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print("NULL");
	}
	
    /* Sample Input: 
    *Input 1:
    7 1 2 3 3 4 4 5
    
    *Input 2:
    16 1 1 1 1 2 2 2 3 3 4 5 6 6 6 6 7 
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
		
		
		// Choose either one (deleteDuplicates or deleteDuplicates2)
        /*
		ListNode res = deleteDuplicates(head);
		System.out.println("\nRes1: ");
		printList(res);
		//*/
		//*
        ListNode res = deleteDuplicates2(head);
		System.out.println("\nRes2: ");
		printList(res);
        //*/
	}
}