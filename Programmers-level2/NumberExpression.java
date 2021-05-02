/* 숫자의 표현 https://programmers.co.kr/learn/courses/30/lessons/12924
   정수 n이 입력으로 주어질 때 n을 표현할 수 있는 연속된 자연수의 합의 갯수를 반환하시오.
 */
class NumberExpression {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1 + i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) break;
            }
            sum = 0;
        }

        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        NumberExpression solve = new NumberExpression();
//        System.out.println(solve.solution(15));
//    }
//}