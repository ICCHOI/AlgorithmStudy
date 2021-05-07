/* 위장 https://programmers.co.kr/learn/courses/30/lessons/42578
   스파이가 가진 의상이 담긴 배열 clothes가 주어질 때 [{종류, 이름]} 으로 되어 있는 의상의
   서로 다른 옷의 조합 수를 반환하시오.
 */
import java.util.HashMap;
import java.util.Map;

class Disguise {
        public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            } else map.put(clothe[1], 1);
        }

        if(map.size() == 1){
            answer = map.get(clothes[0][1]) + 1;
        }
        else{
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                answer *= entry.getValue()+1;
            }
        }

        return answer-1;
    }
}

//class Main {
//    public static void main(String[] args) {
//        Disguise disguise = new Disguise();
//        System.out.println(disguise.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
//        System.out.println(disguise.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
//    }
//}