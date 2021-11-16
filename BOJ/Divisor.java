/* 약수 https://www.acmicpc.net/problem/1037
   1과 자기 자신을 제외한 어떤 수의 약수들이 주어질 떄 그 수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Divisor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] divisors = new int[count];
        for (int i = 0; i < count; i++) divisors[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(divisors);
        if (count % 2 == 0) System.out.println(divisors[0] * divisors[count - 1]);
        else System.out.println(divisors[count / 2] * divisors[count / 2]);
    }
}
