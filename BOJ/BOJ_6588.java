/* 골드바흐의 추측 https://www.acmicpc.net/problem/6588
   2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다. n(2k)이 주어졌을 때 골드 바흐 추측을 검증하는 프로그램을 작성하시오.
   n이 여러가지인 경우 두 소수의 차이가 가장 큰 것을 출력한다, 0을 입력 받을 시 종료한다.
 */
import java.util.Scanner;

class BOJ_6588 {
    static boolean checkPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int gold;

        while ((gold = scanner.nextInt()) != 0) {
            int[] bach = new int[2];
            for (int j = 2; j <= gold / 2; j++) {
                if (checkPrime(j)) {
                    if (checkPrime(gold - j)) {
                        bach[0] = j;
                        bach[1] = gold - j;
                        break;
                    }
                }
            }
            stringBuilder.append(gold).append(" = ").append(bach[0]).append(" + ").append(bach[1]).append('\n');
        }
        System.out.print(stringBuilder);
    }
}