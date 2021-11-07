/* 약수의 개수와 덧셈 https://programmers.co.kr/learn/courses/30/lessons/77884
    left와 right까지의 모든 수들 중에 약수의 개수가 짝수인 수는 더하고 홀수인 수는 뺀 수를 반환하시오.
 */
class DivisorCntSum {
    public int getCount(int div) {
        int count = 0;
        for (int i = 1; i <= div; i++) if (div % i == 0) count += 1;
        return count;
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) answer += (getCount(i) % 2 == 0) ? i : -i;
        return answer;
    }
}
