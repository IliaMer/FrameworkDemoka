package bookStoreTests;

import BookStore.User;
import api.Delete;
import api.Post;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeleteBooksByUserId {
    private static User user = new User();
    private String userId;
    private String token;

    @BeforeEach
    void setup() {
        Post create = new Post(user, "https://demoqa.com/Account/v1/User");
        userId = create.getResponse().getBody().jsonPath().getString("userID");
        Post getToken = new Post(user, "https://demoqa.com/Account/v1/GenerateToken");
        token = getToken.getResponse().getBody().jsonPath().getString("token");
        Post login = new Post(user, "https://demoqa.com/Account/v1/Authorized");
    }

    //Тест падает, из-за того что в ответе не приходит json, указанный в сваггере.
    @Test
    @DisplayName("Delete books by userId")
    @Order(1)
    void deleteBooksByUserId() {
        Delete delete = new Delete("jsonSchemas/DeleteBooksByUserId.json", 204,
                "https://demoqa.com/BookStore/v1/Books?UserId=" + userId, token);
    }
}
