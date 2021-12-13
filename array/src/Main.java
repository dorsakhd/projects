import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        System.out.println("enter a number to find");
        int find = in.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == find) {
                System.out.println(i + 1);
            }
        }
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= temp) {
                temp=array[i];
            }
        }
        int tedad=0;
        for (int i = 0; i <array.length-1 ; i++) {
            if (array[i]<array[i+1]){
                tedad++;
            }
        }
        System.out.println(tedad);

    }
}
