/* 주식시장 https://programmers.co.kr/learn/courses/30/lessons/42584
   정수 배열을 입력으로 받아 배열 index의 값이 내려가는 구간까지의 길이를 담은 배열을 반환하시오.
*/

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
