package package_003;

/**
 * 2021/12/23
 */

import java.util.Scanner;

public class Test009 {
    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println(addOneToTen(10));
    }


    /**
     * 递归实现各个位置数字之和
     * 好好理解一下想法当已知这个数的个位时，只要递归出其他位即可
     * @param n
     * @return
     */
    public static int numbersSum(int n){
        if(n < 10)
            return n;
        return n % 10 + numbersSum(n / 10);
    }

    /**
     * 递归练习1~10相加
     * @param n
     * @return
     */
    public static int addOneToTen(int n){
        if(n == 1)
            return n;
        return n + addOneToTen(n - 1);
    }

    /**
     * 求两个正整数最大公约数（欧几里得算法）
     * maxDivisor
     * @param a
     * @param b
     * @return
     */
    public static int maxDivisor(int a , int b){
       int max = a > b ? a : b;
       int min = a < b ? a : b;
        int i = max % min;
        while(i != 0){
            max = min;
            min = i;
            i = max % min;
        }
        return min;
    }

    /**
     *方法重载两整数和与三小数和
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a , int b){
        return a + b;
    }
    public static double sum(double a , double b , double c){
        return a + b + c;
    }

    /**
     * 方法重载调用求出两个数和三个数的最大值
     * @param a
     * @param b
     * @return
     */
    public static double compareSize(double a , double b){
        return a > b ? a : b;
    }
    public static double compareSize(double a , double b , double c){
        return compareSize(compareSize(a , b) , c);
    }

    /**
     * 递归求n的阶乘递归调用
     * @param n
     * @return
     */
    public static int factor(int n){
        if (n == 1)
            return n;
        return n * factor(n-1);
    }


}
