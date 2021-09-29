package BookStore;

import java.io.Serializable;

public class ListOfBooks implements Serializable {
private String userId;
private String[] isbn;

    public ListOfBooks(String userId, String[] isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getIsbn() {
        return isbn;
    }

    public void setIsbn(String[] isbn) {
        this.isbn = isbn;
    }
}
