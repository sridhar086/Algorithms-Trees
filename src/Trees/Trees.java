/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author sridhar
 */

// Linked List Class

class Node
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }

}  

class BinaryTree
{
    Node root;
    
    Node tree2listrecursion(Node node)
    {
        if (node.left != null)
        {
            
            Node returned = tree2listrecursion(node.left);
            
            
        }
        else if (node.right != null)
        {            
            tree2listrecursion(node.right);           
        }
        
        return node;
    }
            
            
            
            
    
    
    void tree2list()
    {
                
    }
}



public class Trees {
    
    /* This function is in LinkedList class. Inserts a
   new Node at front of the list. This method is 
   defined inside LinkedList class shown above */
    
    
    public static void main()
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        
    }


    
}
