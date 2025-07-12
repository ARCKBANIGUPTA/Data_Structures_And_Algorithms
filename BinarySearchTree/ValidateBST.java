import java.util.ArrayList;

public class ValidateBST {
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
   

    public static boolean isValid(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }
               //left subtree call              right subtree call
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
    public static void main(String[] args) {
        int values[] = {5,5,5,5};
        Node root= null;
        ArrayList <Integer> path = new ArrayList<>();
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        if(isValid(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
    }
}
