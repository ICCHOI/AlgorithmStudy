/* 가운데 글자 가져오기 https://programmers.co.kr/learn/courses/30/lessons/12903
   문자열 s를 입력받아 s의 가운데 글자를 반환하시오.
*/
public class TakeMiddleLetters {
    public String solution(String s) {
        String answer;

        if((s.length()%2)==1){
            answer = s.substring((s.length()-1)/2,((s.length()-1)/2)+1);
        }
        else{
            answer = s.substring(((s.length()-1)/2),((s.length()-1)/2)+2);
        }
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        TakeMiddleLetters letters = new TakeMiddleLetters();
//        System.out.println(letters.solution("qwer"));
//    }
//}