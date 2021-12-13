
    public class Node<Item> {

        private Item data;
        private Node next_node;

        public Node(Item data, Node next_node) {
            this.data = data;
            this.next_node = next_node;
        }

        public Item getData() {
            return data;
        }

        public Node getNext_node() {
            return next_node;
        }

    }
