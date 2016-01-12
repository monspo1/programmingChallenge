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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
           @Override
           public int compare(ListNode a, ListNode b){
               return a.val - b.val;
           }
        });
        
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null) pq.add(lists.get(i));
        }
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            cur.next = tmp;
            
            if(tmp.next != null) pq.add(tmp.next);
            
            cur = cur.next;
        }
        
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
    
    /* Codetable link
    https://code.hackerearth.com/9a5da0U?key=3ddc9b9c06fb63d1f6a60d806efef280
    
    -Test cases:
    4 3 1 5 10 4 3 7 11 18 2 0 20 5 1 17 21 37 69
    //*/

}
