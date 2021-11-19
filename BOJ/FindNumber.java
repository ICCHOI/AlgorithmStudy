/* 수 찾기 https://www.acmicpc.net/problem/1920
   N개의 정수들이 M개의 정수들 안에 존재하는지 알아내는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class FindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<>();
        int num1 = Integer.parseInt(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        for (int i = 0; i < num1; i++) hashSet.add(Integer.parseInt(stringTokenizer.nextToken()));
        int num2 = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < num2; i++) System.out.println(hashSet.contains(Integer.parseInt(st.nextToken())) ? 1 : 0);
    }
}
