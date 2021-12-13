public class Main {

    public static void main(String[] args) {
        int tedad = 0;
        for (int i = 1; i <= 100; i++) {
            int squar = i * i;
            if (squar % 7 == 4) {
                tedad++;
            }
        }System.out.println(tedad);
    }
}

