public class ArrayToBST {
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

    public static Node BuildBST(int arr[],int si,int ei){

        //base case
        if(si>ei){
            return null;
        }
        //find middle element
        int mid = (si+ei)/2;
        Node root = new Node(arr[mid]);
        root.left = BuildBST(arr, si, mid-1);
        root.right = BuildBST(arr, mid+1, ei);
        return root;
    }
    
    public static void printer(Node root){
        if(root==null){
            return;
        }
       
        
        printer(root.left);
        System.out.print(root.data+" ");
        printer(root.right);

    }
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node ROOT = BuildBST(arr, 0, arr.length-1);
        printer(ROOT);
    }
}
