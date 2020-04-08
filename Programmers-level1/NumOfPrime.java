/* 소수 찾기 https://programmers.co.kr/learn/courses/30/lessons/12921
   1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하시오.
 */
public class NumOfPrime {
    public int solution(int n){
       int count = 0;

       boolean[] check = new boolean[n+1];

       for(int i = 2; i<=n; ++i)
           check[i] = true;

       for(int i = 2; i<=n; ++i){

           if(check[i] == true) {
               for (int j = i*2; j <= n; j+=i) {
                    check[j] = false;
               }
               ++count;
           }

       }
        return count;
    }
}

//class Main{
//    public static void main(String[] args) {
//        System.out.println(new NumOfPrime().solution(10));
//    }
//}

