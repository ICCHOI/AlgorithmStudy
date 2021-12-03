/* 보물 https://www.acmicpc.net/status?user_id=getmoney&problem_id=1026&from_mine=1
   첫째 줄의 수들과 둘째 줄의 수들의 곱의 최솟값들의 합을 출력하시오.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class BOJ_1026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] ascNumbers = new int[number];
        int[] descNumbers = new int[number];
        int sum = 0;

        for(int i = 0; i < number; i++) {
            ascNumbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < number; i++) {
            descNumbers[i] = scanner.nextInt();
        }
        Arrays.sort(ascNumbers);
        descNumbers = Arrays.stream(descNumbers).boxed()
                .sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < number; i++) {
            sum += ascNumbers[i] * descNumbers[i];
        }
        System.out.println(sum);
    }
}
