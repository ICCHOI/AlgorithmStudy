/* 소수 찾기 https://www.acmicpc.net/problem/1978
   주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PrimeFind {
    static boolean checkPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < count; i++) {
            if (checkPrime(Integer.parseInt(st.nextToken()))) result++;
        }
        System.out.println(result);
    }
}
