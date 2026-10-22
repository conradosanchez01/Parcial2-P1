public class Main {
    public static void main(String[] args) {
        Library library = new Library("Biblioteca Central");

        // 1. Agregar libros
        Book b1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book b2 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book b3 = new Book("Cien años de soledad", "978-84-376-0495-4", "Gabriel García Márquez", 1967);
        Book b4 = new Book("El amor en los tiempos del cólera", "978-84-376-0497-8", "Gabriel García Márquez", 1985);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        System.out.println(library);
        System.out.println("\n--- LIBROS DISPONIBLES INICIALMENTE ---");
        LinkedList<Book> disponibles = library.getAvailableBooks();
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println(" - " + disponibles.get(i));
        }


         System.out.println("\n--- LIBROS prestados INICIALMENTE ---");
        LinkedList<Book> prestados = library.getLoanedBooks();
        for (int i = 0; i < prestados.size(); i++) {
            System.out.println(" - " + prestados.get(i));
        }


        // 2. Búsquedas por título y por autor
        System.out.println("\n--- BÚSQUEDA POR TÍTULO ('amor') ---");
        LinkedList<Book> porTitulo = library.findBooksByTitle("amor");
        for (int i = 0; i < porTitulo.size(); i++) {
            System.out.println(" - " + porTitulo.get(i));
        }

        System.out.println("\n--- BÚSQUEDA POR AUTOR ('García Márquez') ---");
        LinkedList<Book> porAutor = library.findBooksByAuthor("García Márquez");
        for (int i = 0; i < porAutor.size(); i++) {
            System.out.println(" - " + porAutor.get(i));
        }

        // 3. Simulación de préstamos
        System.out.println("\n--- PRESTANDO LIBROS POR ISBN ---");
        Book prestamo1 = library.findBookByIsbn("978-84-376-0496-1"); // 1984
        if (prestamo1 != null && prestamo1.lend("Miguelito")) {
            System.out.println("Se prestó exitosamente: " + prestamo1.getTitle());
        }


        // 4. Prueba de Tarea N°3: Cola de espera sobre un libro prestado ("1984")
        System.out.println("\n--- TAREA 3: COLA DE ESPERA PARA EL LIBRO '1984' ---");
        library.addUserToBookWaitList("978-84-376-0496-1", "Ana");
        library.addUserToBookWaitList("978-84-376-0496-1", "Juan");
        library.addUserToBookWaitList("978-84-376-0496-1", "Pedro");

        System.out.println("Primer usuario en espera para '1984': "
                + library.getNextWaitingUserForBook("978-84-376-0496-1"));

        System.out.println("Devolviendo '1984'...");
        String usuarioAsignado = library.returnBookAndAttendWaitList("978-84-376-0496-1");
        if (usuarioAsignado != null) {
            System.out.println("El libro fue devuelto e inmediatamente prestado a: " + usuarioAsignado);
        }
        System.out.println("Nuevo primer usuario en espera para '1984': "
                + library.getNextWaitingUserForBook("978-84-376-0496-1"));
        System.out.println("Estado actual de '1984': " + prestamo1);

        // 5. Estadísticas finales
        System.out.println("\n" + library.getStatistics());




        // Prueba de Tarea N°2: Pila de préstamos y opción de deshacer (Undo)
        System.out.println("\n--- TAREA 2: HISTORIAL Y DESHACER PRÉSTAMO (STACK) ---");
        String isbnQuijote = "978-84-376-0494-7";

        // 1. Registrar préstamo (por error se lo prestamos a "Carlos" en vez de "Lucía")
        if (library.lendBookToUser(isbnQuijote, "Carlos (Usuario Equivocado)")) {
            System.out.println("Se registró préstamo de 'El Quijote'.");
        }

        // 2. Ver el último préstamo
        System.out.println("Último préstamo registrado en 'El Quijote': "
                + library.getLastLoanForBook(isbnQuijote));

        // 3. Deshacer el último préstamo
        String prestamoCancelado = library.undoLastBookLoan(isbnQuijote);
        if (prestamoCancelado != null) {
            System.out.println("Se deshizo el préstamo erróneo de: " + prestamoCancelado);
        }
        System.out.println("Estado de 'El Quijote' tras deshacer: "
                + library.findBookByIsbn(isbnQuijote));

        // Ahora sí lo prestamos al usuario correcto
        library.lendBookToUser(isbnQuijote, "Lucía");
        System.out.println("Nuevo último préstamo registrado: "
                + library.getLastLoanForBook(isbnQuijote));






                
    }
}