import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        char char1 = '=';
        int count = 0;
        for (int i = 0; i <string.length(); i++) {
            if (string.charAt(i)==char1) {
                count++;
            }
        }
        for (int i = 0; i <count ; i++) {
            int a=string.indexOf("=");
            string=charRemoveAt(string,a);
        }
        System.out.println(string);
    }
    public static String charRemoveAt(String str, int p ) {
        if (p!=0)
        return str.substring(0,p-1) + str.substring(p + 1);
        else return str.substring(p+1);
    }
}
