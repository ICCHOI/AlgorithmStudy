/* 베르트랑 공준 https://www.acmicpc.net/problem/4948
   n보다 크고 2n보다 작거나 같은 소수는 적어도 하나 존재한다. 각 테스트 케이스에 대해 n보다 크고 2n보다 작은 소수의 개수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_4948 {
    static boolean checkPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i;

        while ((i = Integer.parseInt(bufferedReader.readLine())) != 0) {
            int count = 0;
            for (int j = i + 1; j <= 2 * i; j++) {
                if (checkPrime(j)) count++;
            }
            System.out.println(count);
        }
    }
}