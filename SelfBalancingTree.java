// Self balancing tree (AVL tree) 
// https://www.hackerrank.com/challenges/self-balancing-tree
/*
* Problem Statement
  An AVL tree (Georgy Adelson-Velsky and Landis' tree, named after the inventors) is a self-balancing binary search tree. 
  In an AVL tree, the heights of the two child subtrees of any node differ by at most one; 
  if at any time they differ by more than one, rebalancing is done to restore this property.
  
  We define balance factor for each node as :
  balanceFactor = height(left subtree) - height(right subtree)
  
  The balance factor of any node of an AVL tree is in the integer range [-1,+1]. 
  If after any modification in the tree, the balance factor becomes less than −1 or greater than +1, 
  the subtree rooted at this node is unbalanced, and a rotation is needed.

  You are given a pointer to the root of an AVL tree. 
  You need to insert a value into this tree and perform the necessary rotations to ensure that it remains balanced.

* Input Format
  You are given a function,

    node *insert(node * root,int new_val){

    }
    
  'node' is defined as :

    struct node{
        int val;            //value
        struct node* left;  //left child
        struct node* right; //right child
        int ht;             //height of the node
    } node;
    
  You only need to complete the function.
  Note: All the values in the tree will be distinct.

* Output Format
  Insert the new value into the tree and return a pointer to the root of the tree. Ensure that the tree remains balanced.

* Sample Input

        3
      /  \
     2    4
           \
            5
  The value to be inserted is 6.

* Sample Output

        3
      /  \
     2    5
         / \
        4   6

* Explanation
  After inserting 6 in the tree. the tree becomes:

        3 (Balance Factor = -2)
      /  \
     2    4 (Balance Factor = -2)
           \
            5 (Balance Factor = -1)
             \
              6 (Balance Factor = 0)

  Balnce Factor of nodes 3 and 4 is no longer in the range [-1,1]. 
  We need to perform a rotation to balance the tree. This is the right right case. 
  We perform a single rotation to balance the tree.

  After performing the rotation, the tree becomes :

                              3 (Balance Factor = -1)
                            /   \
      (Balance Factor = 0) 2     5 (Balance Factor = 0)
                                / \
           (Balance Factor = 0)4   6 (Balance Factor = 0)

//*/

   /* Class node is defined as :
    class Node 
       int val;     //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;  //Right child
   */

   static int height(Node node){
       /* NOTE: (From discussion forum)
       // "the height of a "null" node is -1 INSTEAD OF 0, and the height of the leaf node is 0 INSTEAD OF 1. 
       // The latter will let you pass several cases, while the former will let you pass every case." */       
       if(node == null) return -1;  //if(node == null) return 0;
       return node.ht;
   }

   static int getBalanceFactor(Node node){
       if(node == null) return 0;
       return height(node.left) - height(node.right);
   }

   static Node rightRotate(Node n){
       Node x = n.left;
       Node child = x.right;
       
       // Rotate
       x.right = n;
       n.left = child;
       
       // update height
       n.ht = Math.max(height(n.left), height(n.right))+1;
       x.ht = Math.max(height(x.left), height(x.right))+1;
       
       return x;
   }

   static Node leftRotate(Node n){
       Node x = n.right;
       Node child = x.left;
       
       // Rotate
       x.left = n;
       n.right = child;
       
       // update height
       n.ht = Math.max(height(n.left), height(n.right))+1;
       x.ht = Math.max(height(x.left), height(x.right))+1;
       
       return x;
   }

   
   
   static Node insert(Node root,int val)
   {
       if(root == null) {
           Node newNode = new Node();
           newNode.val = val;
           return newNode;
       }
       
       if(val < root.val){
            root.left = insert(root.left, val);
       } else{
            root.right = insert(root.right, val);
       }
       
       root.ht = Math.max(height(root.left), height(root.right)) + 1;
       
       int balance = getBalanceFactor(root);
       
       // left-left case
       if(balance > 1 && val < root.left.val){
           return rightRotate(root);
       }
       
       // left-right case
       if(balance > 1 && val > root.left.val){
           root.left = leftRotate(root.left);
           return rightRotate(root);
       }
       
       // right-right case
       if(balance < -1 && val > root.right.val){
           return leftRotate(root);
       }

       // right-left case
       if(balance < -1 && val < root.right.val){
           root.right = rightRotate(root.right);
           return leftRotate(root);
       }
       
       return root;
   }


//---------------------------------------------------------------------------------------------------------
// (w/ detailed commments). 
public static class Node{
    int key;
    int height;
    Node left;
    Node right;
}
// function to get height of the tree
static int height(Node node){    
    if(node == null) return 0;
    return node.height; 
}

// functino to return Balance factor of node N
public static int getBalance(Node node){
    if(node == null) return 0;
    return height(node.left) - height(node.right);
}

// rightRotate functino
public static Node rightRotate(Node n){
    Node x = n.left;
    Node child = x.right;

    // perform right rotation
    x.right = n;
    n.left = child;

    // update heights
    n.height = Math.max(height(n.left), height(n.right)) +1;
    x.height = Math.max(height(x.left), height(x.right)) +1;

    // return new root
    return x;
}

// leftRotate functino
public static Node leftRotate(Node n){
    Node x = n.right;
    Node child = x.left;

    // perform left rotation
    x.left = node;
    node.right = child;

    // update heights
    n.height = Math.max(height(n.left), height(n.right)) +1;
    x.height = Math.max(height(x.left), height(x.right)) +1;

    // return new root
    return x;
}

public static Node insert(Node node, int key){
    // perform normal BST rotation
    if(node == null) return new Node(key);

    if(key < node.key)
        node.left = insert(node.left, key);
    else 
        node.right = insert(node.right, key);

    // Update height of this ancestor node */
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    // Get the balance factor of this ancestor node to check 
    // whether this node became unbalanced */
    int balance = getBalance(node);

    // Left-Left case
    if(balance > 1 && key < node.left.key)
        return rightRotate(node);

    // Right-Right case
    if(balance < -1 && key > node.right.key)
        return leftRotate(node);

    // Left-Right case
    if(balance > 1 && key > node.left.key){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // Right-Left case
    if(balance < -1 && key < node.right.key){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node;
}