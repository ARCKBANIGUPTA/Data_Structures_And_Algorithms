public class KthAncestor {
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
    
    public static int Kancestor(Node root,int n,int k){
        if(root ==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftK = Kancestor(root.left, n, k);
        int rightK = Kancestor(root.right, n, k);
        if(leftK==-1 && rightK==-1){
            return -1;
        }
        int max = Math.max(leftK, rightK);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
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
        Kancestor(root, 4, 1);
    }
}
