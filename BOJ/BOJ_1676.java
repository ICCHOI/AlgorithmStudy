/* 팩토리얼 0의 개수 https://www.acmicpc.net/problem/1676
   N!을 뒤에서 부터 읽었을 때의 0의 개수를 세어서 반환하시오.
 */
import java.util.Scanner;

class BOJ_1676 {
    static int countFive(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k != 0) {
                if (k % 5 == 0) {
                    count++;
                    k /= 5;
                }
                else break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countFive(scanner.nextInt()));
    }
}