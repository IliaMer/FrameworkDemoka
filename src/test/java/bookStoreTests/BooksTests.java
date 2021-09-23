package bookStoreTests;

import api.Delete;
import org.junit.jupiter.api.Test;

public class BooksTests {

    @Test
    void getBooksTest() {
        Delete post = new Delete("jsonSchemaAddListOfBooks.json", 200,
                "https://demoqa.com/BookStore/v1/Books");
    }
}
