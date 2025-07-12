import java.util.ArrayList;

public class SizeOfLargestBST {
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
    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;
        Info(boolean isBST,int size,int max,int min){
            this.isBST=isBST;
            this.size=size;
            this.max=max;
            this.min=min;
        }
    }
    public static int MaxBST=0;
    public static Info LargetBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftinfo=LargetBST(root.left);
        Info rightinfo=LargetBST(root.right);
        int size = leftinfo.size+rightinfo.size+1;
        int min = Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        int max =Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));


        if( leftinfo.max>=root.data || rightinfo.min<=root.data){
           return new Info(false,size,max,min);
        }
        if(leftinfo.isBST && rightinfo.isBST){
            MaxBST=Math.max(MaxBST,size);
            return new Info(true,size,max,min);
        }
        return new Info(false,size,max,min);
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){

            if(root==null){

                return;
            }
            
            inorder( root.left);
            System.out.print(" "+root.data+" ");
            inorder( root.right);
    }
    public static void preorder(Node root){

            if(root==null){

                return;
            }
            System.err.print(" "+root.data+" ");
            preorder( root.left);
            preorder( root.right);
    }
    public static void main(String[] args) {
        int values[] = {50,30,5,20,60,45,70,65,80};
        Node root= null;
        ArrayList <Integer> path = new ArrayList<>();
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        preorder(root);
        Info largestbst = LargetBST(root);
        System.out.println();
        System.out.println("Maxmimum size of the BST is : "+MaxBST);
    }
}
