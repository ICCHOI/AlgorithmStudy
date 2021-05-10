/* 프린터 https://programmers.co.kr/learn/courses/30/lessons/42587
   중요도가 높은 순서대로 인쇄하며, 인쇄 대기 목록의 가장 앞에 있는 문서를 뽑아 중요도가 낮으면 인쇄 대기 목록의 맨 뒤로 이동시킬 때,
   인쇄 목록의 중요도가 담긴 배열 priorities와 내가 인쇄를 요청한 문서의 위치가 담긴 location을 받아,
   내가 요청한 문서가 몇번 째로 인쇄되는지 반환하시오
 */
import java.util.ArrayList;
import java.util.Arrays;

class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Print temp;
        int check = 0;

        ArrayList<Print> arrayList = new ArrayList<>();

        int[] array = new int[priorities.length];

        System.arraycopy(priorities, 0, array, 0, priorities.length);

        Arrays.sort(array);

        for (int i = 0; i < priorities.length; i++) {
            arrayList.add(new Print(i, priorities[i]));
        }

        for (int i = 0; i < array.length; i++) {
            if (array[array.length - 1 - i] != arrayList.get(check).priority) {
                temp = arrayList.get(check);
                arrayList.remove(check);
                arrayList.add(temp);
                i--;
            } else {
                check++;
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).index == location) answer = i + 1;
        }

        return answer;
    }
}

class Print implements Comparable<Print> {
    int index;
    int priority;

    public Print(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    @Override
    public int compareTo(Print comp) {
        return this.priority < comp.priority ? 1 : -1;
    }
}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{2, 1, 3, 2}, 2));
//        System.out.println(new Solution().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
//    }
//}
