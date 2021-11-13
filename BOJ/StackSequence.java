/* 스택 수열 https://www.acmicpc.net/problem/1874
   n (1 ≤ n ≤ 100,000)이 주어지고 n개의 줄에는 수열을 이루는  1이상 n이하의 정수가 하나씩 순서대로 주어진다.
   중복된 정수는 없으며 이러한 수열은 스택에 오름차순 순으로 push 된다. 임의의 수열을 스택을 통해
   만들 수 있는지 여부를 확인하여 "NO" 또는 스택 연산이 이뤄지는 과정을 + - 로 반환하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class StackSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine());
        int[] array = new int[length];
        for (int i = 0; i < length; i++) array[i] = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int[] ascArray = array.clone();
        Arrays.sort(ascArray);

        boolean check = false;
        boolean[] checkOverlap = new boolean[length];

        for (int i = 0; i < length; i++) {
            if(checkOverlap[ascArray[i] - 1]) check = true;
            checkOverlap[ascArray[i] - 1] = true;
        }

        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        if (check) System.out.println("NO");
        else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > ascArray[idx]) {
                    stack.push(ascArray[idx]);
                    sb.append("+").append("\n");
                    if(idx != length - 1) idx++;
                    i--;
                }
                else if (array[i] == ascArray[idx]) {
                    if (!stack.empty() && stack.peek().equals(array[i])) {
                        sb.append("-").append("\n");
                        stack.pop();
                    }
                    else {
                        stack.push(ascArray[idx]);
                        sb.append("+").append("\n");
                        if(idx != length - 1) idx++;
                        i--;
                    }
                }
                else {
                    if (!stack.empty() && stack.peek().equals(array[i])) {
                        sb.append("-").append("\n");
                        stack.pop();
                    }
                    else {
                        check = true;
                        break;
                    }
                }
            }
            if (check) System.out.println("NO");
            else System.out.print(sb.toString());
        }
    }
}
