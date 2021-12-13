import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] array=new int[scanner.nextInt()];
        for (int i = 0; i <array.length ; i++) {
            array[i]=scanner.nextInt();
        }
        System.out.println(maxSum(array));
    }
    public static int maxSum(int[] array)
    {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < array.length - 1; i++)
        {
            sum = 0;
            for (int j = i; j < array.length; j++)
            {
                sum += array[j];
                if (sum >= maxSum) {
                    maxSum = sum;
                }
                if (maxSum<=0){
                    maxSum=0;
                }
            }
        }
        return maxSum;
    }
}
