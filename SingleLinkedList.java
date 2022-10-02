public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);    // 원래 Node가 새로운 Node를 가리킴
            searchedNode.next.next = nextNode;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.printAll();

        MyLinkedList.addNodeInside(5, 1);
        MyLinkedList.printAll();

        MyLinkedList.addNodeInside(6, 3);
        MyLinkedList.printAll();

        MyLinkedList.addNodeInside(7, 20);
        MyLinkedList.printAll();
    }
}
