import java.io.*;
class GreedyKnapsack {
    public static void knapsack(float m, int n, float w[], float p[]) {
        int i;
        float x[] = new float[n + 1];
        float profit = (float) 0.0;
        for (i = 1; i <= n; i++) x[i] = 0;
        float U = m;
        for (i = 1; i <= n; i++) {
            if (w[i] > U) break;
            x[i] = (float) 1.0;
            U -= w[i];
        }
        if (i <= n)
            x[i] = U / w[i];
        for (i = 1; i <= n; i++) {
            System.out.println("x[" + i + "]:-\t" + x[i]);
            profit = profit + (p[i] * x[i]);
        }
        System.out.println("\nThe profit earned by given optimal solution is:-\t" + profit);
    }
    public static void sortObject(int n, float p[], float w[]) {
        int i, j;
        float temp1, temp2;
        float ratio[] = new float[n + 1];
        for (i = 1; i <= n; i++) {
            ratio[i] = p[i] / w[i];
        }
        for (i = 1; i < n; i++)
            for (j = 1; j < n; j++)
                if (ratio[j] < ratio[j + 1]) {
                    temp1 = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp1;

                    temp2 = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = temp2;
                }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of objects:-\t");
        int n = Integer.parseInt(br.readLine());
        System.out.print("\nEnter the knapsack capacity:-\t");
        float m = Float.parseFloat(br.readLine());
        float p[] = new float[n + 1];
        float w[] = new float[n + 1];
        System.out.println("\nEnter the values of profit & weights for each object:-");
        for (int i = 1; i <= n; i++) {
            System.out.print("Profit of object " + i + " :-\t");
            p[i] = Integer.parseInt(br.readLine());
            System.out.print("Weight of object " + i + " :-\t");
            w[i] = Integer.parseInt(br.readLine());
            System.out.println();
        }
        sortObject(n, p, w);
        System.out.println("\nThe optimal solution is:-");
        knapsack(m, n, w, p);
    }

}