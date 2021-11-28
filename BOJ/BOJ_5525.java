/* IOIOI https://www.acmicpc.net/problem/5525
   (I)(OI)+ 패턴의 반복 횟수가 첫 번째에 주어지고, 두 번째 줄에 문자열의 길이, 마지막 줄에 문자열이 주어질 때, 패턴이 일치하는 횟수를 반환하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BOJ_5525{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        String inputString = bufferedReader.readLine();
        int count = 0;

        Pattern p = Pattern.compile("(I)(OI)+");
        Matcher m = p.matcher(inputString);

        while(m.find()) {
            if(((m.group().length() - 3) / 2) + 2 >= targetNum) count += ((m.group().length() - 3) / 2) + 2 - targetNum;
        }

        System.out.println(count);
    }
}