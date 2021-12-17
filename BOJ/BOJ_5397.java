/* 키로거 https://www.acmicpc.net/problem/5397
   커서를 좌, 우로 움직이는 '<', '>'와 백스페이스로 입력 문자열의 문자를 지우는 '-'
   그리고 숫자와 알파벳 대 소문자로 이루어진 문자열이 주어질 때 출력 값을 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> listIterator = linkedList.listIterator();
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '<') {
                    if(listIterator.hasPrevious())
                        listIterator.previous();
                }
                else if (c == '>') {
                    if(listIterator.hasNext())
                        listIterator.next();
                }
                else if (c == '-') {
                    if(listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                }
                else listIterator.add(c);
            }
            for (char c : linkedList) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
