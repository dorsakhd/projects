import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextInt();
        double k = in.nextInt();
        double x = 0;
        for (int i = 0; i < k; i++) {
            if (k != 0) {
                n = n / 2;
                x=n;
            }
        }
        if (n < 0 && (n % 1) != 0) {
            System.out.println((int) x - 1);
        }else
            System.out.println((int)x);

    }
}
