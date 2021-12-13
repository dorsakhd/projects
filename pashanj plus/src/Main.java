import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int array2DSize = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        Arrays.sort(array);
        n = removeDuplicates(array,n);

        for (int i = 1; i <n; i++) {
            array2DSize+=i;
        }

        int[][] arrayAns = new int[array2DSize][3];

        for (int i = 0, c = 0; i < n; i++) {
            for (int j = i; j < n - 1; j++, c++) {
                arrayAns[c][0] = array[i];
                arrayAns[c][1] = array[j + 1];
                arrayAns[c][2] = array[j + 1] - array[i];
            }
        }
        for (int i = 0; i < arrayAns.length; i++) {
            for (int j = 0; j < arrayAns.length - i - 1; j++) {
                if (arrayAns[j][2] > arrayAns[j + 1][2]) {
                    int[] temp = arrayAns[j];
                    arrayAns[j] = arrayAns[j + 1];
                    arrayAns[j + 1] = temp;
                }

            }
        }

        for (int[] arrayAn : arrayAns) {
            System.out.printf("[%d, %d]\n", arrayAn[0], arrayAn[1]);
        }


    }

    static int removeDuplicates(int array[], int n) {
        if (n == 1)
            return n;

        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] != array[i + 1])
                temp[j++] = array[i];
        }
        temp[j++] = array[n - 1];
        for (int i = 0; i < j; i++) {
            array[i] = temp[i];
        }

        return j;
    }
}