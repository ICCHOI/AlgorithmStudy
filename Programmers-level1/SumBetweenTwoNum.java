/* 두 정수 사이의 합 https://programmers.co.kr/learn/courses/30/lessons/12912
   두 정수 a, b를 입력받아 두 수 사이에 속한 모든 정수의 합을 반환 하시오.
*/
public class SumBetweenTwoNum {
    public long solution(int a, int b) {

        long answer = 0;

        if(a<b) for(int i = a; i < b+1; i++) answer = answer+i;

        else for(int j = b; j < a+1; j++) answer = answer+j;

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        SumBetweenTwoNum num = new SumBetweenTwoNum();
//        System.out.println(num.solution(5,3));
//    }
//}