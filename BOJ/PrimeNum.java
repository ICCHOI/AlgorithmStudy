/* 소수 구하기 https://www.acmicpc.net/problem/1929
   M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오. (1 ≤ M ≤ N ≤ 1,000,000)
   한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PrimeNum {
    static boolean checkPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        for (int i = min; i <= max; i++) if (checkPrime(i)) System.out.println(i);
    }
}
