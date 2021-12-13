import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int valueAux = 0;
    static int weightAux = 0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 3 weights");
        int[] weights = {scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
        System.out.println("Enter 3 values");
        int[] values = {scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
        int[] sol = new int[weights.length];
        int[] finalSol = new int[weights.length];
        int max = 50;
        knapsack(weights, values, max, 0, sol, finalSol);
        for (int i = 0; i < finalSol.length; i++) {
            System.out.println(finalSol[i] * weights[i]);
        }
    }
    public static void knapsack(int[] weights, int[] values, int max, int index, int[] sol, int[] finalSol) {
        sol[index] = -1;
        int n = weights.length;
        while (sol[index] < 1) {
            sol[index] = sol[index] + 1;
            if (sum(index, sol, weights) <= max && index == n - 1) {
                System.out.println("Sol: " + Arrays.toString(sol));
                System.out.println("weight = " + sum(index, sol, weights));
                update(weights, values, max, index, sol, finalSol);
                System.out.println("*******************************");
            } else if (index < n - 1) {    // changed
                knapsack(weights, values, max, index + 1, sol, finalSol);
            }
        }
    }
    private static int sum(int index, int[] weights, int[] sol) {
        int res = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] < 0 ) System.out.println("in sum: i = " + i + "   sol[i] = " + sol[i]);
            res += sol[i] * weights[i];
        }
        return res;
    }
    private static void update(int[] weights, int[] values, int max, int index, int[] sol, int[] finalSol) {

        int totalValue = 0;
        int totalWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sol[i] == 1) {
                totalValue += values[i];
                totalWeight += weights[i];
            }
        }

        if (totalValue > valueAux) {
            for (int i = 0; i < weights.length; i++) {
                finalSol[i] = sol[i];
            }
            valueAux = totalValue;
            weightAux = totalWeight;
            System.out.println("new valueAux: " + valueAux);
        }

    }
}
