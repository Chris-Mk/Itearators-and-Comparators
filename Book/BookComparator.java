package Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        if (firstBook.getTitle().compareTo(secondBook.getTitle()) == 0) {
            return Integer.compare(firstBook.getYear(), secondBook.getYear());
        } else {
            return firstBook.getTitle().compareTo(secondBook.getTitle());
        }
    }
}
