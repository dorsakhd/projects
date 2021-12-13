import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int b=scanner.nextInt();
        int r;
        String k="";
        while (n!=0){
           r=n%b;
            if (r>=10){
                r+=55;
                k=((char)r)+k;
                n=n/b;
                continue;
            }
           k=r+k;
           n=n/b;
        }
        System.out.println(k);
    }
}
