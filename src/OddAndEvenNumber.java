class OddAndEvenNumber {
    public String solution(int num) {
        String answer;

        if( num < 0 ) num = num * -1;

        if ( (num % 2) == 1 ) return answer = "Odd";
        else return answer = "Even";

    }
}

class Main8 {
    public static void main(String[] args) {
        OddAndEvenNumber number = new OddAndEvenNumber();
        System.out.println(number.solution(-1));
    }
}
