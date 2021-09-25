package bookStoreTests;


import BookStore.User;
import api.Delete;
import api.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeleteUser {
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

    // Тест падает из-за того, что возвращается statusCode 204 вместо 200.
    // Схема ответа не соответствует схеме в сваггере
    @Test
    @DisplayName("Delete user")
    @Order(1)
    void deleteUser() {
        Delete delete = new Delete( "Schemas/jsonSchemaErrors.json", 200,
                "https://demoqa.com/Account/v1/User/" + userId, token);
    }

    @Test
    @DisplayName("Delete without auth")
    @Order(2)
    void deleteUser1() {
        Delete delete = new Delete( "Schemas/jsonSchemaErrors.json", 204,
                "https://demoqa.com/Account/v1/User/" + userId);
    }

    @Test
    @DisplayName("Delete2")
    @Order(3)
    void deleteUser2() {
        Delete delete = new Delete( "Schemas/jsonSchemaErrors.json", 401,
                "https://demoqa.com/Account/v1/User/" + RandomStringUtils.randomAlphabetic(20), token);
    }
}
