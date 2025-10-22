public class Stocks {
    
    public static int BuyorSell(int price[],int days,int profit,int cost,boolean bought,int fees){

        //3 ways -> buy ,sell or skip
        if(days>price.length){
            return profit;
        }
        int prf1= Integer.MIN_VALUE;
        int prf2= Integer.MIN_VALUE;
        int prf3= Integer.MIN_VALUE;
        int maximumPrf = 0;
        int c1 = price[days-1];
        if(days==1){
            //2 options->buy or skip
            //buy
             prf1 = BuyorSell(price, days+1, 0, c1,true,fees);
            //skip
             prf2 = BuyorSell(price, days+1, 0, 0,false,fees);
             maximumPrf = Math.max(prf1, prf2);

        }
        else if(days!=1 && days!=price.length){
            // 3 options 
            //buy
            if(bought==false){
                 prf1 = BuyorSell(price, days+1, profit, c1, true,fees);
            }//sell
            else if(bought==true){
                 prf2 = BuyorSell(price, days+1, profit+(c1-cost-fees), 0, false,fees);
            }
            //skip
             prf3 = BuyorSell(price, days+1, profit, cost, false, fees);
            maximumPrf = Math.max(Math.max(prf1, prf2), prf3);

        }
        else{
            //2 options
            //sell
            if(bought==true){
                 prf1 = BuyorSell(price, days+1, profit+(c1-cost-fees), 0, false, fees);
            }
             maximumPrf = Math.max(prf1, profit);
        }
        return maximumPrf;

    }

    public static int BuyorSellMemoization(int price[],int dp[][],int days,boolean bought,int fee ){
        if(days==price.length){
            return 0;
        }
    }


    public static void main(String[] args) {
        int arr[] = {6,1,7,2,8,4};
        int dp [days+1][]
        System.out.println(BuyorSell(arr, 1, 0, 0, false, 2));
    }
}
