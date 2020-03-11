// 수박수박수박수박수박수? https://programmers.co.kr/learn/courses/30/lessons/12922
// n의 값에 따라 "수박수박수.."와 같은 패턴을 유지하는 문자열을 반환하시오.

class Subak {
    public String solution(int n) {
        char su = '수';
        char bak = '박';
        String answer = "";

        for(int i = 1; i<=n; i++) {
            if ((i % 2) == 1) answer = answer + su;
            else answer = answer + bak;
        }

        return answer;
    }
}

class Main11{
    public static void main(String[] args) {
        Subak subak = new Subak();
        System.out.println(subak.solution(3));
    }
}
