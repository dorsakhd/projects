import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=0;
        String string=scanner.next();
        for (int i = 0; i <string.length() ; i++) {
            char ch = string.charAt(i);
            a=string.charAt(i)-48;
            System.out.print(ch+": ");
            for (int j = 0; j <a; j++) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
