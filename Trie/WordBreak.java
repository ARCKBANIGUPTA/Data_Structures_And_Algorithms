public class WordBreak {
    static class Node{
        Node children[] = new Node[26];
        boolean eow =false;
        Node(){
            for(int i=0;i<26;i++){
                this.children[i]=null;
            }
        }
    }

    public static Node root = new Node();

    public static void Addword(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow= true;
    }

    public static boolean searchword(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx  = word.charAt(i) - 'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow ==true;
    }

    public static boolean wordbreaker(String str){
        if(str.length()==0){
            return true;
        }
        for(int i=1;i<=str.length();i++){
            String newstr = str.substring(0, i);//first part
            String newstr2 = str.substring(i);//second part
            if(searchword(newstr) && wordbreaker(newstr2)){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i","like","samsung","sam","ice","mobile"};
        String str = "ilikesamsung";
        for(int i=0;i<words.length;i++){
            Addword(words[i]);
        }

        System.out.println("Line ilikesamsung exists : "+wordbreaker(str));
    }

}
