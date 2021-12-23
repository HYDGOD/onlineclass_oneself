package package_002;

import java.util.Arrays;

//hanoi独立第一次测试，提问1：h15(为什么不能换成//hanoi(n , A , B , C);)
public class Test007 {
    public static void main(String[] args) {

        int n = 3;
        hanoi(n , 'A' , 'B' , 'C');
    }
    public static void hanoi(int n , char A, char B , char C){

        if (n == 1)
            System.out.println(A + "--->" + C);
        else{
            hanoi(n - 1 , A , C , B);
            //hanoi(n , A , B , C);
            System.out.println(A + "--->" + C);
            hanoi(n-1 , B , A , C);
        }

    }
}
