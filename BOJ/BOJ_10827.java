/* a^b https://www.acmicpc.net/problem/10827
   실수 a와 정수 b가 주어졌을 때, a의 b제곱을 정확하게 계산하는 프로그램을 작성하시오.
   (0 < a < 100, 1 ≤ b ≤ 100) a는 최대 소수점 9자리이며, 소수가 0으로 끝나는 경우는 없다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

class BOJ_10827 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        BigDecimal bigDecimal = new BigDecimal(stringTokenizer.nextToken());
        int pow = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(bigDecimal.pow(pow).toPlainString());
    }
}