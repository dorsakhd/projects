import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int a;
        int n2=n;
        int n3=n2;
        int sum=0;
        int tedad;
        int tedad2=1;
        while (n > 0) {
            a= n % 10;
            sum = sum + a;
            n = n / 10;
        }
        int i;
      while(true) {
          n3++;
          tedad=0;
            for (i = 1; i <n3 ; i++) {
                if(n3%i==0)
                    tedad++;
            if(tedad==2 && tedad2==sum) {
                System.out.println(n3);
                break;
            }
            else if(tedad==2)
                tedad2++;
        }

    }

    }

