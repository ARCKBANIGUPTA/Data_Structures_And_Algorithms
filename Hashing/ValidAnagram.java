import java.util.HashMap;

public class ValidAnagram {
    

    public static boolean isValid(String s,String t){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char st = s.charAt(i);
            if(map.containsKey(st)){
                map.put(st,map.get(st)+1);
            }else{
                map.put(st,1);
            }
        }

        for(int j=0;j<t.length();j++){
            char sp = t.charAt(j);
            if(map.containsKey(sp)){
                if(map.get(sp)!=1){
                    map.put(sp, map.get(sp)-1);
                }else{
                    map.remove(sp);
                }
            }else{
                return false;
            }
        }
        if(!map.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValid("race", "care"));
        System.out.println(isValid("Keen", "Keel"));
        System.out.println(isValid("poiuytrewq", "qwertyuiop"));
    }
}
