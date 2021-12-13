import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int k = scanner.nextInt();
        int tedad ;
        for (int i = 0; true; i++) {
            sum = sum + i;
            tedad=0;
            for (int j = 1; j <= sum; j++) {
                if (sum % j == 0) {
                    tedad++;
                }
                    }if (tedad >= k) {
                System.out.println(sum);
                break;
                }
            }
        }
    }



