package Task1Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void lendBook(String title, User user) {
        Book book = searchBookByTitle(title);
        if (book != null) {
            user.borrowBook(book);
            removeBook(book);
            System.out.println(user.getName() + " borrowed \"" + book.getTitle() + "\"");
        } else {
            System.out.println("The book \"" + title + "\" is not available in the library.");
        }
    }

    public void returnBook(String title, User user) {
        Book book = searchBookByTitle(title);
        if (book == null) {
            for (Book borrowedBook : user.getBorrowedBooks()) {
                if (borrowedBook.getTitle().equalsIgnoreCase(title)) {
                    books.add(borrowedBook);
                    user.returnBook(borrowedBook);
                    System.out.println(user.getName() + " returned \"" + title + "\"");
                    return;
                }
            }
            System.out.println(user.getName() + " did not borrow the book \"" + title + "\"");
        }
    }

    @Override
    public String toString() {
        return "Library: Available books: " + books;
    }
}
