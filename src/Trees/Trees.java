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
    static Node root;
    static Node head;
    static int flag = 0;
    
    static Node tree2listrecursion(Node node)
    {
        try{
       
        if (node.left != null)
        {            
            Node left_returned = tree2listrecursion(node.left);
            if(flag == 0)
            {head = left_returned;flag=1;}
            //System.out.println("node");
            left_returned.right = node;
            node.left = left_returned;
            //returned.right = node;            
            Node right_returned=null;
            if (node.right != null)
            {
                right_returned = tree2listrecursion(node.right);
                //System.out.println("node");
                node.right = right_returned;
                right_returned.left = node;
                //System.out.println("The value returned "+right_returned.data);
                
            }
            if(right_returned == null){return node;}
            else{return right_returned;}
            
        }
        else if (node.right != null)
        {         
            Node right_returned = tree2listrecursion(node.right);
            //System.out.println("node");
            right_returned.right = node;
            node.left = right_returned;
            Node left_returned = null;
            if (node.right != null)
            {
                right_returned = tree2listrecursion(node.right);
                System.out.println("node");
                node.right = right_returned;
                right_returned.left = node;
                
            }
            //System.out.println("The value returned "+left_returned.data);
            return left_returned;
        }
        //System.out.println("The value returned "+node.data);
        
    }catch(Exception e){}
        return node;
    }
            
            
}



public class Trees {
    
    /* This function is in LinkedList class. Inserts a
   new Node at front of the list. This method is 
   defined inside LinkedList class shown above */
    
    
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        //tree.root.left.right.left = new Node(8);
        //tree.root.left.right.left.left = new Node(5);
        //tree.root.left.right.left.right = new Node(1);
        BinaryTree.tree2listrecursion(tree.root);
        
        while(true)
        {
            System.out.println(BinaryTree.head.data+" ");
            BinaryTree.head = BinaryTree.head.right;
            
        }
        
    }


    
}
