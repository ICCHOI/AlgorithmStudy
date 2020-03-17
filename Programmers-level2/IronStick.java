/* 쇠막대기 https://programmers.co.kr/learn/courses/30/lessons/42585
   입력으로 받은 문자열이 matching 될 때 stack에 남아 있는 문자열의 개수를 더한 값을 return 하시오. ( 단 연속으로 매칭되면 개수 대신 +1 )
*/
class IronStick {
    public int solution(String arrangement) {
        int answer = 0;
        int count = 0;

        byte[] makdaegi = new byte[arrangement.length()];

        for(int i = 0; i<arrangement.length(); i++) makdaegi[i] = (byte)arrangement.charAt(i);

        for(int i = 0; i<makdaegi.length; i++){

            if ( makdaegi[i] == 40 ) count ++; // 40 = (, 41 = )
            else {
                count --;
                if( (makdaegi[i-1]) != 41) answer = answer + count;
                else answer = answer + 1;
            }
        }
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        IronStick stick = new IronStick();
//        System.out.println(stick.solution("()(((()())(())()))(())"));
//    }
//}


