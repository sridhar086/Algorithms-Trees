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

// Binary Tree to doubly linked list using recursion and O(1) space complexity
//Sample binary tree chosen here

/*
                                                10
                                            /        \
                                        12              15
                                      /    \           / 
                                    25      30        36
                                          /             \
                                         8               244
                                       /   \
                                      5     1

*/


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
    static int balance_check_flag = 0;
    
    Node btree2dll(Node node)
    {
        try{

        Node carry = null;
        if (node.left != null)
        {            
            Node left_returned = btree2dll(node.left);
            if(flag == 0)
            {head = left_returned;flag=1;}            
            left_returned.right = node;
            node.left = left_returned;            
            carry = node;

        }
        if (node.right != null)
        {         
            Node temp = btree2dll(node.right);
            Node right_returned = temp;
            Node attach;
            while(true)
            {
                //System.out.println("in here "+temp.data);
                if(temp.left == null)
                {
                attach = temp;break;
                }
                else if (temp.left.left == null)
                {
                    attach = temp.left;                    
                    break;
                }
                else{temp = temp.left;}                
            }
            //System.out.println("***");
            node.right = attach;
            attach.left = node;
            carry = right_returned;
        }
        if(node.right!=null || node.left!=null){return carry;}

        
    }catch(Exception e){System.out.println("Exception here "+e.toString());}
        return node;
    }           
            

     
    public int check_balancing(Node n)
    {
        try
        {
        int val1 = 0;
        int val2 = 0;
        if(n.left==null && n.right==null)
        {return 1;}
        if(n.left!=null)
        {
            val1 = check_balancing(n.left);            
        }
        if(n.right!=null)
        {
            val2 = check_balancing(n.right);            
        }
        
        if(    Math.abs(val1 - val2) > 1   )
        {balance_check_flag = 1;}
        if(val1 > val2) return val1+1;
        else return val2+1;
        
        }  catch(Exception e){System.out.println("test.BinaryTree.check_balancing() "+e.toString()+"  "+e.getCause());}
        return 0;
    }



    
    
    //This is to find the second minimum in a special tree that contains two childs for everynode.
    int min = 0;
    int max = 0;
    int minmax = 0;
    
    public int findmin(Node root)
    {
        if (root.left==null && root.right==null)
            return 0;
        else
        {
            int val1 = root.left.data;
            int val2 = root.right.data;
            //System.out.println("the values are "+val1+" "+val2);
            if (val1<val2)
            {
                if(val1<min) min = val1;                
                if(val2>max) max = val2;                
            }
            else
            {
                if(val2<min) min = val2;            
                if(val1>max) max = val1;
            }           
            findmin(root.left);
            findmin(root.right);
        }
        return 0;
    }
    
    public int findsecondmin(Node root)
    {
        //System.out.println("in here");
        if (root.left==null && root.right==null)
            return 0;
        else
        {
            int val1 = root.left.data;
            int val2 = root.right.data;
            //System.out.println("the values are "+val1+" "+val2);
            if(val1 > min)
            {
                if(val1<minmax)
                {
                    minmax = val1;
                }

            }
            if(val2 > min)
            {
                //System.out.println("yes this should work");
                if(val2<minmax)
                {
                   
                    minmax = val2;
                }
                
            }
            findsecondmin(root.left);
            findsecondmin(root.right);
        }
        return 0;
        
        
    }

    public int findSecondMinimumValue(Node root) {
        
        min = root.data;
        
        findmin(root);
        if(max == 0) max = min;
        minmax = max;
        System.out.println("The min and max values are "+min+ " "+max);
        findsecondmin(root);
        System.out.println("The min and second min "+min+""+minmax);
        if(minmax == min)
        return  -1;
        else
        return minmax;

        
            
    }

}
public class Trees {

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        tree.root.right.left.right = new Node(244);
        tree.root.left.right.left = new Node(8);
        tree.root.left.right.left.left = new Node(5);
        tree.root.left.right.left.right = new Node(1);
        
        tree.check_balancing(tree.root);
        System.out.println("The status of balancing tree is "+tree.balance_check_flag);
        
        
        tree.findSecondMinimumValue(tree.root);  //only for a special case tree that has both child nodes for a node
        System.out.println("The min and max are "+tree.min+" "+tree.max);
        System.out.println("The second minimum is "+tree.minmax);
        
        tree.btree2dll(tree.root);
        try{
        while(true)
        {
            System.out.print(BinaryTree.head.data+" ");            
            BinaryTree.head = BinaryTree.head.right;
            if(BinaryTree.head == null){break;}
            
        }
        
        }catch(Exception e){System.out.println("exception while printing "+e.toString());}
        
    }


    
}
