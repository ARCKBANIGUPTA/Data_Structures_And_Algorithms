public class Longest_Word {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;// is the current letter is the end of word

        Node(){
           for(int i=0;i<26;i++){
                children[i] = null;

           } 
        }

    }
    public static Node root = new Node();
    public static void Addword(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();

            }
            curr = curr.children[idx];

        }
        curr.eow=true;
    }
    public static boolean search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow==true;
    }
    public static String ans = "";
    public static void LongestWordinTrie(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int idx=0;idx<26;idx++){
            if(root.children[idx]!=null && root.children[idx].eow==true){
                char ch = (char)(idx+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                LongestWordinTrie(root.children[idx], temp);
                //backtrap step
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }   
    public static void main(String[] args) {
        String words[] = {"banana","a","ap","app","appl","apple","apply"};
        for(int i=0;i<words.length;i++){
            Addword(words[i]);
        }
        System.out.println("added all words");
        LongestWordinTrie(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
