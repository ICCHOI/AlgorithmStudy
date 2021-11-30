/* 전깃줄 https://www.acmicpc.net/problem/2565
   전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
   남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class BOJ_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int[][] connections = new int[number][2];
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            connections[i][0] = Integer.parseInt(st.nextToken());
            connections[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(connections, Comparator.comparingInt(o1 -> o1[0]));

        int[] ascNumbers = new int[number];
        int max = 1;
        for (int i = 0; i < number; i++){
            ascNumbers[i] = 1;
            for (int j = 0; j < i; j++){
                if (connections[j][1] < connections[i][1]) {
                    ascNumbers[i] = Math.max(ascNumbers[i], ascNumbers[j] + 1);
                }
                if (max < ascNumbers[i]) max = ascNumbers[i];
            }
        }
        System.out.println(number - max);
    }
}
