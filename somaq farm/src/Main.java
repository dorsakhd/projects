import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
                n = i;

            }
        }
        if (checkMax(n,array)){
            System.out.println("Yes");
        }else System.out.println("No");
    }
    public static boolean checkMax(int n,int[] array) {
        for (int i = 0; i < n; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        for (int i = n; i < array.length-1; i++) {
            if (array[i + 1] > array[i]) {
                return false;
            }
        }return true;

    }
}
