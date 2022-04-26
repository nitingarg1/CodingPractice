public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
    int profit =0;
    int lowestPrice= Integer.MAX_VALUE;
    for(int price:prices){
        if(price<lowestPrice){
            lowestPrice=price;
        }else if(price>lowestPrice){
            profit=profit+price-lowestPrice;
            lowestPrice=price;
        }
    }

    return profit;
    }
}
