import java.util.HashMap;
import java.util.*;
public class MajarityElement {
    public static void main(String[] args) {
        int arr[] = {1,3,6,3,7,3,7,3,7,3,4,4,4,7,4,3};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        Set<Integer> set = map.keySet();
        for(Integer s : set){
            if(map.get(s)>arr.length/3){
                System.out.println("Key: "+s+"  Frequency: "+map.get(s));
            }
        }
    }
}
