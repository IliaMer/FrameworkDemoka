package bookStoreTests;


import BookStore.User;
import api.Post;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreation {
    private static User user = new User();

    @Test
    @DisplayName("Create user")
    @Order(1)
    void createUser() {
        Post post = new Post(user, "Schemas/jsonSchemaCreateUser.json", 201,
                "https://demoqa.com/Account/v1/User");
    }

    @Test
    @DisplayName("Re-create user")
    @Order(2)
    void reCreateUser() {
        Post post = new Post(user, "Schemas/jsonSchemaErrors.json", 406,
                "https://demoqa.com/Account/v1/User");
    }
}
