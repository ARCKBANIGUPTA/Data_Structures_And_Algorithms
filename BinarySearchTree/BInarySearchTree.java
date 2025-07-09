

public class BInarySearchTree {
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
    public static void Inorder(Node root){
        if(root==null){
            return;
        }
        Inorder(root.left);
        System.out.print(" "+root.data+" ");
        Inorder(root.right);
    }
    public static boolean Searching(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return Searching(root.left,key);
        }
        else{
            return Searching(root.right,key);
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;

        }
        if(root.data>val){
            //moves to left subtree
            root.left = insert(root.left,val);
        }else{
            //moves to right
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right,val);
        }
        else if(root.data>val){
            root.left = delete(root.left,val);
        }
        else{
            //case 1--leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2--single child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case 3--two children
            Node inSucc = findInorderSuccessor(root.right);//inorder successor is the node with minimum value in right subtree
            root.data=inSucc.data;//changing the data only
            root.right=delete(root.right,inSucc.data);//deleting the inorder successor
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root= null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        Inorder(root);
        System.out.println();
        System.out.println("Does value 7 exists in tree: "+Searching(root, 7));
        System.out.println("Does value 12 exists in tree: "+Searching(root, 12));
        System.out.println("Deleting the node 3: ");
        delete(root, 3);
        Inorder(root);
    }
}
