/* 토마토 https://www.acmicpc.net/problem/7569
  각 상자의 익은 토마토가 상, 하, 좌, 우, 전, 후의 위치의 익지 않은 토마토들에게 영향을 줘 토마토를 숙성 시킵니다.
   2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이며 익은 토마토가 1, 익지 않은 토마토가 0, 토마토가 없는 -1이 주어질 때,
  토마토가 모두 익을 때 까지의 최소 날짜를 구하시오. 토마토가 이미 익어있다면 0, 익지 못하는 상황이면 -1을 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_7569 {
    static int dfs(int[][][] tomatoes, int[][][] days, Queue<int[]> queue) {
        int[][] check = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        int heightOrigin = tomatoes.length;
        int rowOrigin = tomatoes[0].length;
        int colOrigin = tomatoes[0][0].length;
        int day = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] distance : check) {
                int height = distance[0] + cur[0];
                int row = distance[1] + cur[1];
                int col = distance[2] + cur[2];

                if (height < 0 || row < 0 || col < 0 || height >= heightOrigin || row >= rowOrigin || col >= colOrigin)
                    continue;

                if (days[height][row][col] == -1 && tomatoes[height][row][col] == 0) {
                    queue.add(new int[]{height, row, col});
                    days[height][row][col] = days[cur[0]][cur[1]][cur[2]] + 1;
                }

            }
        }

        for (int i = 0; i < heightOrigin; i++) {
            for (int j = 0; j < rowOrigin; j++) {
                for (int k = 0; k < colOrigin; k++) {
                    if (days[i][j][k] == -1){
                        return (-1);
                    }
                    day = Math.max(day, days[i][j][k]);
                }
            }
        }
        return day;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int height = Integer.parseInt(stringTokenizer.nextToken());

        int[][][] tomatoes = new int[height][row][col];
        int[][][] days = new int[height][row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                StringTokenizer inputTokens = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < col; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(inputTokens.nextToken());
                    days[i][j][k] = -1;
                    if (tomatoes[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        days[i][j][k]++;
                    }
                    if (tomatoes[i][j][k] == -1) {
                        days[i][j][k]--;
                    }
                }
            }
        }
        System.out.println(dfs(tomatoes, days, queue));
        System.out.println(Arrays.deepToString(days));
    }
}
