public class Queue<T> {
    private Node<T> front; // Primero en la fila (por donde salen)
    private Node<T> rear;  // Último en la fila (por donde entran)
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    // Encolar: agrega un elemento al final (rear)
    public void enqueue(T data) {
        if (data == null) return;
        Node<T> nuevo = new Node<>(data);
        if (rear == null) {
            front = rear = nuevo;
        } else {
            rear.next = nuevo;
            rear = nuevo;
        }
        size++;
    }

    // Desencolar: quita y devuelve el primer elemento (front)
    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Si la cola quedó vacía, rear también debe ser null
        }
        size--;
        return data;
    }

    // Espiar: devuelve el primer elemento sin quitarlo de la cola
    public T peek() {
        if (isEmpty()) return null;
        return front.data;
    }

    // Vaciar toda la cola
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }






}