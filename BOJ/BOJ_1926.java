/* 그림 https://www.acmicpc.net/problem/1926
   1로 연결된 그림이 그려져 있을 때, 그림의 개수와, 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
   가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BOJ_1926 {
    static int bfs(Node start, int[][] graph, boolean[][] visited) {
        int countOne = 0;
        Queue<Node> queue = new LinkedList<>();
        Node[] check = {new Node(0, -1), new Node(0, 1), new Node(1, 0), new Node(-1, 0)};

        queue.add(start);
        visited[start.col][start.row] = true;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            countOne++;
            for (Node node : check) {

                int colNode = curNode.col + node.col;
                int rowNode = curNode.row + node.row;

                if (colNode < 0 || rowNode < 0 || colNode >= graph.length || rowNode >= graph[0].length) continue;

                if (graph[colNode][rowNode] == 1 && !visited[colNode][rowNode]) {
                    queue.add(new Node(colNode, rowNode));
                    visited[colNode][rowNode] = true;
                }
            }
        }
        return countOne;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = scanner.nextInt();
        int count = 0;
        int max = 0;
        int[][] paint = new int[col][row];
        boolean[][] visited = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                paint[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!visited[i][j] && paint[i][j] == 1) {
                    count++;
                    max = Math.max(max, bfs(new Node(i, j), paint, visited));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}

class Node {
    int col;
    int row;

    Node(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
