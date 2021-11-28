/* 에디터 https://www.acmicpc.net/problem/1946
   편집기가 지원하는 명령어를 구현하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        int number = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Character> editor = new LinkedList<>();
        ListIterator<Character> listIterator = editor.listIterator();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            listIterator.add(text.charAt(i));
        }

        for(int i = 0; i < number; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String op = stringTokenizer.nextToken();
            switch (op) {
                case "L":
                    if (listIterator.hasPrevious()) listIterator.previous();
                    break;
                case "D":
                    if (listIterator.hasNext()) listIterator.next();
                    break;
                case "B":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                case "P":
                    String put = stringTokenizer.nextToken();
                    listIterator.add(put.charAt(0));
                    break;
            }
        }
        for(char c : editor) stringBuilder.append(c);
        System.out.println(stringBuilder);
    }
}