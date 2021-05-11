/* 다리를 지나는 트럭 https://programmers.co.kr/learn/courses/30/lessons/42583/solution_groups?language=java
   다리의 길이와 다리가 견딜 수 있는 무게, 그리고 다리를 지나는 트럭의 무게를 담은 배열이 주어질 떄,
   트럭이 다리를 건너는데 걸리는 시간을 반환하시오.
 */
import java.util.ArrayList;

class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;

        ArrayList<Integer> bridge = new ArrayList<>(bridge_length);

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        for (int i = 0; i < truck_weights.length; i++) {
            if (bridge.size() == bridge_length) {
                bridge_weight = bridge_weight - bridge.get(0);
                bridge.remove(0);
            }

            if (bridge_weight + truck_weights[i] > weight) {
                answer++;
                bridge.add(0);
                i--;
            } else {
                bridge.add(truck_weights[i]);
                bridge_weight += truck_weights[i];
            }

        }

        return answer + truck_weights.length + bridge_length;
    }
}

//class Main {
//    public static void main(String[] args) {
//        Solution solve = new Solution();
//        System.out.println(solve.solution(2, 10, new int[]{7, 4, 5, 6}));
//        System.out.println(solve.solution(100, 100, new int[]{10}));
//        System.out.println(solve.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
//        System.out.println(solve.solution(10, 10, new int[]{2, 3, 5, 9}));
//        System.out.println(solve.solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}));
//    }
//}
