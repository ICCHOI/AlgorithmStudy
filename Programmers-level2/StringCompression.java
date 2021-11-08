/* 문자열 압축 https://programmers.co.kr/learn/courses/30/lessons/60057
   비손실 압축방법을 도입하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 표현할 수 있는 방법을 찾아
   가장 짧은 문자열의 길이를 반환하시오.
 */

class StringCompression {
    public int solution(String s) {
        int countWord = 1;
        StringBuilder sb = new StringBuilder();
        String compWord;
        int shortWord = s.length();

        for (int i = 1; i <= s.length() / 2; i++){
            for (int j = i; j <= s.length(); j += i){
                if (j + i <= s.length()) {
                    if (s.substring(j - i, j).equals(s.substring(j, j + i))) countWord++;
                    else if (countWord > 1) {
                        sb.append(countWord);
                        sb.append(s, j - i, j);
                        countWord = 1;
                    } else if (countWord == 1) sb.append(s, j - i, j);
                }
                else {
                    if (countWord > 1) {
                        sb.append(countWord);
                        sb.append(s.substring(j - i));
                        countWord = 1;
                    }
                    else sb.append(s.substring(j - i));
                }
            }
            compWord = sb.toString();
            System.out.println(compWord);
            shortWord = Math.min(compWord.length(), shortWord);
            sb.setLength(0);
        }
        return shortWord;
    }
}
