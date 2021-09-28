package bookStoreTests;

import BookStore.User;
import api.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Authorization {

    private static User user = new User();

    @BeforeEach
    void setup() {
        Post post = new Post(user, "https://demoqa.com/Account/v1/User");
    }

    @Test
    @DisplayName("User authorization")
    @Order(1)
    void authorization() {
        Post post = new Post(user, "jsonSchemas/Authorization.json", 200,
                "https://demoqa.com/Account/v1/Authorized");
    }

    // тест падает, т.к. получаем StatusCode 404 вместо 400
    @Test
    @DisplayName("User authorization with invalid params")
    @Order(2)
    void authorizationError() {
        Post post = new Post(new User(), "jsonSchemas/Errors.json", 400,
                "https://demoqa.com/Account/v1/Authorized");
    }

    // тест падает, т.к. получаем StatusCode 404 вместо 400
    @Test
    @DisplayName("User authorization with invalid password")
    @Order(3)
    void authorizationErrorWithInvalidPassword() {
        user.setPassword(RandomStringUtils.randomAlphabetic(10));
        Post post = new Post(user, "jsonSchemas/Errors.json", 400,
                "https://demoqa.com/Account/v1/Authorized");
    }
}
