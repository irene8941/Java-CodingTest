public class Node<T> {
    T data;                 // 데이터
    Node<T> next = null;    // 포인터

    public Node(T data) {   // 생성자
        this.data = data;
    }
}
