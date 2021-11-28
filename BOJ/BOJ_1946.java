/* 신입사원 https://www.acmicpc.net/problem/1946
   서류심사와 면접심사가 주어질 때 어떤 참가자 A가 어떤 참가자 B보다 두 심사의 점수가 모두 뒤떨어진다면 그 참가자는 합격할 수 없다.
   이 때의 채용에서 선발할 수 있는 인원의 최대값을 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < number; i++) {
            int applierNum = Integer.parseInt(bufferedReader.readLine());
            int[][] appliers = new int[applierNum][2];
            HashSet<String> set = new HashSet<>();
            for(int j = 0; j < applierNum; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                appliers[j][0] = Integer.parseInt(stringTokenizer.nextToken());
                appliers[j][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int count = 1;
            Arrays.sort(appliers, Comparator.comparingInt(o -> o[0]));
            int index = 0;
            for (int j = 1; j < applierNum; j++) {
                if(appliers[index][1] > appliers[j][1]) {
                    count++;
                    index = j;
                }
            }
            System.out.println(count);
        }
    }
}