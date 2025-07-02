import java.util.*;
public class LowestCommonAncestor {
    //time complexity is -> O(n)
     static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean getPath(Node root,int n,ArrayList <Node> path){
        //base case
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        

        boolean findleft = getPath(root.left,n,path);
        boolean findright = getPath(root.right, n, path);
        if(findleft || findright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node LCA1(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        //calculating the path
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static Node LCA2(Node root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2){
            return root;
        }

        Node leftlca=LCA2(root.left,n1,n2);
        Node rightlca =LCA2(root.right,n1,n2);

        if(rightlca ==null ){
            return leftlca;
        }
        if(leftlca==null ){
            return rightlca;
        }
        return root;
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
        System.out.println("Approach 1: "+LCA1(root, 4, 5).data);
        System.out.println("Approach 2: "+LCA2(root, 4, 5).data);
    }
}
