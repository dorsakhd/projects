import java.util.Iterator;
import java.util.NoSuchElementException;
    public class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext() {
            return current != null;
        }


        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.getData();
            current = current.getNext_node();
            return item;
        }
    }

