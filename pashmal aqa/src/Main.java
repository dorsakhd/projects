import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int n=scanner.nextInt();
	int a=0;
	double k=scanner.nextDouble();
	double p=scanner.nextDouble();
	a= (int) (n*k*p);
        System.out.println(a);
    }
}
