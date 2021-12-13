
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
        {
            static Queue<Integer> reverse(Queue<Integer> q1)
            {

                int size = q1.size();

                Queue<Integer> q2 = new LinkedList<>();

                for (int i = 0; i < size; i++)
                {

                    for (int j = 0; j < q1.size() - 1; j++)
                    {
                        int x = q1.peek();
                        q1.remove();
                        q1.add(x);
                    }
                    q2.add(q1.peek());
                    q1.remove();
                }
                return q2;
            }
            public static void main(String[] args)
            {
                Scanner scanner=new Scanner(System.in);
                Queue<Integer> q1 = new LinkedList<>();
                q1.add(scanner.nextInt());
                q1.add(scanner.nextInt());
                q1.add(scanner.nextInt());
                q1.add(scanner.nextInt());
                q1.add(scanner.nextInt());
                q1 = reverse(q1);
                while (!q1.isEmpty())
                {
                    System.out.print(q1.peek() + " ");
                    q1.remove();
                }
            }
        }



