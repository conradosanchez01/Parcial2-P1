public class Stack<T> {
    private Node<T> top; // Cima o tope de la pila
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    // Apilar (push): inserta un elemento arriba del todo (en el tope)
    public void push(T data) {
        if (data == null) return;
        Node<T> nuevo = new Node<>(data);
        nuevo.next = top; // El nuevo nodo apunta al que antes era el tope
        top = nuevo;      // Ahora el tope pasa a ser el nuevo nodo
        size++;
    }

    // Desapilar (pop): quita y devuelve el elemento del tope
    public T pop() {
        if (isEmpty()) return null;
        T data = top.data;
        top = top.next; // El tope baja al siguiente nodo
        size--;
        return data;
    }

    // Ver tope (peek): muestra el último elemento apilado sin quitarlo
    public T peek() {
        if (isEmpty()) return null;
        return top.data;
    }
}