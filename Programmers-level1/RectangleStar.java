/* 직사각형 별 찍기 https://programmers.co.kr/learn/courses/30/lessons/12969
   입력받은 문자 중 첫 번째를 가로 길이로, 두 번째를 세로 길이로 하는 직사각형 '*'를 출력하시오.
*/
import java.io.*;
import java.util.StringTokenizer;

class RectangleStar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        for(int i = 0; i<column; i++){
            for(int j = 0; j< row; j++) bw.write("*");
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
