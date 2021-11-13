/* JadenCase 문자열 만들기 https://programmers.co.kr/learn/courses/30/lessons/12951
   단어의 첫 문자가 대문자이고 나머지 문자는 소문자인 JadenCase 문자열을 반환하시오.
   각 단어들은 문자열의 시작/끝, 공백(' ')으로 구분합니다.
 */
class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean check = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                check = true;
                sb.append(' ');
            }
            else if (check) {
                check = false;
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') sb.append((char)(s.charAt(i) - 32));
                else sb.append(s.charAt(i));
            }
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i) + 32));
            }
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}