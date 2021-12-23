package package_001;

import java.util.Scanner;

/**
 *输出一个整数的每一位，如：123的每一位是1，2，3
 */
public class Test002 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int num2 = num;
        int count = 0;
        while(num > 0){
            num /= 10;
            count++;
        }
        int num3 = count;
        int[] array = new int[num3];
        for (int i = array.length ; i > 0; i--) {
            array[i - 1] = num2 % 10;
        }
        System.out.println(array[1]);


    }

}
