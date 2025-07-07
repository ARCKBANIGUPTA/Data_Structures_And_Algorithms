import java.util.*;

public class SumTree {
    //time complexity--> O(n)
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static int Sumtree(Node root){
        //base case;
        if(root==null){
            return 0;
        }
        int leftChild=Sumtree(root.left);
        int rightChild = Sumtree(root.right);
        int rootData=root.data;
        int newleft = root.left==null?0 : root.left.data;
        int newright = root.right==null?0:root.right.data;
        root.data=leftChild+rightChild+newleft+newright;
        //root.left & root.right are the updated value ie.. the sum of nodes of their left & right subtrees
        return rootData;
    }
    public static void preorder(Node root){
            //Time complexity is -> O(n)
            if(root==null){
                System.err.print(" -1 |");
                return;
            }
            System.err.print(" "+root.data+" |");
            preorder( root.left);
            preorder( root.right);
    }
    public static void main(String[] args) {
                //     1
                //    / \
                //   2   3
                //  / \   \
                // 4   5   6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        root.right.left=new Node(7);
        System.out.println("root node: "+Sumtree(root));
        preorder(root);
    }
}
