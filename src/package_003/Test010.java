package package_003;

public class Test010 {
    public static void main(String[] args) {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(avg(array));

    }
    public static double avg(int[] array){
        double sum = 0;
        for (int x: array) {
            sum += x;
        }
        return sum / array.length;
    }
}
