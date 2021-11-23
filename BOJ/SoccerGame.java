/* 축구 게임 https://www.acmicpc.net/problem/13560
   n(2 ≤ n ≤ 10,000)팀으로 이루어진 축구 팀들이 각각 서로 다른 팀과 경기를 하며 이기면 1점, 지면 0점을 얻습니다.
   첫번째 줄은 각 팀의 수이며, 두번째 줄은 각 팀이 제출한 점수입니다. 점수 값이 유효하면 1, 아니면 -1을 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SoccerGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int teams = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] input = new int[teams];
        int sum = 0;
        boolean check = true;

        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        for (int i = 0; i < teams; i++) {
            sum += input[i];
            if (sum < (i + 1) * i / 2) check = false;
        }
        if (teams * (teams - 1) / 2 == sum && check) System.out.print("1");
        else System.out.print("-1");
    }
}
//nC2 -> n! / 2! * (n - 2)!