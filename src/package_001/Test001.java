package package_001;
/**
 * 判断密码，注意".hasNext()"和".equals"
 */

import java.util.Scanner;

public class Test001 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int count = 1;
        String password = "wjhyd521";
        Scanner scn = new Scanner(System.in);
        System.out.println("请输入密码");
        while(scn.hasNext()){
            String str = scn.next();
            if (count == 3){
                System.out.println("超三次了好兄弟，收手吧");
                break;
            }
            if(password.equals(str)){
                System.out.println("密码正确，登陆成功");
                break;
            }
            else{
                System.out.println("输错了，再来一次吧");
                count++;
            }
        }
    }
}
