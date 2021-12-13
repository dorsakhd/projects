import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<String>();

        list.addFirst("0");
        list.addFirst("1");
        list.addFirst("2");
        //list.addFirst("0");
        //list.addLast("4");
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            String fruit = (String) iterator.next();
            System.out.println(fruit);

        }

    }

}