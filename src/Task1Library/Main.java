package Task1Library;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));

        User user1 = new User("Alice");
        User user2 = new User("Bob");
        library.registerUser(user1);
        library.registerUser(user2);

        library.lendBook("The Hobbit", user1);
        library.lendBook("1984", user2);

        System.out.println(user1);
        System.out.println(user2);

        library.returnBook("The Hobbit", user1);

        System.out.println(library);

        library.lendBook("Nonexistent Book", user1);

        library.returnBook("To Kill a Mockingbird", user1);
    }
}
