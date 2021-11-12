/* 단어 정렬 https://www.acmicpc.net/problem/1181
   알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
   길이가 짧은 것부터 -> 길이가 같으면 사전 순으로 -> 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class WordSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine());
        String[] array = new String[length];
        for (int i = 0; i < length; i++) array[i] = bf.readLine();
        List<String> list = Arrays.asList(array);
        list.stream().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .distinct()
                .forEach(System.out::println);
    }
}