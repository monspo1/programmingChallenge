// For ideone testing (
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone{
    
	public static class Node {
	    int data;
	    Node left;
	    Node right; 
	    
	    public Node(int d){
	        this.data = d;
	    }
	}
	
	public static void preorderTraversal(Node node){
	    if(node == null) return;
	    
	    printNode(node);
	    if(node.left != null) preorderTraversal(node.left);
	    if(node.right != null) preorderTraversal(node.right);
	}
	
    public static void inorderTraversal(Node node){
	    if(node == null) return;
	    
	    if(node.left != null) inorderTraversal(node.left);
        printNode(node);
	    if(node.right != null) inorderTraversal(node.right);
	}
	
    public static void postorderTraversal(Node node){
	    if(node == null) return;
	    
	    if(node.left != null) postorderTraversal(node.left);
	    if(node.right != null) postorderTraversal(node.right);
	    printNode(node);
	}
	
	public static void printNode(Node node){
	    System.out.print(node.data);
	}
	
	public static void main (String[] args) throws java.lang.Exception{
        /*
             3
           /   \
          5     2
         / \    /
        1   4  6     //*/
        
	    Node node1 = new Node(1);
	    Node node2 = new Node(2);
	    Node node3 = new Node(3);
	    Node node4 = new Node(4);
	    Node node5 = new Node(5);
	    Node node6 = new Node(6);
	    
	    node3.left = node5;
	    node3.right = node2;
	    node5.left = node1;
	    node5.right = node4;
	    node2.left = node6;
	    
	    preorderTraversal(node3);  // 3 5 1 4 2 6
        inorderTraversal(node3);   // 1 5 4 3 6 2
        postorderTraversal(node3); // 1 4 5 6 2 3
	}
}

/* For HackerRank Submissions
class Node {
    int data;
    Node left;
    Node right;
}

void printNode(Node root){
    System.out.print(root.data + " ");    
}


void Inorder(Node root) {
    if(root == null) return;
    if(root.left != null) Inorder(root.left);
    printNode(root);
    if(root.right != null) Inorder(root.right);
}

void Preorder(Node root) {
    if(root == null) return;
    printNode(root);
    if(root.left != null) Preorder(root.left);
    if(root.right != null) Preorder(root.right);
}

void Postorder(Node root) {
    if(root == null) return;
    if(root.left != null) Postorder(root.left);
    if(root.right != null) Postorder(root.right);
    printNode(root);
}
//*/
