package library;

public class BookStorga {
    private Book[] books = new Book[10];
    private int size = 0;

    public void add(Book book) {
        if (size == books.length){
            extend();
        }
        books[size++] = book;
    }
    private void extend( ){
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books,0,tmp,0,size);
        books = tmp;
    }
    public void print(){
        for (int i = 0; i < size; i++){
            System.out.println(i + ": " + books[i]);
        }
    }

    public void search(String keyword) {
        for (int i = 0; i < size; i++){
            if (books[i].getTitle().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(books[i]);

            }
        }
    }

    public Book getBookByMaxPrice(){

        double price = 0;
        int maxIndex = -1;
        for (int i = 0; i < size; i++){
            if (books[i].getPrise()> price) {
                price = books[i].getPrise();
                maxIndex = i;
            }
        }
        return books[maxIndex];
    }
    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Book with this index does not exist!");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            books[i] = books[i + 1];
        }
        books[--size] = null;
        System.out.println("Book deleted successfully!");
    }
    public void searchByPriceRange(double minPrice, double maxPrice) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            double price = books[i].getPrise();
            if (price >= minPrice && price <= maxPrice) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found in this price range!");
        }
    }
}

