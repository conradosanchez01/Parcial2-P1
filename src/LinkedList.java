/**
 * Implementación simple de una Lista Doblemente Enlazada
 
public class LinkedList {
    XXXX head;
    XXXX size;
    
    public LinkedList() {

    }
    
    
    public XXXX add(XXXX data) {
        
    }
    
    
    public XXXX get(XXXX index) {
 
    }
    
    
    public XXXX remove(XXXX data) {
        
    }
    
    
    public XXXX contains(XXXX data) {
        
    }
    
    public XXXX isEmpty() {
    }
    
    
    public XXXX clear() {
    }
    
}
*/
//lista enlazada simple
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Book book) {
        Node nuevo = new Node(book);

        if (head == null) {
            head = nuevo;
        } else {
            Node aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }

        size++;
    }
// obtengo por indice
    public Book get(int index) {
        if (index < 0 || index >= size) return null;

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }
 // elimina book
    public boolean remove(Book book) {
        if (head == null) return false;

        if (head.data.equals(book)) {
            head = head.next;
            size--;
            return true;
        }

        Node aux = head;
        while (aux.next != null) {
            if (aux.next.data.equals(book)) {
                aux.next = aux.next.next;
                size--;
                return true;
            }
            aux = aux.next;
        }

        return false;
    }
// vacia lista
    public void clear() {
        head = null;
        size = 0;
    }

 // buscar por codigo isbn
    public Book findByIsbn(String isbn) {
        Node aux = head;
        while (aux != null) {
            if (aux.data.getIsbn().equals(isbn)) return aux.data;
            aux = aux.next;
        }
        return null;
    }

// buscar por titulo 
    public LinkedList findByTitle(String title) {
        LinkedList results = new LinkedList();
        Node aux = head;
        while (aux != null) {
            if (aux.data.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(aux.data);
            }
            aux = aux.next;
        }
        return results;
    }

    // Buscar por autor
    public LinkedList findByAuthor(String author) {
        LinkedList results = new LinkedList();
        Node aux = head;
        while (aux != null) {
            if (aux.data.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(aux.data);
            }
            aux = aux.next;
        }
        return results;
    }

    // Libros disponibles
    public LinkedList getAvailableBooks() {
        LinkedList available = new LinkedList();
        Node aux = head;
        while (aux != null) {
            if (aux.data.isAvailable()) available.add(aux.data);
            aux = aux.next;
        }
        return available;
    }

    // Libros prestados
    public LinkedList getLoanedBooks() {
        LinkedList loaned = new LinkedList();
        Node aux = head;
        while (aux != null) {
            if (!aux.data.isAvailable()) loaned.add(aux.data);
            aux = aux.next;
        }
        return loaned;
    }
}












