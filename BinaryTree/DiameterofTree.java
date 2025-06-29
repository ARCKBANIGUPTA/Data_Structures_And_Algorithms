public class DiameterofTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info{
        int height;
        int diammeter;

        public Info(int dia,int ht){
            height = ht;
            diammeter=dia;
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int currheight=Math.max(lh, rh)+1;
        return currheight;
    }
    public static int Diameter1(Node root){
        
        if(root==null){
            return 0;
        }
        int leftdia = Diameter1(root.left);
        int rightdia = Diameter1(root.right);
        int leftheight= height(root.left);
        int rightheight=height(root.right);
        int selfdia = leftheight+rightheight+1;
        int dia = Math.max(selfdia,Math.max(rightdia,leftdia));
        return dia;
    }
     public static Info Diameter2(Node root){
        
        if(root==null){
            return new Info(0,0);
        }
        Info leftinfo = Diameter2(root.left);
        Info rightinfo = Diameter2(root.right);
        int finaldia = Math.max(Math.max(leftinfo.diammeter, rightinfo.diammeter), leftinfo.height+rightinfo.height+1);
        int finalht = Math.max(leftinfo.height, rightinfo.height)+1;
        return new Info(finaldia, finalht);
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
        System.out.println("Time complexity is -> O(n^2)");
        System.out.println(Diameter1(root));
        System.out.println("Time complexity is -> O(n)");
        Info dia = Diameter2(root);
        System.out.println(dia.diammeter);
    }
}
