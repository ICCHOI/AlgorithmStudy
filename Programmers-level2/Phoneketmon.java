// 폰켓몬 https://programmers.co.kr/skill_checks/108343
// 길이 N의 배열의 서로 다른 요소들의 조합의 개수를 n/2와 같거나 작은 값 중 최대의 값으로 구성할 수 있는 방법의 개수를 반환하시오.

import java.util.ArrayList;
import java.util.Arrays;

class Phoneketmon {
    public int solution(int[] nums) {
        int take = nums.length/2;

        Arrays.sort(nums);

        ArrayList<Integer> pkmNum = new ArrayList<>();

        for(int i = 1; i<nums.length; i++){
            if( (nums[i-1]) != nums[i] ) pkmNum.add(nums[i-1]);
            if (i == nums.length-1) pkmNum.add(nums[i]);
        }

        int answer = (take > pkmNum.size() ) ? pkmNum.size() : take;
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        Phoneketmon pkm = new Phoneketmon();
//        int[] nums = {3,3,3,2,2,4};
//
//        System.out.println(pkm.solution(nums));
//    }
//}