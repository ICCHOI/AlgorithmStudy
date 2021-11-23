/* ATM https://www.acmicpc.net/problem/11399
   N명의 돈을 인출하는 시간들이 주어지고, ATM은 한 명씩 출금할 수 있다고 가정하여 모두가 인출하는데 걸리는 시간의 최솟값을 출력하시오.
 */
import java.util.Arrays;
import java.util.Scanner;

class BOJ_11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] persons = new int[number];
        int sum = 0;
        int total = 0;

        for (int i = 0; i < number; i++) {
            persons[i] = scanner.nextInt();
        }

        Arrays.sort(persons);

        for (int i : persons) {
            sum += i;
            total += sum;
        }

        System.out.println(total);
    }
}