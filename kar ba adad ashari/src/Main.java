import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        float a;
        float max=0;
        float min=1000000;
        float avg=0;
        float sum=0;
        a=scanner.nextFloat();
        sum+=a;
        max=a;
        min=a;
        for (int i = 1; i <n ; i++) {
            a=scanner.nextFloat();
            if (a>=max){
                max=a;
            }
            if (a<=min){
              min=a;
            }
            sum=sum+a;
        }
        avg=sum/n;
        System.out.printf("Max: %.3f\nMin: %.3f\nAvg: %.3f",max,min,avg);
    }
}
