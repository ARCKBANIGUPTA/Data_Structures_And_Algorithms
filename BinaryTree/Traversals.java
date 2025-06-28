import java.util.*;
public class Traversals {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    static class Binarytree{
        static int idx= -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left=buildTree(nodes);
            newnode.right=buildTree(nodes);

            return newnode;
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
        public static void inorder(Node root){
            //Time complexity is -> O(n)
            if(root==null){
                System.out.print(" -1 |");
                return;
            }
            
            inorder( root.left);
            System.out.print(" "+root.data+" |");
            inorder( root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                System.out.print(" -1 |");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(" "+root.data+" |");
        }
        public static void LevelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode= q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;

                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }

                }
            
            }
        }
    }

    public static void main(String[] args) {
        int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree bt = new Binarytree();
        Node root = bt.buildTree(node);
        System.out.println("Preorder tree traversal: ");
        
        bt.preorder(root);
        System.out.println();
        System.out.println("Inorder tree traversal: ");
        bt.inorder(root);
        System.out.println();
        System.out.println("Postorder tree traversal: ");
        bt.postorder(root);
        System.out.println();
        System.out.println("Level order tree traversal: ");
        bt.LevelOrder(root);
    }
}       
