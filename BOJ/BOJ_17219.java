/* 비밀번호 찾기 https://www.acmicpc.net/problem/17219
   사이트 주소와 비밀번호가 N줄에 걸쳐 입력되고 그 후 M줄에 걸쳐 사이트 주소가 입력 됨. M줄의 사이트의 각 비밀번호를 줄 마다 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int siteNumber = Integer.parseInt(stringTokenizer.nextToken());
        int findNumber = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <siteNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String site = stringTokenizer.nextToken();
            String password = stringTokenizer.nextToken();
            hashMap.put(site, password);
        }

        for (int i = 0; i < findNumber; i++) {
            String toFind = bufferedReader.readLine();
            stringBuilder.append(hashMap.get(toFind)).append('\n');
        }

        System.out.print(stringBuilder);
    }
}
