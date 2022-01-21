/* 1 https://www.acmicpc.net/problem/4375
   2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)이 주어졌을 때 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
   각 테스트 케이스는 한 줄로 이루어져 있고, 1로 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine()) != null) {
            int count = 1;
            int multiple = 1;
            int num = Integer.parseInt(input);
            while (true) {
                if (multiple % num == 0) break;
                multiple = (10 * multiple + 1) % num;
                count++;
            }
            System.out.println(count);
        }
    }
}