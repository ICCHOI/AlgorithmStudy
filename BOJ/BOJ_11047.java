/* 동전 0 https://www.acmicpc.net/problem/11047
   준규가 가지고 있는 N 종류의 동전을 적절히 사용해서 그 가치를 K로 만드는 동전 개수의 최솟값을 구하시오.
   (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 */
import java.util.Scanner;

class BOJ_11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCoin = scanner.nextInt();
        int money = scanner.nextInt();
        int[] coins = new int[numberOfCoin];
        int sum = 0;

        for (int i = 0; i < numberOfCoin; i++) {
            coins[i] = scanner.nextInt();
        }

        for (int i = numberOfCoin; i > 0; i--) {
            if(money - coins[i - 1] >= 0) {
                money -= coins[i - 1];
                sum++;
                i++;
            }
        }

        System.out.println(sum);
    }
}