import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int base= in.nextInt();
        int base2= in.nextInt();
        int power=1;
        int e=0;
        int f;
        int[] array=new int[50];
        int counter=0;
        while (a!=0){
            f=a%10;
            a=a/10;
            e+=f*power;
            power=power*base;
        }
        while(e!=0){
            f=e%base2;
            e/=base2;
            array[counter]=f;
            counter++;
        }
        f=0;
        for(int i=counter-1;i>=0;i--){
            f=f*10;
            f+=array[i];

        }
        e=0;
        int z=f;
        while(z!=0){
            e*=10;
            e+=z%10;
            z/=10;


        }
        if(e==f)  {
            System.out.print("YES");
        }
        else {
            System.out.print("NO");
        }
    }
}
