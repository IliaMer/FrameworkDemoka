package bookStoreTests;

import BookStore.Book;
import BookStore.User;
import api.Delete;
import api.Get;
import api.Post;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeleteOneBook {
    private static Book book = new Book();
    private static User user = new User();
    private String isbn;
    private String userId;
    private String token;

    @BeforeEach
    void setup() {
        Post create = new Post(user, "https://demoqa.com/Account/v1/User");
        userId = create.getResponse().getBody().jsonPath().getString("userID");
        Post getToken = new Post(user, "https://demoqa.com/Account/v1/GenerateToken");
        token = getToken.getResponse().getBody().jsonPath().getString("token");
        Post login = new Post(user, "https://demoqa.com/Account/v1/Authorized");
        Get getBooks = new Get("https://demoqa.com/BookStore/v1/Books");
        isbn = getBooks.getResponse().getBody().jsonPath().getString("isbn");
    }

    @Test
    @DisplayName("Delete one book from user profile")
    @Order(1)
    void deleteBookFromUserProfile() {
        Delete delete = new Delete("jsonSchemas/DeleteBookStringObject.json", 204,
                "https://demoqa.com/Account/v1/User/" + userId, token);
    }
}
