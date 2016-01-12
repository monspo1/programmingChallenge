import java.util.*;
import java.lang.*;
import java.io.*;  

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }    
}

    
class TestClass { 
    
        
    // PrintList
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }
    
    public static ListNode mergeKsorted(ArrayList<ListNode> lists){
        if(lists == null || lists.size() == 0) return null;
        return mergeKsortedHelper(lists, 0, lists.size()-1);
    }

    public static ListNode mergeKsortedHelper(List<ListNode> lists, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            return merge( mergeKsortedHelper(lists, left, mid),
                          mergeKsortedHelper(lists, mid+1, right)); 
        }
        return lists.get(left);
    }
    
    public static ListNode merge(ListNode a, ListNode b){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while(a != null && b != null){
            if(a.val < b.val){
                cur.next = a;
                cur = cur.next;
                a = a.next;
            } else{
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }
        }
        
        if(a != null) cur.next = a;
        else cur.next = b;
        
        return head.next;
    }

     
    public static void main (String[] args) throws java.lang.Exception     { 
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        
        for(int j = 0; j < t; j++){
            
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
            arr.add(head);
            printList(head);
        }
        
        printList(mergeKsorted(arr));
    }
    /*
    - Codetable link
    https://code.hackerearth.com/3a0a8el?key=1acb83f6ab2ca734f53bf1691a1b9ce5
    
    - Test cases
    4 3 1 5 10 4 3 7 11 18 2 0 20 5 1 17 21 37 69
    
    //*/
}
