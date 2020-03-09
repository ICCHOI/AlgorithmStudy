// 2016년 https://programmers.co.kr/learn/courses/30/lessons/12901
//  두 정수 a, b를 입력받아 a월 b일이 무슨 요일인지를 반환하는 함수를 작성하시오.

public class Year2016 {
    public String solution(int a, int b) {
        MonthToDay month = new MonthToDay();
        String answer = "";

        b = (month.change(a))+b;

        switch (b%7){
            case 0:
                answer = "THU";
                break;
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
        }
        return answer;
    }
}

class MonthToDay {
    public int change(int a){
        int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;

        for(int i = 0; i<a-1; i++){
            day = month[i] + day;
        }
        
        return day;
    }
}

class Main6 {
    public static void main(String[] args) {
        Year2016 year = new Year2016();
        System.out.println(year.solution(2,45));
    }
}
