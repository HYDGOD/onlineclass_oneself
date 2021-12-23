package package_001;

/**
 * 输出1000-2000所有闰年
 */
//注意输出结果return值和LeapYear函数输出内容都输出
public class Test005 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(leapYear());
    }

    /**
     * LeapYear
     * @return
     */
    public static int leapYear() {
        int num = 0;
        for (int i = 1000; i <= 2000; i++) {
            if(i < 1582 && i % 4 == 0){
                num++;
                System.out.print(i + " ");
            }else if(i >= 1582 && i % 4 == 0 ){
                if(i % 100 == 0 ) {
                    if (i % 400 == 0) {
                        System.out.print(i + " ");
                        num++;
                    }
                }else {
                    System.out.print(i + " ");
                    num++;
                }
            }
        }
        return num;
    }
}
