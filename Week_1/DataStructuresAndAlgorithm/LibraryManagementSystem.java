import java.util.Arrays;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{bookId=" + bookId + ", title='" + title + "', author='" + author + "'}";
    }
}

class LibraryManager {
    private Book[] books;
    private int size;

    public LibraryManager(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(int bookId, String title, String author) {
        if (size < books.length) {
            books[size++] = new Book(bookId, title, author);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, size);
    }

    public int getSize() {
        return size;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager(10);

        libraryManager.addBook(1, "Introduction to Algorithms", "Thomas H. Cormen");
        libraryManager.addBook(2, "Clean Code", "Robert C. Martin");
        libraryManager.addBook(3, "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma");
        libraryManager.addBook(4, "The Pragmatic Programmer", "Andrew Hunt");

        libraryManager.sortBooksByTitle();

        System.out.println("Linear Search:");
        System.out.println(libraryManager.linearSearchByTitle("Clean Code"));

        System.out.println("\nBinary Search:");
        System.out.println(libraryManager.binarySearchByTitle("Design Patterns: Elements of Reusable Object-Oriented Software"));
    }
}
