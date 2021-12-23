package package_001;

/**
 * foreach测试
 */
public class Test003 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int x : arr) {
            x = 10;
            System.out.println(x);
        }
    }
}
