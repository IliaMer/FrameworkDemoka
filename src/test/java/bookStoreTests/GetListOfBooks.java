package bookStoreTests;


import api.Get;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetListOfBooks {
    @Test
    @DisplayName("Get All books from Book Store")
    void GetAllBooks() {
        Get getBooks = new Get("jsonSchemas/GetAllBooks.json", 200,
                "https://demoqa.com/BookStore/v1/Books");
    }
}
