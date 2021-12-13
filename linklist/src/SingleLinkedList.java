import java.util.Iterator;

public class SingleLinkedList<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public SingleLinkedList() {
        size = 0;
        first = null;
        last=null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>(item,oldfirst);
        size++;
    }
//    public void addLast(Item item){
//        Node<Item> newlast=last;
//        last=new Node<Item>(item,newlast);
//        size++;
//    }
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

}
