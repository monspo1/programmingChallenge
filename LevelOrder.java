/** Level Order
/*
* Problem Statement
  You are given a pointer to the root of a binary tree. 
  You need to print the level order traversal of this tree. 
  In level order traversal, we visit the nodes level by level from left to right. 
  You only have to complete the function. 

  For example:

         3
       /   \
      5     2
     / \    /
    1   4  6

  For the above tree, the level order traversal is 3 -> 5 -> 2 -> 1 -> 4 -> 6.

* Input Format
  You are given a function,

    void level_order(node * root)
    {

    }

* Output Format  
  Print the values in a single line seperated by a space.

* Sample Input

         3
       /   \
      5     2
     / \    /
    1   4  6

* Sample Output
    3 5 2 1 4 6

* Explanation

    Level 1:        3
                  /   \
    Level 2:     5     2
                / \    /
    Level 3:   1   4  6

  We need to print the nodes level by level. We process each level from left to right. 
  Level Order Traversal: 3 -> 5 -> 2 -> 1 -> 4 -> 6
//*/


/* 
    class Node 
       int data;
       Node left;
       Node right;
*/
// Submitted code (iterative solution using queue)
void LevelOrder(Node root){
   List<Node> queue = new LinkedList<>();
   if(root == null){ System.out.println(); return; }

   queue.add(root);

   while(!queue.isEmpty()){
       Node node = queue.remove(0);
       System.out.print(node.data + " ");
       if(node.left != null) queue.add(node.left);
       if(node.right != null) queue.add(node.right);
   }
}


// recursive solution from http://www.geeksforgeeks.org/level-order-tree-traversal/ 
void LevelOrderRecursive(Node root){
  int h = height(root);
  int i;
  for(i=1; i<=h; i++)
    LevelOrderRecursive(root, i);
}     

void LevelOrderRecursive(Node root, int level){
  if(root == null){ System.out.println(); return; }
  
  if(level == 1) System.out.print(root.data);
  else if(level > 1){
    LevelOrderRecursive(root.left, level-1);
    LevelOrderRecursive(root.right, level-1);
  }
}
 
int height(Node root){
    if(root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
}