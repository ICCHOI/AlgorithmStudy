/*  정수 제곱근 판별 https://programmers.co.kr/learn/courses/30/lessons/12934
    어떤 정수 n을 입력으로 받아 그 수가 양의 정수 x의 제곱근이면 x+1의 제곱을 반환, 아니면 -1을 반환하시오
*/
class CheckRoot {
    public long solution(long n) {

        if(Math.sqrt(n)%1 == 0){
            return (long) Math.pow((Math.sqrt(n)+1),2);
        }
        else return -1;

    }
}

//class Main{
//    public static void main(String[] args) {
//        CheckRoot check = new CheckRoot();
//        System.out.println(check.solution(144));
//    }
//}
