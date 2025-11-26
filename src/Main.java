/**
 * public class Main {
 * public static v // Buscar libros por título
 * // Mostrar libros disponibles y prestados
 * System.out.println("\n📚 LIBROS DISPONIBLES:");
 * LinkedList available = library.getAvailableBooks();
 * for (int i = 0; i < available.size(); i++) {
 * System.out.println(" - " + available.get(i));
 * }
 * 
 * System.out.println("\n📤 LIBROS PRESTADOS:");
 * LinkedList loaned = library.getLoanedBooks();
 * for (int i = 0; i < loaned.size(); i++) {
 * System.out.println(" - " + loaned.get(i));
 * }.out.println("\n🔍 BÚSQUEDA POR TÍTULO ('amor'):");
 * LinkedList searchResults = library.findBooksByTitle("amor");
 * for (int i = 0; i < searchResults.size(); i++) {
 * System.out.println(" - " + searchResults.get(i));
 * }
 * 
 * // Buscar libros por autor
 * System.out.println("\n🔍 BÚSQUEDA POR AUTOR ('García Márquez'):");
 * LinkedList authorBooks = library.findBooksByAuthor("García Márquez");
 * for (int i = 0; i < authorBooks.size(); i++) {
 * System.out.println(" - " + authorBooks.get(i));
 * }ng[] args) {
 * System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
 * System.out.println("Aplicación Java de consola iniciada.\n");
 * 
 * // Crear una biblioteca
 * Library library = new Library("Biblioteca Central");
 * 
 * // Crear algunos libros
 * Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de
 * Cervantes", 1605);
 * Book book2 = new Book("Cien años de soledad", "978-84-376-0495-4", "Gabriel
 * García Márquez", 1967);
 * Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
 * Book book4 = new Book("El amor en los tiempos del cólera",
 * "978-84-376-0497-8", "Gabriel García Márquez", 1985);
 * 
 * // Crear algunos autores adicionales
 * Author author1 = new Author("Miguel de Cervantes", "Español", 1547);
 * Author author2 = new Author("Gabriel García Márquez", "Colombiano", 1927);
 * Author author3 = new Author("George Orwell", "Británico", 1903);
 * 
 * // Agregar libros a la biblioteca
 * System.out.println("📚 AGREGANDO LIBROS A LA BIBLIOTECA:");
 * library.addBook(book1);
 * library.addBook(book2);
 * library.addBook(book3);
 * library.addBook(book4);
 * System.out.println("✅ Libros agregados exitosamente");
 * 
 * // Agregar autores adicionales (con más información)
 * System.out.println("\n👥 AGREGANDO INFORMACIÓN ADICIONAL DE AUTORES:");
 * library.addAuthor(author1);
 * library.addAuthor(author2);
 * library.addAuthor(author3);
 * System.out.println("✅ Información de autores agregada");
 * 
 * // Mostrar información de la biblioteca
 * System.out.println("\n📊 INFORMACIÓN DE LA BIBLIOTECA:");
 * System.out.println(library);
 * System.out.println("\n" + library.getStatistics());
 * 
 * // Buscar libros por título
 * System.out.println("\n🔍 BÚSQUEDA POR TÍTULO ('amor'):");
 * LinkedList<Book> searchResults = library.findBooksByTitle("amor");
 * for (int i = 0; i < searchResults.size(); i++) {
 * System.out.println(" - " + searchResults.get(i));
 * }
 * 
 * // Buscar libros por autor
 * System.out.println("\n🔍 BÚSQUEDA POR AUTOR ('García Márquez'):");
 * LinkedList<Book> authorBooks = library.findBooksByAuthor("García Márquez");
 * for (int i = 0; i < authorBooks.size(); i++) {
 * System.out.println(" - " + authorBooks.get(i));
 * }
 * 
 * // Prestar algunos libros
 * System.out.println("\n📖 SIMULANDO PRÉSTAMOS:");
 * Book foundBook = library.findBookByIsbn("978-84-376-0494-7");
 * if (foundBook != null && foundBook.lend()) {
 * System.out.println("✅ Se prestó: " + foundBook.getTitle());
 * }
 * 
 * foundBook = library.findBookByIsbn("978-84-376-0495-4");
 * if (foundBook != null && foundBook.lend()) {
 * System.out.println("✅ Se prestó: " + foundBook.getTitle());
 * }
 * 
 * // Mostrar libros disponibles y prestados
 * System.out.println("\n📚 LIBROS DISPONIBLES:");
 * LinkedList<Book> available = library.getAvailableBooks();
 * for (int i = 0; i < available.size(); i++) {
 * System.out.println(" - " + available.get(i));
 * }
 * 
 * System.out.println("\n📤 LIBROS PRESTADOS:");
 * LinkedList<Book> loaned = library.getLoanedBooks();
 * for (int i = 0; i < loaned.size(); i++) {
 * System.out.println(" - " + loaned.get(i));
 * }
 * 
 * // Mostrar estadísticas finales
 * System.out.println("\n📊 ESTADÍSTICAS FINALES:");
 * System.out.println(library.getStatistics());
 * 
 * // Procesar argumentos si se proporcionan
 * if (args.length > 0) {
 * System.out.println("\n💻 ARGUMENTOS RECIBIDOS:");
 * for (int i = 0; i < args.length; i++) {
 * System.out.println(" " + (i + 1) + ": " + args[i]);
 * }
 * }
 * 
 * System.out.println("\n🎉 Demostración completada.");
 * }
 * }
 * 
 */

public class Main {
    public static void main(String[] args) {
        LinkedList library = new LinkedList();

        // Agregar libros
        Book b1 = new Book("El Quijote", "978-84-376-0494-7", "Cervantes", 1605);
        Book b2 = new Book("Cien años de soledad", "978-84-376-0495-4", "G. G. Márquez", 1967);
        Book b3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book b4 = new Book("El amor en los tiempos del cólera", "978-84-376-0497-8", "G. G. Márquez", 1985);

        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);

        System.out.println(" LIBROS DE LA BIBLIOTECA:");
        for (int i = 0; i < library.size(); i++) {
            System.out.println(library.get(i));
        }

        System.out.println("\n Buscar por título 'amor':");
        LinkedList search = library.findByTitle("amor");
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i));
        }

        System.out.println("\n Simulando préstamo de '1984':");
        Book prestado = library.findByIsbn("978-84-376-0496-1");
        if (prestado != null && prestado.lend()) {
            System.out.println(" Prestado: " + prestado.getTitle());
        }

        System.out.println("\n Libros disponibles:");
        LinkedList available = library.getAvailableBooks();
        for (int i = 0; i < available.size(); i++) {
            System.out.println(available.get(i));
        }

        System.out.println("\n Libros prestados:");
        LinkedList loaned = library.getLoanedBooks();
        for (int i = 0; i < loaned.size(); i++) {
            System.out.println(loaned.get(i));
        }

        // Cola de espera
        QueueUsers queue = new QueueUsers();
        queue.enqueue("Ana");
        queue.enqueue("Juan");
        System.out.println("\n Primer usuario en espera: " + queue.peek());
        System.out.println(" Atendiendo a: " + queue.dequeue());
        System.out.println(" Nuevo primer usuario en espera: " + queue.peek());



         // REMOVE
        System.out.println("\n Eliminando 'Cien años de soledad'");
        library.remove(b2); // Elimina el libro
        System.out.println("\n Biblioteca después de eliminar 'Cien años de soledad':");
        for (int i = 0; i < library.size(); i++) {
            System.out.println(library.get(i));
        }


        // CLEAR
        System.out.println("\n Vaciando la biblioteca");
        library.clear(); // Vacía la lista
        System.out.println(" Biblioteca después de vaciarla: " + (library.isEmpty() ? "vacía" : "con libros"));

    }
}
