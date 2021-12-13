import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[9];
		for (int i = 0; i < 9; i++) {
			array[i] = scanner.nextInt();
		}
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] B = new int[m];
		for (int i = 0; i < m; i++) {
			B[i] = scanner.nextInt();
		}
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i]==B[j]){
					c += B[j];
				}
			}
		}
		if (c != 0)
			System.out.println(array[8]*c);
		else
			System.out.println("barabar nist");
    }
}
