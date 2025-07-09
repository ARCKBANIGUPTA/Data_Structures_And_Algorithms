
import java.util.*;
public class RootToLeafPaths {
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
    public static void printPath(ArrayList<Integer> path){
        System.out.println();
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
    }
    public static void PathtoLeaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.right==null && root.left==null){
            printPath(path);
            return;
        }
        
        PathtoLeaf(root.left, path);
        PathtoLeaf(root.right, path);
        path.remove(path.size()-1);
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

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root= null;
        ArrayList <Integer> path = new ArrayList<>();
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        PathtoLeaf(root, path);
    }
}
