package BookStore;

public class ListOfBooks {
    private String userId;
    private Isbn[] isbn;

    public String getUserId() {
        return userId;
    }

    public Isbn[] getIsbn() {
        return isbn;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setIsbn(Isbn[] isbn) {
        this.isbn = isbn;
    }

    public ListOfBooks(String userId, Isbn[] isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public static ListOfBooks createListOfBooks() {
        Isbn[] arr = Isbn.generateIsbn();
        return new ListOfBooks("c15f29e3-1f6f-48cc-8ef0-352e74858f2b", arr);
    }
}
