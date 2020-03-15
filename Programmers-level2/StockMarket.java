import java.util.Arrays;

class StockMarket {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int price;

        for(int i = 0; i<prices.length; i++){
            price = 0;

            for(int j = i+1; j<prices.length; j++){
                price++;

                if(prices[i]>prices[j]) {
                    answer[i] = price;
                    break;
                }
                else if((prices.length-1) == j) answer[i] = price;
            }
        }
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        StockMarket stock = new StockMarket();
//        int[] prices = {1,2,3,2,3};
//        System.out.println(Arrays.toString(stock.solution(prices)));
//    }
//}
