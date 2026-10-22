public class Node<T> {
    T data;         // Dato almacenado (puede ser Book, String, etc.)
    Node<T> next;   // Referencia al siguiente nodo en la estructura

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}