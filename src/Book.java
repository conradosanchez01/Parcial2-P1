public class Book {
    private String title;
    private String isbn;
    private String author;
    private int publicationYear;
    private boolean available;
    private int timesLoaned;
    private Queue<String> waitingQueue; // Tarea 3: Cola de espera de usuarios para este libro
    private Stack<String> loanHistory; // Tarea 2: Pila con el historial de préstamos


    public Book(String title, String isbn, String author, int publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
        this.timesLoaned = 0;
        this.waitingQueue = new Queue<>();
        this.loanHistory = new Stack<>();
    }

    // Getters
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return available; }
    public int getTimesLoaned() { return timesLoaned; }
    public Queue<String> getWaitingQueue() { return waitingQueue; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setTimesLoaned(int timesLoaned) { this.timesLoaned = timesLoaned; }

    // Presta el libro si está disponible
    public boolean lend(String userName) {
        if (available) {
            available = false;
            timesLoaned++;
            loanHistory.push(userName); // Guardamos al usuario en el tope de la pila
            return true;
        }
        return false;
    }

    // Devuelve el libro marcándolo como disponible
    public void returnBook() {
        available = true;
    }

     // --- MÉTODOS DE TAREA N°2: HISTORIAL DE PRÉSTAMOS ---
    // Mantenemos lend() sin parámetros por compatibilidad con el resto del código
    public boolean lend() {
        return lend("Usuario general");
    }
    // Operación 2: Ver el último préstamo registrado (sin deshacerlo)
    public String getLastLoanUser() {
        return loanHistory.peek();
    }
    // Operación 3: Deshacer el último préstamo en caso de error
    public String undoLastLoan() {
        // Solo podemos deshacer si el libro figura prestado y hay un préstamo en la pila
        if (!available && !loanHistory.isEmpty()) {
            String removedUser = loanHistory.pop(); // Sacamos al último usuario de la pila
            available = true;                       // El libro vuelve a estar disponible
            timesLoaned--;                          // Descontamos el préstamo porque fue un error
            return removedUser;
        }
        return null;
    }



    // --- MÉTODOS DE TAREA N°3: ESPERA DE LIBROS ---

    // 1. Agregar un usuario a la espera (solo si el libro está prestado)
    public boolean addUserToWaitList(String userName) {
        if (available) {
            // Si está disponible no necesita ir a lista de espera, se puede prestar directo
            return false;
        }
        waitingQueue.enqueue(userName);
        return true;
    }

    // 2. Ver el primer usuario en espera sin sacarlo
    public String getNextWaitingUser() {
        return waitingQueue.peek();
    }

    // 3. Quitar al primer usuario en espera cuando el libro está disponible y prestárselo
    public String lendToNextWaitingUser() {
        if (available && !waitingQueue.isEmpty()) {
            String nextUser = waitingQueue.dequeue();
            this.lend(nextUser); // Cambia available a false e incrementa timesLoaned
            return nextUser;
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + title + " | ISBN: " + isbn + " | Autor: " + author + " | Año: "
                + publicationYear + " | Disponible: " + (available ? "Sí" : "No")
                + " | Prestado: " + timesLoaned + " veces"
                + " | En espera: " + waitingQueue.size() + "]";
    }
}