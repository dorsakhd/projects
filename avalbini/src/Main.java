import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=0;
        int x;
        int s=255;
        for(int i=a+1;i<b;i++){
            c=0;

            for(int j=1;j<=i;j++){
                x=i%j;
                if(x==0){
                    c=c+1;
                }


            }
            if(s==255&&c==2){
                System.out.print(i);
                s=234576;

            }
            else if(c==2){
                System.out.print(","+i);
            }
        }
    }
}
