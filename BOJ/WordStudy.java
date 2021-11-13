/* 단어 공부 https://www.acmicpc.net/problem/1157
   알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
   단, 대문자와 소문자를 구분하지 않는다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WordStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine();
        int max = 0;
        int index = 0;
        boolean check = false;
        int[] alpha = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') alpha[word.charAt(i) - 97]++;
            else alpha[word.charAt(i) - 65]++;
        }
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                index = i;
                check = false;
            } else if (alpha[i] == max) check = true;
        }
        if (check) System.out.println('?');
        else System.out.println((char)(index + 'A'));
    }
}
