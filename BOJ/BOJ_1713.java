/* 후보 추천하기 https://www.acmicpc.net/problem/1713
   특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 게시 되어야하며, 비어있는 틀이 없는 경우에는 현재까지 추천 횟수가 가장 적은 학생의 사진을 삭제하고,
   새롭게 추천받은 학생의 사진을 게시한다. 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
   현재 사진이 게시된 학생이 추천을 받은 경우에는 횟수만 증가시킨다. 사진이 삭제되는 경우에는 해당 학생의 추천 횟수는 0으로 바뀐다.
   사진틀의 개수 N 1 ≤ N ≤ 20) 총 추천 횟수(k <= 1000), 추천 학생 번호(1 <= n <= 100)가 빈 칸을 두고 순서대로 주어질 때,
   최종 게시된 후보의 학생 번호를 오름차순으로 출력하시오.
 */
import java.util.ArrayList;
import java.util.Scanner;

class BOJ_1713 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int k = scanner.nextInt();
        scanner.nextLine();

        Person[] people = new Person[101];
        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int num = scanner.nextInt();
            if (list.size() == n && people[num] == null) {
                people[list.get(n - 1).num] = null;
                list.remove(n - 1);
            }
            if (people[num] == null) {
                people[num] = new Person(num, 0, i);
                list.add(people[num]);
            } else {
                people[num].cnt++;
            }
            list.sort(Person::compareTo);
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) System.out.printf("%d ",i);
        }
    }
}

class Person implements Comparable<Person> {
    int num;
    int cnt;
    int idx;

    public Person(int num, int cnt, int idx) {
        this.num = num;
        this.cnt = cnt;
        this.idx = idx;
    }

    @Override
    public int compareTo(Person o) {
        int comp1 = Integer.compare(o.cnt, cnt);
        if (comp1 == 0) {
            return Integer.compare(o.idx, idx);
        }
        return comp1;
    }
}
