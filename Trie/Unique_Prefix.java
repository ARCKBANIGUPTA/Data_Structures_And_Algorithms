public class Unique_Prefix {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;// is the current letter is the end of word
        int freq;//counts the frequency of each node,that in how many different words this letter has been used
        public Node(){
           for(int i=0;i<26;i++){
                children[i] = null;
            } 
            freq=1;
        }

    }
    public static Node root = new Node();
    public static void Addword(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();

            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];

        }
        curr.eow=true;
    }

    public static void FindPrefix(Node root,String ans){//O(L) l = longest word in Trie
        if(root == null){//base case
            return;
        }
        if(root.freq ==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                FindPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        root.freq = -1;
        String words[] = {"zebra","dog","duck","dove"};
        for(int i=0;i<words.length;i++){
            Addword(words[i]);
        }
        System.out.println("added all words");
        System.out.println("Unique prefix are : ");
        FindPrefix(root, "");
        


    }
}
