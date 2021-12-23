package package_001;

import java.util.Scanner;

/**
 * 汉诺塔递归实现
 */
//注意“分治”想法，在干成这一步的时候上一步先干成什么,理解一下static静态变量后面还会用到
public class Test006 {
    public static int count = 0;
    /**
     *main
     * @param args
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        hanoi(n , "A" , "B" , "C");
    }
    /**
     * hanoi
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int n , String A , String B , String C) {
        if( n == 1){
            System.out.println("步骤:" + (++count) + A + "-->" + C);
        }else{
            hanoi(n-1 , A , C , B);
            System.out.println("步骤:" + (++count) + A + "-->" + C);
            hanoi(n-1 , B ,A , C);
        }
    }
}
