/* 나이순 정렬 https://www.acmicpc.net/problem/10814
   회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name, i));
        }
        list.stream().sorted(Comparator.comparing(Member::getAge).thenComparing(Member::getIndex))
                .forEach(s -> System.out.printf("%s", s.toPrint()));
    }
}

class Member {
    int age;
    String name;
    int index;

    public int getAge() {
        return age;
    }

    public int getIndex() {
        return index;
    }

    public String toPrint() {
        return age + " " + name + "\n";
    }

    public Member(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}