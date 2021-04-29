/* 소수 구하기 https://programmers.co.kr/learn/courses/30/lessons/12977
   int형 배열 nums를 입력으로 받아 nums의 서로 다른 inde 3개를 더했을 때
   소수가 되는 경우의 수를 찾아 반환하시오.
 */

class MakePrime {
    public int solution(int[] nums) {
        int answer = 0;
        int[] sum = new int[2998-6];
        boolean[] primes = new boolean[2998-6];

        for(int i = 0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    sum[nums[i]+nums[j]+nums[k]-6] = sum[nums[i]+nums[j]+nums[k]-6]+1;
                }
            }
        }

        int mini = 6;
        boolean isPrime;
        // 6 - 2997 사이의 소수
        while(mini <= 2997){
            isPrime = true;

            for(int n = 2; n<mini; n++){
                if (mini%n == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime == true) primes[mini-6] = true;
            mini++;
        }

        for(int i = 0; i<sum.length; i++){
            if(sum[i] > 0 && primes[i] == true) {
                answer = answer + sum[i]*1;
            };
        }

        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        MakePrime prime = new MakePrime();
//        System.out.println(prime.solution(new int[]{1,2,7,6,4}));
//    }
//}
