package package_001;

/**
 * 1-100出现多少个数字9
 */
public class Test004 {
    public static void main(String[] args) {
        System.out.println(print());
    }
    public static int print() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 9 )
                count++;
            if (i / 10 == 9 )
                count++;
        }
        return count;
    }
}
