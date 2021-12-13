import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score;
        int a = 0;
        int b = 0;
        int c = 0;
        int sum=0;
        int avrage;
        for (int i = 1; i <=10; i++) {
            score = scanner.nextInt();

            if (score < 60) {
                a++;
            }
            if (score >= 60 && score < 90) {
                b++;
            }
            if (score >= 90 && score <= 100) {
                c++;
            }
            sum=sum+score;
        }
        avrage=sum/10;
        System.out.printf("1 ta 59: %s\n", a);
        System.out.printf("60 ta 89: %s\n", b);
        System.out.printf("90 ta 100: %s\n", c);
        System.out.printf("miangin: %s",avrage);
    }
}
