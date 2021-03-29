/* 문자열 내 마음대로 정렬하기 https://programmers.co.kr/learn/courses/30/lessons/12915
   문자열의 인덱스 n번째 글자를 기준으로 문자열을 오름차순 정렬하시오.
*/
import java.util.Arrays;

public class StringSortingAIW {
    public String[] solution(String[] strings, int n) {
        String temp;

        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length - i - 1; j++) {
                if (strings[j].charAt(n) > strings[j + 1].charAt(n)) {
                    temp = strings[j + 1];
                    strings[j + 1] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }
}

//class Main {
//    public static void main(String[] args) {
//        StringSortingAIW sort = new StringSortingAIW();
//        System.out.println(Arrays.toString(sort.solution(new String[]{"sun", "bed", "car"}, 2)));
//    }
//}
