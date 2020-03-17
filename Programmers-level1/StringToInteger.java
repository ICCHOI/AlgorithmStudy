/* 문자열을 정수로 바꾸기 https://programmers.co.kr/learn/courses/30/lessons/12925
   입력받은 1-5자리 문자열을 맨 앞의 +, - 기호에 따라 정수로 바꾸시오.
*/
class StringToInteger {
    public static int solution(String s) {
        int answer = 0;

        if(s.charAt(0)=='-'){
            s = s.substring(1,s.length());
            answer = Integer.parseInt(s)*-1;
        }
        else if(s.charAt(0)=='+'){
            s = s.substring(1,s.length());
            answer = Integer.parseInt(s);
        }
        else answer = Integer.parseInt(s);

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        StringToInteger soul = new StringToInteger();
//        String s = "-1";
//        System.out.println(StringToInteger.solution(s));
//    }
//}

