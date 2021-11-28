/* 주유소 https://www.acmicpc.net/status?user_id=getmoney&problem_id=13305&from_mine=1
   주유소의 기름 가격과 각 주유소 사이의 거리가 주어질때 소비하는 기름 가격의 최솟값을 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        long[][] stations = new long[number - 1][2];
        StringTokenizer stMeter = new StringTokenizer(bf.readLine());
        StringTokenizer stPrice = new StringTokenizer(bf.readLine());
        long min = 1000000000L;
        long meter = 0L;
        long result = 0L;
        for (int i = 0; i < number - 1; i++) {
            stations[i][0] = Long.parseLong(stPrice.nextToken());
            stations[i][1] = Long.parseLong(stMeter.nextToken());

            if (stations[i][0] <= min) {
                result += (meter * min);
                meter = stations[i][1];
                min = stations[i][0];
            }
            else {
                meter += stations[i][1];
            }
        }
        System.out.println(result + (min * meter));
    }
}
