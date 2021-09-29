package bookStoreTests;

import BookStore.Book;
import api.Get;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetOneBook {
    private static Book book = new Book();
    private String isbn;

    @BeforeEach
    void setup() {
        Get getBooks = new Get("https://demoqa.com/BookStore/v1/Books");
        isbn = getBooks.getResponse().getBody().jsonPath().getString("isbn");
    }

    @Test
    @DisplayName("Get one book from Book Store by isbn")
    @Order(1)
    void getOneBook() {
        Get getBook = new Get("jsonSchemas/GetOneBook.json", 200,
                "https://demoqa.com/BookStore/v1/Book?ISBN=9781449337711");
    }

    @Test
    @DisplayName("Get one book from Book Store by invalid isbn")
    @Order(2)
    void getOneBookByInvalidIsbn() {
        Get getBook = new Get("jsonSchemas/Errors.json", 400,
                "https://demoqa.com/BookStore/v1/Book?ISBN=" + isbn);
    }
}
