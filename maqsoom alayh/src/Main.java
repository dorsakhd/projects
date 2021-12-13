import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        int tedad=0;
        Scanner intput = new Scanner(System.in);
        n = intput.nextInt();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                tedad++;
            }
        }
        System.out. println(tedad);
    }
}
