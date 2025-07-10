import java.util.ArrayList;

public class MirrorBST {
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
    public static Node Mirror(Node root){
        if(root==null){
            return null;
        }
        Node Lefts = Mirror(root.left);
        Node Rights=Mirror(root.right);

        root.left = Rights;
        root.right=Lefts;
        return root;
    }
    public static void printer(Node root){
        if(root==null){
            return;
        }
       
        System.out.print(root.data+" ");
        printer(root.left);
        printer(root.right);

    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root= null;
        ArrayList <Integer> path = new ArrayList<>();
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        System.out.println("Before Mirror: ");
        printer(root);
        root = Mirror(root);
        System.out.println();
        System.out.println("After Mirror: ");
        printer(root);
    }
}
