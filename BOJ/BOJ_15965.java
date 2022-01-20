/* K번째 소수 https://www.acmicpc.net/problem/15965
   자연수 K(1 <= K <= 500,000)를 입력으로 받아 K번째 소수를 출력하시오.
 */
import java.util.Scanner;

class BOJ_15965 {
    static int checkPrime (int number, boolean[] booleans) {
        int count = 0;
        int answer = -1;
        for (int i = 2; i <= booleans.length; i++) {
            if (!booleans[i]) {
                answer = i;
                count++;
                if(count == number) break;
                int j = i;
                while (j < booleans.length) {
                    if(booleans[j]) {
                        j += i;
                        continue;
                    }
                    if (j % i == 0) {
                        booleans[j] = true;
                        j += i;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        boolean[] booleans = new boolean[7368788]; // 2 -> 7368787
        System.out.println(checkPrime(new Scanner(System.in).nextInt(), booleans));
    }
}
