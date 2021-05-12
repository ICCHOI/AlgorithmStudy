/* 기능개발 https://programmers.co.kr/learn/courses/30/lessons/42586
   작업의 진행 상황이 담긴 배열 progresses와 작업의 속도가 담긴 speeds가 주어 질 때,
   작업이 진행이 완료가 된 후(progress == 100)의 각 배포 한 번 당 몇 개의 기능이 배포 되는지를 반환하시오. (단 배포는 하루에 한 번 가능함)
 */
class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] distribution = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                distribution[i]++;
            }
        }

        int[] answer = new int[getLength(distribution[0], distribution)];

        return getAnswer(distribution[0], distribution, answer);
    }

    public int getLength(int indexFirst, int[] distribution) {
        int length = 1;

        for (int speed : distribution) {
            if (indexFirst < speed) {
                indexFirst = speed;
                length++;
            }
        }
        return length;
    }

    public int[] getAnswer(int indexFirst, int[] distribution, int[] answer) {
        int index = 0;

        for (int speed : distribution) {
            if (indexFirst < speed) {
                index++;
                indexFirst = speed;
            }
            answer[index]++;
        }

        return answer;
    }
}


//class Main {
//    public static void main(String[] args) {
//        FunctionDevelop develop = new FunctionDevelop();
//        System.out.println(Arrays.toString(develop.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
//        System.out.println(Arrays.toString(develop.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(develop.solution(new int[]{99, 98, 97, 96, 95, 94}, new int[]{1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(develop.solution(new int[]{99, 98, 97, 96, 95, 94}, new int[]{1, 100, 100, 1, 1, 1})));
//    }
//}
