import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        double  a=0;
        double k=scanner.nextDouble();
        double s=scanner.nextDouble();
        a=n*k;
        if (s>=a){
            System.out.println("Kafie!");
        }else System.out.println("Na! yeki bayad bere sabzi bekhare");
    }
}
