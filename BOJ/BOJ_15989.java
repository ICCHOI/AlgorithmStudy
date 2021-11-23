/* 1, 2, 3 더하기 4 https://www.acmicpc.net/problem/15989
   정수 n을 1, 2, 3 조합의 합으로 표시할 수 있는 경우의 수를 출력하시오. (순서만 같은 조합은 동일한 조합으로 생각한다.)
 */
import java.util.Scanner;

class BOJ_15989 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int max = 0;
        int[] numbers = new int[number];
        for (int i = 0; i < number; i++) {
            numbers[i] = scanner.nextInt();
            if (max < numbers[i] ) max = numbers[i];
        }
        int[] dp = new int[max];
        dp[0] = 1;
        if(dp.length > 1) dp[1] = 2;
        if(dp.length > 2) dp[2] = 3;
        for (int i = 4; i <= max; i++) {
            dp[i - 1] = dp[i - 4] + (i / 2) + 1;
        }
        for (int i = 0; i < number; i++){
            System.out.println(dp[numbers[i] - 1]);
        }
    }
}