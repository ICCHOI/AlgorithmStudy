/* 짝수와 홀수 https://programmers.co.kr/learn/courses/30/lessons/12937
   정수가 짝수 일 경우 Odd 홀수 일 경우 Even을 반환합니다.
*/
class OddAndEvenNumber {
    public String solution(int num) {
        String answer;

        if( num < 0 ) num = num * -1;

        if ( (num % 2) == 1 ) return answer = "Odd";
        else return answer = "Even";

    }
}

//class Main {
//    public static void main(String[] args) {
//        OddAndEvenNumber number = new OddAndEvenNumber();
//        System.out.println(number.solution(-1));
//    }
//}
