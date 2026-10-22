public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Consultar estado: número de elementos
    public int size() {
        return size;
    }

    // Consultar estado: verifica si está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // Agregar elementos al final de la lista
    public void add(T data) {
        if (data == null) return;
        Node<T> nuevo = new Node<>(data);

        if (head == null) {
            head = nuevo;
        } else {
            Node<T> aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
        size++;
    }

    // Obtener elemento por posición (índice)
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // Caso límite: índice fuera de rango
        } 
        Node<T> aux = head; // Siempre arranca parado en el primer nodo (head)
        for (int i = 0; i < index; i++) { // Da tantos saltos como indique 'index'
            aux = aux.next; //cuenta los saltos hasta llegar al índice deseado
        }
        return aux.data; // Devuelve el libro guardado en el nodo donde frenó
    }

    // Buscar elemento: verifica existencia. 
    public boolean contains(T data) {
        if (data == null) return false;
        Node<T> aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    // Eliminar elemento por valor
    public boolean remove(T data) {
        if (head == null || data == null) return false;

        // Caso 1: El elemento a eliminar está en la cabeza (head)
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        // Caso 2: El elemento está en el medio o al final
        Node<T> aux = head;
        while (aux.next != null) {
            if (aux.next.data.equals(data)) {
                aux.next = aux.next.next; // Puenteamos el nodo eliminado
                size--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    // Eliminar todos los elementos
    public void clear() {
        head = null;
        size = 0;
    }
}