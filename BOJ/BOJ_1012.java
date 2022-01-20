/* 유기농 배추 https://www.acmicpc.net/problem/1012
   배추가 있는 곳이 1, 없는 곳이 0이라고 할 때 상, 하, 좌, 우로 연결된 배추 집합의 개수를 세어 반환하시오.
   테스트 케이스의 개수 T, 다음 줄부터 각각의 케이스에 대해 첫째 줄에는 밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
   그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
   각 케이스 별 최소의 배추 집합의 수를 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_1012 {
    static int stoi(String str) {
        return (Integer.parseInt(str));
    }

    static int dfs(int[][] field, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    count++;
                }
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int[] move: distance) {
                        int row = cur[0] + move[0];
                        int col = cur[1] + move[1];

                        if (row < 0 || col < 0 || row >= field.length || col >= field[0].length)
                            continue;

                        if (field[row][col] == 1 && !visited[row][col]) {
                            visited[row][col] = true;
                            queue.add(new int[]{row, col});
                        }
                    }
                }
            }
        }
        return (count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());
        for (int k = 0; k < tc; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = stoi(st.nextToken());
            int row = stoi(st.nextToken());
            int[][] field = new int[row][col];
            boolean[][] visited = new boolean[row][col];
            int number = stoi(st.nextToken());

            for (int i = 0; i < number; i++) {
                st = new StringTokenizer(br.readLine());
                int y = stoi(st.nextToken());

                int x = stoi(st.nextToken());
                field[x][y] = 1;
            }

            System.out.println(dfs(field, visited));
        }
    }
}
