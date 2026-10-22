public class Library {
    private String name;
    private LinkedList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
    }

    public String getName() { return name; }
    public LinkedList<Book> getBooks() { return books; }

    // Gestión de libros: Agregar
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    // Gestión de libros: Eliminar (faltaba en tu código y lo pide el PDF)
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    // Búsqueda por ISBN
    public Book findBookByIsbn(String isbn) {
        if (isbn == null) return null;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    // Búsqueda flexible por Título
    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> results = new LinkedList<>();
        if (title == null) return results;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    // Búsqueda flexible por Autor (faltaba en tu Library.java y lo pide el PDF)
    public LinkedList<Book> findBooksByAuthor(String author) {
        LinkedList<Book> results = new LinkedList<>();
        if (author == null) return results;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    // Consulta: Libros disponibles
    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> available = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isAvailable()) {
                available.add(b);
            }
        }
        return available;
    }

    // Consulta: Libros prestados
    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> loaned = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (!b.isAvailable()) {
                loaned.add(b);
            }
        }
        return loaned;
    }

    // Consulta: Estadísticas en tiempo real (pedido en el PDF)
    public String getStatistics() {
        int total = books.size();
        int disponibles = getAvailableBooks().size();
        int prestados = getLoanedBooks().size();
        int totalPrestamosHistoricos = 0;

        for (int i = 0; i < books.size(); i++) {
            totalPrestamosHistoricos += books.get(i).getTimesLoaned();
        }

        return "=== Estadísticas de " + name + " ===\n"
                + " - Total de libros en catálogo: " + total + "\n"
                + " - Libros disponibles actualmente: " + disponibles + "\n"
                + " - Libros prestados actualmente: " + prestados + "\n"
                + " - Total acumulado de préstamos realizados: " + totalPrestamosHistoricos;
    }

    // --- OPERACIONES DE TAREA N°3 DESDE LA BIBLIOTECA ---

    // Agregar usuario a la lista de espera de un libro por ISBN
    public boolean addUserToBookWaitList(String isbn, String userName) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            return book.addUserToWaitList(userName);
        }
        return false;
    }

    // Ver el primer usuario en espera de un libro por ISBN
    public String getNextWaitingUserForBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            return book.getNextWaitingUser();
        }
        return null;
    }

    // Devolver un libro y, si hay usuarios esperando, prestárselo automáticamente al primero
    public String returnBookAndAttendWaitList(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook(); // El libro pasa a estar disponible (available = true)
            // Si hay alguien en la cola de espera, lo sacamos de la cola y se lo prestamos
            return book.lendToNextWaitingUser();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Biblioteca: " + name + " (" + books.size() + " libros registrados)";
    }
}