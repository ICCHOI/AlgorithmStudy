/* 전화번호 목록 https://programmers.co.kr/learn/courses/30/lessons/42577
   전화번호 목록이 담긴 phone_book이 주어질 때
   어떤 한 번호가 다른 배열의 요소들의 접두어가 되는 경우의 수를 찾아 boolean으로 반환하시오
 */
import java.util.Arrays;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        L1:
        for (int i = 0; i < phone_book.length; i++) {
            if (i == phone_book.length - 1) break;

            if (phone_book[i + 1].contains(phone_book[i])) {

                for (int j = 0; j < phone_book[i].length(); j++) {
                    if (phone_book[i].charAt(j) != phone_book[i + 1].charAt(j)) break;

                    if (j == phone_book[i].length() - 1) {
                        answer = false;
                        break L1;
                    }
                }
            }
        }
        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        PhoneBook book = new PhoneBook();
//        System.out.println(book.solution(new String[]{"119", "97674223", "1195524421"}));
//        System.out.println(book.solution(new String[]{"123","456","789"}));
//        System.out.println(book.solution(new String[]{"12", "123", "1235", "567", "88"}));
//    }
//}