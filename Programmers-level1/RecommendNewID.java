/* 신규 아이디 추천 https://prorammers.co.kr/learn/courses/30/lessons/72410
   신규 아이디 문자열 new_id를 입력 값으로 받아, 규칙에 맞는 문자열 아이디 answer를 반환하시오.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RecommendNewID {
    public String solution(String new_id) {
        String matcher = "";
        String answer = "";

        new_id = new_id.toLowerCase();

        Pattern pattern = Pattern.compile("([a-z0-9-_.])*");
        Matcher m = pattern.matcher(new_id);

        while (m.find()) matcher = matcher + m.group();

        for (int i = 0; i < matcher.length(); i++) {

            if (i != matcher.length()-1 && matcher.charAt(i) == '.' && matcher.charAt(i + 1) == '.') {

            } else {
                answer = answer + matcher.charAt(i);
            }
        }
      // . .. ...
        answer = getDot(answer);

        if (answer.length() == 0) answer = "a";

        if (answer.length() > 15) answer = answer.substring(0, 15);

        answer = getDot(answer);

        while (answer.length() < 3) answer = answer + answer.charAt(answer.length() - 1);

        return answer;
    }

    private String getDot(String answer) {
        if (answer.length() != 0 && answer.charAt(0) == '.') {
            if(answer.length() == 1) answer = "";
            else answer = answer.substring(1);
        }

        if (answer.length() != 0 && answer.charAt(answer.length()-1) == '.') {
            if(answer.length() == 1) answer = "";
            else answer = answer.substring(0, answer.length() - 1);
        }
        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        RecommendNewID newID = new RecommendNewID();
//        System.out.println(newID.solution("...!@BaT#*..y.abcdefghijklm"));
//        System.out.println(newID.solution("z-+.^."));
//        System.out.println(newID.solution("=.="));
//        System.out.println(newID.solution("123_.def"));
//        System.out.println(newID.solution("abcdefghijklmn.p"));
//    }
//}