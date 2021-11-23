/* 골드바흐의 추측 https://www.acmicpc.net/problem/9020
   2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다. n(2k)이 주어졌을 때 골드바흐 파티션을 출력하시오.
   n이 여러가지인 경우 두 소수의 차이가 가장 작은 것을 출력한다.
 */
import java.util.Scanner;

class BOJ_9020 {
    static boolean checkPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        for (int i = 0; i < number; i++) {
            int gold = scanner.nextInt();
            int[] bach = new int[2];
            for (int j = 2; j <= gold / 2; j++) {
                if (checkPrime(j)) {
                    if (checkPrime(gold - j)) {
                        bach[0] = j;
                        bach[1] = gold - j;
                    }
                }
            }
            System.out.printf("%d %d\n", bach[0], bach[1]);
        }
    }
}