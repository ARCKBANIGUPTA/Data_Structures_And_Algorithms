import java.util.ArrayList;

public class Merge2BST {
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
    public static void Printer(Node root){
        if(root==null){
            return;
        }
        Printer(root.left);
        System.out.print(" "+root.data+" ");
        Printer(root.right);

    }

    public static void findInorder(Node root,ArrayList<Integer> sequence){
        if(root==null){
            return;
        }
        findInorder(root.left,sequence);
        sequence.add(root.data);
        findInorder(root.right,sequence);

    }
    public static void merge(ArrayList<Integer>s1,ArrayList<Integer>s2,ArrayList<Integer>s3){
        int i=0;    
        int j=0;
        while(i<s1.size() && j<s2.size()){
            if(s1.get(i)<=s2.get(j)){
                s3.add(s1.get(i));
                i++;
            }else{
                s3.add(s2.get(j));
                j++;
            }
        }
        while(i<s1.size()){
            s3.add(s1.get(i));i++;
        }
        while(j<s2.size()){
            s3.add(s2.get(j));j++;
        }
    }
    public static Node ArraytoBST(ArrayList<Integer>seq,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(seq.get(mid));
        root.left=ArraytoBST(seq,si,mid-1);
        root.right=ArraytoBST(seq, mid+1, ei);
        return root;

    }
    public static Node MergeBST(Node root1,Node root2){
        ArrayList<Integer> s1 = new ArrayList<>();
        ArrayList<Integer> s2 = new ArrayList<>();
        ArrayList<Integer> s3 = new ArrayList<>();
        findInorder(root2, s2);
        findInorder(root1, s1);
        merge(s1, s2, s3);
        Node root= ArraytoBST(s3, 0, s3.size()-1);
        return root;
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
        Node root1= new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        Node mergedRoot= MergeBST(root1, root2);
        Printer(mergedRoot);
        System.out.println();
        preorder(mergedRoot);

    }
}
