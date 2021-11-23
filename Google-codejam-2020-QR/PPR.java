/* Parenting Partnering Returns https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
   첫 번째 입력은 Test case의 수 t 입니다. 그 후 입력 값으로 task의 개수를 두 번째 입력으로 받습니다.
   그 후 task의 시작 시간과 종료 시간을 입력으로 받은 후, 출력으로 각각 입력받은 시간의 순서대로
   이 task를 어떤 사람이 진행해야 하는지를 문자열로 반환합니다. 불가능하다면 "IMPOSSIBLE"을 반환합니다.
*/
import java.util.*;

import java.io.*;

public class PPR {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int check = 0;

        String[] answer = new String[t];

        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            answer[i] = "";

            boolean[] cameron = new boolean[1440];
            boolean[] jamie = new boolean[1440];

            String[] value = new String[n];

            for(int j = 0; j < n; j++){
                Integer si = in.nextInt();
                String s = String.format("%04d",si);
                Integer ei = in.nextInt();
                String e = String.format("%04d",ei);

                value[j] = s + "/" + e + "#" + String.format("%04d", j);
            }

            Arrays.sort(value);

            String[] sort = new String[n];

            for(int j = 0; j < n; j++){
                int s = Integer.parseInt(value[j].substring(0,value[j].indexOf("/")));
                int e = Integer.parseInt(value[j].substring(value[j].indexOf("/")+1,value[j].lastIndexOf("#")));


                sort[j] = value[j].substring(value[j].indexOf("#")+1);

                for (int k = s; k < e; k++) {
                    if (!cameron[k]) check++;
                    else {
                        check = 0;
                        break;
                    }
                }
                if (check == e - s) {
                    for (int k = s; k < e; k++) {
                        cameron[k] = true;
                    }
                    sort[j] = sort[j] + "C";
                    check = 0;
                } else {
                    for (int k = s; k < e; k++) {
                        if (!jamie[k]) check++;
                        else {
                            check = 0;
                            break;
                        }
                    }
                    if (check == e - s) {
                        for (int k = s; k < e; k++) {
                            jamie[k] = true;
                        }
                        sort[j] = sort[j] + "J";
                        check = 0;
                    } else sort[j] = "IMPOSSIBLE";
                }
            }
            Arrays.sort(sort);

            for (String s : sort) {
                if (s.equals("IMPOSSIBLE")) {
                    answer[i] = "IMPOSSIBLE";
                    break;
                } else if (s.contains("C")) answer[i] = answer[i] + "C";
                else if (s.contains("J")) answer[i] = answer[i] + "J";
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answer[i]);
        }
    }
}
