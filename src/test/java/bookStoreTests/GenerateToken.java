package bookStoreTests;

import BookStore.User;
import api.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GenerateToken {
    private static User user = new User();


    @BeforeEach
    void setup() {
        Post post = new Post(user, "https://demoqa.com/Account/v1/User");
    }


    @Test
    @DisplayName("Generate token")
    @Order(1)
    void generateToken() {
        Post post = new Post(user, "Schemas/jsonSchemaGenerateToken.json", 200,
                "https://demoqa.com/Account/v1/GenerateToken");
    }

    //тест падает из-за того, что при создании токена для несществующего юзера получаем StatusCode 200
    @Test
    @DisplayName("Generate token with invalid user name")
    @Order(2)
    void generateTokenError() {
        Post post = new Post(new User(), "Schemas/jsonSchemaErrors.json", 400,
                "https://demoqa.com/Account/v1/GenerateToken");
    }

    //тест падает из-за того, что не рбаотает валидация на пароль и получаем StatusCode 200
    @Test
    @DisplayName("Generate token with invalid password")
    @Order(3)
    void generateTokenWithInvalidPassword() {
        user.setPassword(RandomStringUtils.randomAlphabetic(10));
        Post post = new Post(user, "Schemas/jsonSchemaErrors.json", 400,
                "https://demoqa.com/Account/v1/GenerateToken");
    }
}
