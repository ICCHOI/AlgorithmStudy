/* 회전하는 큐 https://www.acmicpc.net/problem/1021
   첫번째 원소 뽑기, 왼쪽으로 회전, 오른쪽으로 회전이 가능하다고 할 때 자료 구조의 크기와 뽑을 원소의 개수가 첫 줄에 주어지고
   두번째 줄에 뽑을 원소의 위치가 주어진다. 회전 연산의 최솟값을 출력하시오.
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class BOJ_1021 {
    static int spinLeft(int target, Deque<Integer> deque, boolean check) {
        int count = 0;
        while(!deque.isEmpty()) {
            if(deque.peek() == target) break;
            else {
                int input = deque.pollFirst();
                deque.addLast(input);
                count++;
            }
        }
        if (check) {
            for (int i = 0; i < count; i++) {
                if (!deque.isEmpty()) {
                    int input = deque.pollLast();
                    deque.addFirst(input);
                }
            }
        }
        else deque.pollFirst();
        return count;
    }

    static int spinRight(int target, Deque<Integer> deque, boolean check) {
        int count = 0;
        while(!deque.isEmpty()) {
            if(deque.peek() == target) break;
            else {
                int input = deque.pollLast();
                deque.addFirst(input);
                count++;
            }
        }
        if (check) {
            for (int i = 0; i < count; i++) {
                if (!deque.isEmpty()) {
                    int input = deque.pollFirst();
                    deque.addLast(input);
                }
            }
        }
        else deque.pollFirst();
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int count = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < size ; i++) {
            deque.addLast(i + 1);
        }

        for (int i = 0; i < count; i++) {
            int targetNum = scanner.nextInt();
            if(!deque.isEmpty() && deque.peekFirst() == targetNum) {
                deque.pollFirst();
            }
            else if(spinLeft(targetNum, deque, true) > spinRight(targetNum, deque, true)) {
                sum += spinRight(targetNum, deque, false);
            }
            else {
                sum += spinLeft(targetNum, deque, false);
            }
        }
        System.out.println(sum);
    }
}
