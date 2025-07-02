public class MinDistanceTwoNodes {
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
    public static int Distance(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }

        int leftDis=Distance(root.left,n);
        int rightDis=Distance(root.right,n);
        if(leftDis==-1 && rightDis==-1){
            return -1;
        }else if(leftDis==-1){
            return rightDis+1;
        }else{
            return leftDis+1;
        }
    }
    public static int MinimumDistance(Node root,int n1,int n2){
        if(root.data==n1 && root.data==n2){
            return 0;
        }
        Node Common = LCA2(root,n1,n2);

        int dist1 = Distance(Common, n1);
        int dist2 = Distance(Common,n2);
        return dist1+dist2;
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
        System.out.println(MinimumDistance(root, 4, 5));

    }
}
