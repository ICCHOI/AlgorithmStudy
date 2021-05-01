class NumberOf124World {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n>0){
            int less = n%3;
            int num = n/3;

            if (less > 0) answer.insert(0, less);
            else{
                num--;
                answer.insert(0, "4");
            }
            n = num;
        }

        return answer.toString();
    }
}

//class Main{
//    public static void main(String[] args) {
//        NumberOf124World world = new NumberOf124World();
//        world.solution(1);
//        world.solution(2);
//        world.solution(3);
//        world.solution(4);
//        world.solution(5);
//        world.solution(6);
//        world.solution(7);
//        world.solution(8);
//        world.solution(9);
//        world.solution(10);
//    }
//}

