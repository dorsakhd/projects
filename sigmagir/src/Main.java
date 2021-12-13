import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int temp;
        if((n<0)||(m>10))
            return;
        for (int i = -10; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(j == 0)
                    continue;
                temp = (i+j)*(i+j)*(i+j);
                sum += temp /(j*j);
            }
        }
        System.out.println(sum);
    }
}
