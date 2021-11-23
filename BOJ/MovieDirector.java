/* 영화감독 숌 https://www.acmicpc.net/problem/1436
   N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 숫자)이고 종말의 숫자는 666을 의미한다.
   N번째 종말의 영화의 숫자를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MovieDirector {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int count = 0;
        int find;
        for (find = 666; count < number; find++) {
            if (Integer.toString(find).contains("666")) count++;
        }
        System.out.println(find - 1);
    }
}
