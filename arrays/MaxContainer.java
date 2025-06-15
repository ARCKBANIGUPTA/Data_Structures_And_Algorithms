import java.util.*;
public class MaxContainer {
    public static int storeWaterBrute(ArrayList<Integer> ht){
        int MaxWater = 0;
        //brute force
        for(int i=0;i<ht.size();i++){
            for(int j=i+1;j<ht.size();j++){
                int ht1 = Math.min(ht.get(i), ht.get(j));
                int w = j-i;
                int curr = ht1*w;
                MaxWater = Math.max(MaxWater, curr);
            }
        }
        return MaxWater;
    }
    public static int storeWaterLinear(ArrayList<Integer> ht){
        int maxwater =0;
        int lp = 0;
        int rp = ht.size()-1;
        while(lp<rp){
            int maxht = Math.min(ht.get(lp), ht.get(rp));
            int w = rp-lp;
            int currWater = maxht*w;
            maxwater = Math.max(maxwater, currWater);
            if(ht.get(lp) < ht.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxwater;
    }
    public static void main(String[] args) {
        ArrayList <Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println("this is brute force method -> O(n^2)     :"+storeWaterBrute(height));
         System.out.println("this is 2 pointer method -> O(n)   :"+storeWaterLinear(height));
        
    }
}
