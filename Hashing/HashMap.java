import java.util.*;
public class HashMap{
    static class HashMapCode<K,V>{//generic values
        private  class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key =key;
                this.value = value;
            }
        }
        private int n;//number of elements in array
        private int N;//number of buckets in Array or size of array
        private LinkedList<Node> buckets[]; //array of linkedList

        @SuppressWarnings("unchecked")
        public HashMapCode(){
            this.N = 4;
            this.buckets = new LinkedList[4]; //in java this line will not be run since we have to define the type of data to be stored inside LinkedList, java will give warning for that does not execute the rest of the code.
            // so by using SuppressWarnings, we are telling java to does not check for this condition
            for(int i =0; i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        private  int hashfunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)% N;
        }
        public  int SearchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<buckets.length;i++){
                buckets[i] = new LinkedList<>();

            }
            //nodes->add in buckets
            for(int i=0;i<oldbucket.length;i++){
                LinkedList<Node> ll = oldbucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.removeFirst();
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key,V value){
            int bi = hashfunction(key);//bucket index
            int di = SearchInLL(key,bi);//data index
            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value= value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }
            double lambda = (double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);
            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }
        public V remove(K key){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);
            if(di!=-1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }
        public V get(K key){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);
            if(di!=-1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        
    }   
    public static void main(String[] args) {
            HashMapCode<String,Integer> hm = new HashMapCode<>();
            hm.put("India",100);
            hm.put("China",105);
            hm.put("US",60);
            System.out.println("India: " + hm.get("India"));
            System.out.println("China: " + hm.get("China"));
            System.out.println("US: " + hm.get("US"));
            System.out.println("Deleted Element:  China : " + hm.remove("China"));
            System.out.println(hm.containsKey("India"));
             System.out.println(hm.containsKey("China"));
            System.out.println("Population of India: "+hm.get("India"));
    }
}