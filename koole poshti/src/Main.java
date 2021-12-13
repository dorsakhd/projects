import java.util.Scanner;

class Main {
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    static void knapSack(int W, int weight[], int value[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weight[i - 1] <= w)
                    K[i][w] = Math.max(value[i - 1] +
                            K[i - 1][w - weight[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        int res = K[n][W];
        System.out.println(res);

        w = W;
        for (i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w])
                continue;
            else {
                System.out.print(weight[i - 1] + " ");
                res = res - value[i - 1];
                w = w - weight[i - 1];
            }
        }
    }

    public static void main(String arg[])
    {
        Scanner scanner=new Scanner(System.in);
        int value[] = {scanner.nextInt() ,scanner.nextInt(),scanner.nextInt() };
        int weight[] = { scanner.nextInt() ,scanner.nextInt(),scanner.nextInt()  };
        int W = scanner.nextInt();
        int n = value.length;
        knapSack(W,weight, value, n);
    }
}
