/* 좋은 단어 https://www.acmicpc.net/problem/3986
   A는 A끼리 B는 B끼리 매칭하여 push, pop 을 반복하여 진행한다. 매칭이 성공하는 횟수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = number;

        for (int i = 0; i < number; i++) {
            Stack<Character> stack = new Stack<>();
            String words = br.readLine();
            for (int j = 0; j < words.length(); j++) {
                char word = words.charAt(j);
                if (stack.empty()) stack.push(word);
                else {
                    if (stack.peek() == word) stack.pop();
                    else stack.push(word);
                }
            }
            if (!stack.empty()) count--;
        }
        System.out.println(count);
    }
}
