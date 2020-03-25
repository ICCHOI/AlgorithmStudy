/* 자릿수 더하기 https://programmers.co.kr/learn/courses/30/lessons/12931
   입력받은 값의 자릿수의 합을 구하여 반환하시오.
 */
class SumDigits  {
    public int solution(int n) {
        if(n<1) return n;
        return (n%10)+solution(n/10);
    }
}

//class Main{
//    public static void main(String[] args) {
//        SumDigits digits = new SumDigits();
//        System.out.println(digits.solution(30100204));
//    }
//}