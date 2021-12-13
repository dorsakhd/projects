import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        long bmm;
        long kmm;
        if (m > n)
            bmm = m;
        else
            bmm = n;

        while ((m % bmm != 0) || (n % bmm != 0)) {
            bmm--;
        }
        kmm=(m*n)/bmm;
        System.out.printf("%s\t%s",bmm,kmm);
    }
    }

