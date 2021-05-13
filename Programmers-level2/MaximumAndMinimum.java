/* 최댓값과 최솟값 https://programmers.co.kr/learn/courses/30/lessons/12939/
   문자열 s의 최솟값과 최댓값을 찾아 반환하시오.
 */

import java.util.Arrays;

class MaximumAndMinimum {
    public StringBuilder solution(String s) {
        String[] tokens = s.split(" ");

        int[] answer = new int[tokens.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(answer);

        int maximum = answer[0];
        int minimum = answer[0];

        for (int value : answer) {
            if (minimum > value) minimum = value;
            if (maximum < value) maximum = value;
        }

        return new StringBuilder().append(minimum).append(" ").append(maximum);
    }
}

