import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // create a LinkedList
        LinkedList list1 = new LinkedList();
        // add some elements
        System.out.println("Enter 3 data");
        Scanner scanner=new Scanner(System.in);
        list1.add(scanner.nextInt());
        list1.add(scanner.nextInt());
        list1.add(scanner.nextInt());
        // print the list
        System.out.println("LinkedList1:" + list1);
        // add a new element at the end of the list
        System.out.println("Enter an element at the end");
        list1.addLast(scanner.nextInt());
        System.out.println("LinkedList1:" + list1);
        // add a new element at the first of the list
        System.out.println("Enter an element at the first");
        list1.addFirst(scanner.nextInt());
        System.out.println("LinkedList1:" + list1);
        //sorting
        list1.sort(Comparator.reverseOrder());
        System.out.println("after sorting: " + list1);
        //find max
        System.out.println("max:"+list1.getFirst());
        //find min
        System.out.println("min:"+list1.getLast());
        //find elemnt
        System.out.println("Enter the index that you want to find");
        System.out.println(list1.get(scanner.nextInt()));
        //size
        System.out.println("size:"+list1.size());
        //remove from the first
        list1.removeFirst();
        System.out.println("LinkedList1 after removing firts element:" + list1);
        //remove from the last
        list1.removeLast();
        System.out.println("LinkedList1 after removing last element:" + list1);
        //remove value
        System.out.println("select an index to remove");
        list1.remove(scanner.nextInt());
        System.out.println("LinkedList1:" + list1);

    }
}