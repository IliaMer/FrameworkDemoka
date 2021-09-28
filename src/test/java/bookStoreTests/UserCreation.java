package bookStoreTests;


import BookStore.User;
import api.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreation {
    private static User user = new User();

    @Test
    @DisplayName("Create user")
    @Order(1)
    void createUser() {
        Post post = new Post(user, "jsonSchemas/CreateUser.json", 201,
                "https://demoqa.com/Account/v1/User");
    }

    @Test
    @DisplayName("Re-create user")
    @Order(2)
    void reCreateUser() {
        Post post = new Post(user, "jsonSchemas/Errors.json", 406,
                "https://demoqa.com/Account/v1/User");
    }

    @Test
    @DisplayName("password validation check")
    @Order(3)
    void PasswordValidationCheck() {
        User user = new User();
        user.setPassword(RandomStringUtils.randomAlphabetic(6));
        Post post = new Post(user, "jsonSchemas/Errors.json", 400,
                "https://demoqa.com/Account/v1/User");
    }
}
