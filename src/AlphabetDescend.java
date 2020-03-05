// 문자열 내림차순으로 배치하기 https://programmers.co.kr/learn/courses/30/lessons/12917
//문자열로 입력받은 알파벳을 내림차순으로 정렬함.

import java.util.Arrays;

class AlphabetDescend {
    public String solution(String s) {

        byte[] bytes = new byte[s.length()];

        for(int i = 0; i<bytes.length; i++){
            bytes[i]=(byte)s.charAt(i);
        }

        Arrays.sort(bytes);

        byte[] reverse = new byte[bytes.length];

        for(int i = 0; i<bytes.length; i++){
               reverse[i] = bytes[bytes.length-1-i];
        }

        String answer = new String(reverse);
        return answer;
    }
}

class Main5{
    public static void main(String[] args) {
        AlphabetDescend solution = new AlphabetDescend();
        System.out.println(solution.solution("Zbcdefg"));
    }
}