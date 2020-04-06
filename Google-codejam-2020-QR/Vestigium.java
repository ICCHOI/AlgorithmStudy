/* Vestigium https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
   첫 번째 입력은 Test case의 수 t 입니다. 그 후 마방진의 열과 행의 길이를 두 번째 입력으로 받고,
   각각의 행과 열에 대한 값을 입력으로 받습니다.
   그 후 (trace : 왼쪽 대각선 위 부터 오른쪽 아래에 해당되는 값의 합),
   (라틴방진을 위반하는 행의 개수), (라틴방진을 위반하는 열의 개수)를 반환합니다.
 */
import java.io.*;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        int[][] answer = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int temp[][] = new int[n][n];

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    temp[j][k] = in.nextInt();
                }
            }

            for (int j = 0; j < n; j++) {
                answer[i][0] = answer[i][0] + temp[j][j];
            }
            //row
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];

                for (int k = 0; k < n; k++) {
                    if (check[temp[j][k] - 1] == true) {
                        answer[i][1]++;
                        break;
                    }
                    check[temp[j][k] - 1] = true;
                }
            }
            //column
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];

                for (int k = 0; k < n; k++) {
                    if (check[temp[k][j] - 1] == true) {
                        answer[i][2]++;
                        break;
                    }
                    check[temp[k][j] - 1] = true;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i+1) + ": " + String.valueOf(answer[i][0]) + " " + answer[i][1] + " " + answer[i][2]);
        }
    }
}