/* Fly me to the Alpha Centauri https://www.acmicpc.net/problem/1011
   등차수열 1을 가지며 항해할 수 있는 비행선을 가정할 때, 처음 시작과 마지막은 1로 이동한다. 어떤 특정 거리에서 거리까지의 이동 횟수를 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BOJ_1011 {
    static ArrayList<Long> countSum(int distance, ArrayList<Long> times) {
        int i = 1;
        long result = 0L;
        times.add(0L);
        while(distance > 0) {
            distance -= i;
            result += i;
            times.add(result);
            if (distance > 0) {
                distance -= i;
                result += i;
                times.add(result);
                i++;
            }
        }
        return times;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int max = 0;
        int[] numbers = new int[number];
        ArrayList<Long> times = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            numbers[i] = Integer.parseInt(st.nextToken()) - numbers[i];
            if (max < numbers[i]) max = numbers[i];
        }
        countSum(max, times);
        for (int k : numbers) {
            for (int j = 0; j < times.size(); j++) {
                if (times.get(j) >= k) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}