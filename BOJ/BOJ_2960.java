/* 에라토스테네스의 체 https://www.acmicpc.net/problem/2960
   1 ≤ K < N, max(1, K) < N ≤ 1000) 일 때, 2부터 N까지의 정수에서 에라토스테네스의 체로 걸러지는 K번째 수를 출력하시오.
 */
import java.util.Scanner;

class BOJ_2960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        boolean[] chae = new boolean[N + 1];
        int count = 0;
        int tmp = 0;

        for (int i = 2; i <= N; i++) {
            int a = i;
            while (a <= N && count != K) {
                tmp = a;
                if (!chae[a]) {
                    chae[a] = true;
                    count++;
                }
                a += i;
            }
            if (count == K) {
                System.out.println(tmp);
                break;
            }
        }
    }
}
