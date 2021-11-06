/* 가장 큰 수 https://programmers.co.kr/learn/courses/30/lessons/42746
   0 이상, 1000이하의 양의 정수가 담긴 numbers 배열이 주어졌을 때, 각 배열의 원소를 이어 붙여
   만들 수 있는 가장 큰 수를 반환하시오.
 */
import java.util.Arrays;

class BiggestNum{
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        for (String s : arr) answer.append(s);

        if (answer.charAt(0) == '0') return "0";

        return answer.toString();
    }
}
