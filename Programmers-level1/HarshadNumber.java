/* 하샤드 수 https://programmers.co.kr/learn/courses/30/lessons/12947
    parameter x의 각 자릿수의 합이 x로 나누어 떨어짐을 확인하여 boolean 값을 반환하시오.
 */
class HarshadNumber {
    public boolean solution(int x) {
        return x % sumDigit(x) == 0;
    }

    public int sumDigit(int n) {
        if(n<1) return n;
        return (n%10)+sumDigit(n/10);
    }
}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(new HarshadNumber().solution(12));
//    }
//}
