import java.util.Arrays;

class GCDandLCM {
    public int[] solution(int n, int m) {
        int big, small, less, lcm;
        int[] answer = new int[2];

        if(n>m){
            big = n;
            small = m;
        }
        else {
            big = m;
            small = n;
        }

        lcm = big * small;

        while(big % small != 0){
            less = big % small;
            big = small;
            small = less;
        }
        // GCD = small = gcd
        // LCM = big * small / GCD

        answer[0] = small;
        answer[1] = lcm / small;

        return answer;
    }
}

class main{
    public static void main(String[] args) {
        GCDandLCM find = new GCDandLCM();
        System.out.println(1071%1029);
        System.out.println(Arrays.toString(find.solution(1071,1029)));
    }
}
