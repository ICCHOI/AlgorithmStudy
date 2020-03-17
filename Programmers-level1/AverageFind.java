/* 평균 구하기 https://programmers.co.kr/learn/courses/30/lessons/12944
   배열의 평균 값을 반환하시오.
*/
class AverageFind {
    public double solution(int[] arr) {
        double answer = 0;

        for(int i : arr) answer = i + answer;

        return answer/arr.length;
    }
}

//class Main{
//    public static void main(String[] args) {
//        AverageFind find = new AverageFind();
//        int[] arr = {1,2,3,4};
//
//        System.out.println(find.solution(arr));
//
//    }
//}
