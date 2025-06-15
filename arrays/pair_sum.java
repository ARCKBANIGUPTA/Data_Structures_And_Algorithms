import java.util.*;
public class pair_sum {
    public static boolean pairSum(ArrayList<Integer> arr,int key){
        int idx = -1;
        for(int i=0;i<=arr.size()-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                idx = i;//index position of that element,this element is the largest value in the sorted,rotated array
                break;
            }
        }
        int lp = idx+1;//smallest element in the sorted,rotated array
        int rp = idx;

        while(lp!=rp){
            if(arr.get(lp)+arr.get(rp)== key){
                System.out.println(arr.get(lp)+" "+arr.get(rp));
                return true;
            }
            else if(arr.get(lp)+arr.get(rp)<key){
                lp=(lp+1)%arr.size();
            }else{
                rp = (rp+arr.size()-1)%arr.size();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList <Integer> Sum = new ArrayList<>();//this array is sorted and rotated
        Sum.add(11);
        Sum.add(15);
        Sum.add(6);
        Sum.add(8);
        Sum.add(9);
        Sum.add(10);
        int target = 10000;
        if(pairSum(Sum, target)){
            System.out.println("THESE ARE THE SOLUTIONS!");
        }else{
            System.out.println("NO SOLUTIONS!");
        }
    }
}
