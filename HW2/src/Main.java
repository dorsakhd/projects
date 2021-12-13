import java.util.Scanner;

public class Main {
            static int preIndex = 0;
            void printPost(int[] in, int[] pre, int inStrt, int inEnd)
            {
                if (inStrt > inEnd)
                    return;
                int inIndex = search(in, inStrt, inEnd, pre[preIndex++]);
                printPost(in, pre, inStrt, inIndex - 1);
                printPost(in, pre, inIndex + 1, inEnd);
                System.out.print(in[inIndex] + " ");
            }

            int search(int[] in, int startIn, int endIn, int data)
            {
                int i = 0;
                for (i = startIn; i < endIn; i++)
                    if (in[i] == data)
                        return i;
                return i;
            }
            public static void main(String ars[])
            {
                Scanner scanner=new Scanner(System.in);
                int num=scanner.nextInt();

                int[] in = new int [num];
                int[] pre = new int [num];
                for (int i = 0; i <num ; i++) {
                    pre[i]=scanner.nextInt();
                }
                for (int i = 0; i <num ; i++) {
                    in[i]=scanner.nextInt();
                }
                int len = in.length;
                Main tree = new Main();
                tree.printPost(in, pre, 0, len - 1);
            }
        }

