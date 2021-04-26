/* 크레인 인형뽑기 게임 https://programmers.co.kr/learn/courses/30/lessons/64061#
    인형이 담겨있는 2차원 배열과 인형을 뽑을 위치를 나타낸 배열 moves를 입력으로 받아서
    인형을 터트린 횟수를 반환하시오.
 */

import java.util.Stack;

class ToyCrane {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    if (stack.peek() == board[j][moves[i] - 1]) {
                        answer = answer + 2;
                        stack.pop();
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;

                }
            }
        }

        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        ToyCrane crane = new ToyCrane();
//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
//        System.out.println(crane.solution(board, moves));
//    }
//}
