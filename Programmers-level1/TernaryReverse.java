/* 3진법 뒤집기 https://programmers.co.kr/learn/courses/30/lessons/68935
   정수 n을 입력받아 3진법으로 변환 후, 그 3진법을 앞뒤 반전 시킨 후,
   다시 10진법으로 변환하여 반환하시오.
 */
class TernaryReverse {
    public int solution(int n) {
        int answer = 0;
        String ternary = "";

        while(1<=n){
            ternary += String.valueOf(n%3);
            n = n/3;
        }

        for(int i = 0; i<ternary.length(); i++){
            answer += Math.pow(3,i) * Character.getNumericValue(ternary.charAt(ternary.length()-i-1));
        }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        TernaryReverse tr = new TernaryReverse();
//        System.out.println(tr.solution(125));
//    }
//}
