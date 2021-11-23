/* Project Teams https://www.acmicpc.net/problem/20044
   Greedy 하게 입력 받은 최솟값과 최댓값을 팀으로 구성하여, 최소값을 출력하시오.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_20044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 2 * n; i ++) {
            arr.add(sc.nextInt());
        }

        arr.sort(Comparator.naturalOrder());

        ArrayList<Integer> sum = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            sum.add(arr.get(i) + arr.get(arr.size()-i-1));
        }

        int min = 200000;
        int now = 0;
        for (Integer integer : sum) {
            now = integer;
            if (min > now) {
                min = now;
            }
        }
        System.out.println(min);
    }
}