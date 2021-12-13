import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m1 = scanner.nextInt();
		int d1 = scanner.nextInt();
		int m2 = scanner.nextInt();
		int d2 = scanner.nextInt();
		int m =converter(m1)+d1 -(converter(m2)+d2);
		int ans = m < 0 ? -m : m;
		System.out.println(ans);
	}

	public static int converter(int m) {
		int d=0;
		if (m <= 6) {
			 d = (m - 1) * 31;
		}
		if (6 < m && m <= 11) {
			 d = 6*31 + (m - 7) * 30;
		}
		if (m == 12) {
			 d = 6*31+5*31;
		}return d;
	}
}

