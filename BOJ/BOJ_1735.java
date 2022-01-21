/* 분수 합 https://www.acmicpc.net/problem/1735
   첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 입력되는 네 자연수는 모두 30,000 이하이다.
   두 분수의 합을 기약분수 (분자 분모) 형태로 나타내어 출력하시오.
 */
import java.util.Scanner;

class BOJ_1735 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a_bunja = scanner.nextInt();
        int a_bunmo = scanner.nextInt();
        scanner.nextLine();
        int b_bunja = scanner.nextInt();
        int b_bunmo = scanner.nextInt();

        int bunja = a_bunja * b_bunmo + b_bunja * a_bunmo;
        int bunmo = a_bunmo * b_bunmo;

        int gcd = gcd(bunja, bunmo);
        System.out.printf("%d %d", bunja / gcd, bunmo / gcd);
    }
}
