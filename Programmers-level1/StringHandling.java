// 문자열 다루기 https://programmers.co.kr/learn/courses/30/lessons/12918
// 문자열의 길이가 4 혹은 6이고 숫자로만 구성되어 있는지 확인하는 함수를 완성하시오.

class StringHandling {
    public boolean solution(String s) {
        byte[] ascii = s.getBytes();
        boolean answer = true;

        if( ( s.length() != 4 ) && ( s.length() != 6 )) answer = false;

        for(byte code : ascii) { if( (code<48) || (57<code) ) answer = false; }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        StringHandling handling = new StringHandling();
//        System.out.println(handling.solution("1234"));
//    }
//}
