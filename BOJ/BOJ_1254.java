/* 팰린드롬 만들기 https://www.acmicpc.net/problem/1254
   문자열을 입력받아 최소 길이의 팰린드롬으로 만들어 그 문자열의 길이를 반환하시오.
 */
import java.util.Scanner;

class BOJ_1254 {
    static boolean checkPalindrome (String palindrome) {
        for (int i = 0; i < palindrome.length()/2; i++){
            if(!(palindrome.charAt(i) == palindrome.charAt(palindrome.length() -1 - i))) return false;
        }
        return true;
    }

    static int findIndexOfPalindrome (String palindrome) {
        int index = 0;
        for (int i = (palindrome.length() + 1) / 2 - 1; i < palindrome.length() - 1; i++){
            if(palindrome.charAt(i) == palindrome.charAt(i + 1)) {
                index = i;
                int k = 1;
                while(i + 1 + k < palindrome.length()){
                    if(palindrome.charAt(i - k) == palindrome.charAt(i + 1 + k)) {
                        k++;
                    }
                    else {
                        index = 0;
                        break;
                    }
                }
                if (index != 0) return index - k + 1;
            }
            if(i < palindrome.length() - 2) {
                if (palindrome.charAt(i) == palindrome.charAt(i + 2)) {
                    index = i;
                    int k = 1;
                    while(i + 2 + k < palindrome.length()){
                        if(palindrome.charAt(i - k) == palindrome.charAt(i + 2 + k)) {
                            k++;
                        }
                        else {
                            index = 0;
                            break;
                        }
                    }
                    if (index != 0) return index - k + 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String palindrome = new Scanner(System.in).nextLine();
        int palLength = palindrome.length();

        if (!checkPalindrome(palindrome)) {
            if(findIndexOfPalindrome(palindrome) == 0) {
                palLength = palindrome.length() * 2 - 1;
            }
            else {
                palLength += findIndexOfPalindrome(palindrome);
            }
        }
        System.out.println(palLength);
    }
}